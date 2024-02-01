package com.example.demo.controller;

import com.example.demo.dto.DTOMapper;
import com.example.demo.dto.DocumentDTO;
import com.example.demo.dto.EmpruntDTO;
import com.example.demo.dto.LateDocumentDTO;
import com.example.demo.model.Document;
import com.example.demo.model.Emprunt;
import com.example.demo.service.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EmpruntController {
    @Autowired
    private MediathequeService mediathequeService;

    @GetMapping("emprunts")
    public List<EmpruntDTO> getAll() {
        return mediathequeService.getAllEmprunts()
                .stream().map(DTOMapper::convertEmpruntToDTO)
                .toList();
    }

    @PostMapping("emprunts")
    public ResponseEntity<?> save(@RequestBody Emprunt emprunt) {
        List<String> errors = getEmpruntPostErrors(emprunt);
        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            mediathequeService.getAdherentById(emprunt.getAdherent().getId())
                                .ifPresent(emprunt::setAdherent);

            mediathequeService.getDocumentById(emprunt.getDocument().getId())
                                .ifPresent(emprunt::setDocument);

            if(!mediathequeService.emprunter(emprunt.getAdherent(),
                                emprunt.getDocument(), emprunt.getDateStart())) {
                return ResponseEntity.badRequest().body("L'emprunt a echoué !");
            }
            else {
                EmpruntDTO empruntDTO = DTOMapper.convertEmpruntToDTO(emprunt);

                return ResponseEntity.ok(empruntDTO);
            }
        }
    }

    @PutMapping("emprunts/{id}/rendre")
    public ResponseEntity<?> rendreDocument(@PathVariable("id") Integer id) {
        Optional<Emprunt> op = mediathequeService.getEmpruntById(id);

        if(op.isPresent()) {
            Emprunt emprunt = op.get();

            if(emprunt.getIsOngoing().equals(false)) {
                return ResponseEntity.ok("Le document a dèjà été rendu !");
            }
            else {
                mediathequeService.rendre(emprunt);
                return ResponseEntity.ok("Le document a été rendu avec succès !");
            }
        }
        else {
            return ResponseEntity.badRequest().body("Emprunt avec id " + id + " inexistant !");
        }

    }

    @GetMapping("emprunts/retards")
    public List<LateDocumentDTO> getAllLateEmprunts() {
        List<Emprunt> lateEmprunts = mediathequeService.getAllEmprunts()
                .stream().filter(e -> e.isLate() && e.getIsOngoing().equals(true))
                .toList();

        return lateEmprunts.stream()
                .map(DTOMapper::buildLateDocumentDTOFromEmprunt)
                .toList();
    }

    private List<String> getEmpruntPostErrors(Emprunt emprunt) {
        List<String> errors = new ArrayList<>();

        if(emprunt.getAdherent() == null ) {
            errors.add("Adherent obligatoire !");
        }

        if(emprunt.getDocument() == null ) {
            errors.add("Document obligatoire !");
        }

        if(!emprunt.getDocument().getIsAvailable()) {
            errors.add("Ce document n'est pas disponible !");
        }

        if(mediathequeService.getAllDocuments().stream()
                .noneMatch(d -> emprunt.getDocument().getId().equals(d.getId()))) {
            errors.add("Document avec id "+ emprunt.getDocument().getId() + " inexistant !");
        }

        if(mediathequeService.getAllAdherents().stream()
                .noneMatch(a -> emprunt.getAdherent().getId().equals(a.getId()))) {
            errors.add("Adherent avec id "+ emprunt.getDocument().getId() + " inexistant !");
        }

        return errors;
    }
}
