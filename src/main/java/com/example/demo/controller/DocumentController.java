package com.example.demo.controller;

import com.example.demo.model.Adherent;
import com.example.demo.model.Document;
import com.example.demo.service.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class DocumentController {
    @Autowired
    private MediathequeService mediathequeService;

    @GetMapping("documents")
    public List<Document> getAll() {
        return mediathequeService.getAllDocuments();
    }

    @PostMapping("documents")
    public ResponseEntity<?> save(@RequestBody Document document) {
        List<String> errors = getDocumentPostErrors(document);
        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            mediathequeService.saveDocument(document);
            return ResponseEntity.ok(document);
        }
    }

    private List<String> getDocumentPostErrors(Document document) {
        List<String> errors = new ArrayList<>();

        if(document.getTitre() == null || document.getTitre().isBlank()) {
            errors.add("Titre du document obligatoire !");
        }

        if(document.getType() == null || document.getType().name().isBlank()) {
            errors.add("Type du document obligatoire !");
        }

        if(document.getIsAvailable() == null) {
            errors.add("Disponibilité du document obligatoire !");
        }

        if(mediathequeService.getAllDocuments().stream()
                .anyMatch(d -> document.getTitre().equals(d.getTitre()))) {
            errors.add("Un document avec ce titre existe déjà !");
        }
        return errors;
    }
}
