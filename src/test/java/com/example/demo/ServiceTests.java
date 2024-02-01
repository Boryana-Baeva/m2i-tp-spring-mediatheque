package com.example.demo;

import com.example.demo.model.Adherent;
import com.example.demo.model.Document;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Emprunt;
import com.example.demo.service.MediathequeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ServiceTests {
    @Autowired
    private MediathequeService mediathequeService;

    @Test
    void testEmprunter() {
        Adherent a1 = new Adherent("Tom", "Grey");
        mediathequeService.saveAdherent(a1);
        Document d1 = new Document("Casablanca", DocumentType.FILM);
        mediathequeService.saveDocument(d1);

        mediathequeService.emprunter(a1, d1, LocalDate.now());
    }

    @Test
    void testRendre() {
        if(mediathequeService.getEmpruntById(1).isPresent()) {
            Emprunt e = mediathequeService.getEmpruntById(1).get();

            mediathequeService.rendre(e);
        }
        else {
            System.out.println("Error in method Rendre !");
        }
    }
}
