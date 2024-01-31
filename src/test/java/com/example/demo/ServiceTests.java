package com.example.demo;

import com.example.demo.model.Adherent;
import com.example.demo.model.Document;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Emprunt;
import com.example.demo.service.MediathequeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        mediathequeService.emprunter(a1, d1);
    }
}
