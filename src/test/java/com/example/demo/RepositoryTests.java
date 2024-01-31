package com.example.demo;

import com.example.demo.model.Adherent;
import com.example.demo.model.Document;
import com.example.demo.model.DocumentType;
import com.example.demo.repository.AdherentRepository;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.EmpruntRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTests {
    @Autowired
    private AdherentRepository adherentRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private EmpruntRepository empruntRepository;

    @Test
    void testSaveAdherent() {
        Adherent a1 = new Adherent("Tom", "Grey");
        adherentRepository.save(a1);

        Adherent a2 = new Adherent();
        a2.setPrenom("Jim");
        a2.setNom("Davis");
        adherentRepository.save(a2);
    }

    @Test
    void testShowAdherents() {
        adherentRepository.findAll().forEach(System.out::println);
    }

    @Test
    void testSaveDocument() {
        Document d1 = new Document("The Great Gatsby", DocumentType.BOOK);
        documentRepository.save(d1);

        Document d2 = new Document("It's a wonderful life", DocumentType.FILM);
        documentRepository.save(d2);
    }

    @Test
    void testShowDocuments() {
        documentRepository.findAll().forEach(System.out::println);
    }

}
