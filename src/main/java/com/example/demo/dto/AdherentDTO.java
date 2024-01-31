package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AdherentDTO implements Serializable {
    private String prenom;
    private String nom;
    private String numeroAdherant;
    private LocalDate dateExpirationAbonnement;

    public AdherentDTO() {
    }

    public AdherentDTO(String prenom, String nom, String numeroAdherant, LocalDate dateExpirationAbonnement) {
        this.prenom = prenom;
        this.nom = nom;
        this.numeroAdherant = numeroAdherant;
        this.dateExpirationAbonnement = dateExpirationAbonnement;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getNumeroAdherant() {
        return numeroAdherant;
    }

    public LocalDate getDateExpirationAbonnement() {
        return dateExpirationAbonnement;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumeroAdherant(String numeroAdherant) {
        this.numeroAdherant = numeroAdherant;
    }

    public void setDateExpirationAbonnement(LocalDate dateExpirationAbonnement) {
        this.dateExpirationAbonnement = dateExpirationAbonnement;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "prenom = " + prenom + ", " +
                "nom = " + nom + ", " +
                "numeroAdherant = " + numeroAdherant + ", " +
                "dateExpirationAbonnement = " + dateExpirationAbonnement + ")";
    }
}