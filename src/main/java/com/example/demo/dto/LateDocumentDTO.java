package com.example.demo.dto;

public class LateDocumentDTO {
    private String titre;
    private String emprunteur;

    public LateDocumentDTO() {
    }

    public LateDocumentDTO(String titre, String emprunteur) {
        this.titre = titre;
        this.emprunteur = emprunteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(String emprunteur) {
        this.emprunteur = emprunteur;
    }

    @Override
    public String toString() {
        return "LateDocumentDTO{" +
                "titre='" + titre + '\'' +
                ", emprunteur='" + emprunteur + '\'' +
                '}';
    }
}
