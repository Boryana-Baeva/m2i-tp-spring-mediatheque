package com.example.demo.controller;

import com.example.demo.model.Adherent;
import com.example.demo.repository.AdherentRepository;
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
    @Autowired
    private AdherentRepository adherentRepository;

    @GetMapping("adherents")
    public List<Adherent> getAll() {
        return mediathequeService.getAllAdherents();
    }

    @PostMapping("adherents")
    public ResponseEntity<?> save(@RequestBody Adherent adherent) {
        if(!getAdherentPostErrors(adherent).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        else {
            adherentRepository.save(adherent);
            return ResponseEntity.ok(adherent);
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

        if(adherentRepository.findAll().stream()
                .anyMatch(a -> adherent.getNumeroAdherant().equals(a.getNumeroAdherant()))) {
            errors.add("Numéro d'adhérent déjà existant !");
        }
        return errors;
    }
}
