package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emprunts")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "adherent_id")
    private Adherent adherent;

    public Emprunt() {
    }

    public Emprunt(Document document, Adherent adherent) {
        this.document = document;
        this.adherent = adherent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", document=" + document.getTitre() +
                ", adherent=" + adherent.getNumeroAdherant() +
                '}';
    }
}