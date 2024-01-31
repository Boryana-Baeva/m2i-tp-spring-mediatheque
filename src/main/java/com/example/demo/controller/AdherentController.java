package com.example.demo.controller;

import com.example.demo.dto.AdherentDTO;
import com.example.demo.dto.DTOMapper;
import com.example.demo.model.Adherent;
import com.example.demo.service.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class AdherentController {
    @Autowired
    private MediathequeService mediathequeService;

    @GetMapping("adherents")
    public List<AdherentDTO> getAll() {
        return mediathequeService.getAllAdherents()
                .stream().map(DTOMapper::convertAdherentToDTO)
                .toList();
    }

    @PostMapping("adherents")
    public ResponseEntity<?> save(@RequestBody Adherent adherent) {
        List<String> errors = getAdherentPostErrors(adherent);
        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            mediathequeService.saveAdherent(adherent);
            AdherentDTO dto = DTOMapper.convertAdherentToDTO(adherent);
            return ResponseEntity.ok(dto);
        }
    }

    private List<String> getAdherentPostErrors(Adherent adherent) {
        List<String> errors = new ArrayList<>();

        if(adherent.getPrenom() == null || adherent.getPrenom().isBlank()) {
            errors.add("Prénom de l'adhérent obligatoire !");
        }

        if(adherent.getNom() == null || adherent.getNom().isBlank()) {
            errors.add("Nom de l'adhérent obligatoire !");
        }

        if(adherent.getNumeroAdherant() == null || adherent.getNumeroAdherant().isBlank()) {
            errors.add("Numéro d'adhérent obligatoire !");
        }

        if(mediathequeService.getAllAdherents().stream()
                .anyMatch(a -> adherent.getNumeroAdherant().equals(a.getNumeroAdherant()))) {
            errors.add("Numéro d'adhérent déjà existant !");
        }
        return errors;
    }
}
