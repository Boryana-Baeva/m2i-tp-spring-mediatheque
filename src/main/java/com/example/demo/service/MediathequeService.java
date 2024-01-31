package com.example.demo.service;

import com.example.demo.model.Adherent;
import com.example.demo.model.Document;
import com.example.demo.model.Emprunt;
import com.example.demo.repository.AdherentRepository;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediathequeService {
    @Autowired
    private AdherentRepository adherentRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private EmpruntRepository empruntRepository;

    /** ADHERENT */
    public void saveAdherent(Adherent adherent) {
        adherentRepository.save(adherent);
    }

    public List<Adherent> getAllAdherents() {
        return adherentRepository.findAll();
    }

    /** DOCUMENT */
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    /** EMPRUNT */
    public void saveEmprunt(Emprunt emprunt) {
        empruntRepository.save(emprunt);
    }

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

}
