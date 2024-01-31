package com.example.demo.model;

import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "adherents")
public class Adherent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "numero_adherant", unique = true)
    private String numeroAdherant;

    @Column(name = "date_expiration_abonnement")
    private LocalDate dateExpirationAbonnement;

    @OneToMany(mappedBy = "adherent", orphanRemoval = true)
    private List<Emprunt> emprunts = new ArrayList<>();

    @Column(name = "date_start_abonnement")
    private LocalDate dateStartAbonnement;

    public LocalDate getDateStartAbonnement() {
        return dateStartAbonnement;
    }

    public void setDateStartAbonnement(LocalDate dateStartAbonnement) {
        this.dateStartAbonnement = dateStartAbonnement;
    }

    public Adherent() {
        this.numeroAdherant = generateNewNumeroAdherent();
        this.dateStartAbonnement = LocalDate.now();
        this.dateExpirationAbonnement = this.dateStartAbonnement.plusYears(1);
    }

    public Adherent(String prenom, String nom) {
        super();
        this.prenom = prenom;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroAdherant() {
        return numeroAdherant;
    }

    public void setNumeroAdherant(String numeroAdherant) {
        this.numeroAdherant = numeroAdherant;
    }

    public LocalDate getDateExpirationAbonnement() {
        return dateExpirationAbonnement;
    }

    public void setDateExpirationAbonnement(LocalDate dateExpirationAbonnement) {
        this.dateExpirationAbonnement = dateExpirationAbonnement;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public void addEmprunt(Emprunt emprunt) {
        this.emprunts.add(emprunt);
    }

    private String generateNewNumeroAdherent() {
        int length = 10;
        boolean useLetters = false;
        boolean useNumbers = true;

        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    @Override
    public String toString() {
        return "Adherent{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", numeroAdherant='" + numeroAdherant + '\'' +
                '}';
    }
}