package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class EmpruntDTO implements Serializable {
    private LocalDate date;
    private boolean ongoing = true;
    private DocumentDTO document;
    private AdherentDTO adherent;

    public EmpruntDTO() {
    }

    public EmpruntDTO(DocumentDTO document, AdherentDTO adherent, LocalDate date) {
        this.document = document;
        this.adherent = adherent;
        this.date = date;
    }

    public DocumentDTO getDocument() {
        return document;
    }

    public AdherentDTO getAdherent() {
        return adherent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDocument(DocumentDTO document) {
        this.document = document;
    }

    public void setAdherent(AdherentDTO adherent) {
        this.adherent = adherent;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    @Override
    public String toString() {
        return "EmpruntDTO{" +
                "date=" + date +
                ", ongoing=" + ongoing +
                ", document=" + document +
                ", adherent=" + adherent +
                '}';
    }
}