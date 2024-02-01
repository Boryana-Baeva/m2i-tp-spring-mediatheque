package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;

    @Column(name = "is_ongoing")
    private Boolean isOngoing = true;

    @Column(name = "duree_jours")
    private Integer dureeJours = 30;


    public Emprunt() {
        this.dateStart = LocalDate.now();
    }

    public Emprunt(Document document, Adherent adherent) {
        this.dateStart = LocalDate.now();
        this.document = document;
        this.adherent = adherent;
    }

    public Emprunt(Document document, Adherent adherent, LocalDate dateStart) {
        this.document = document;
        this.adherent = adherent;
        this.dateStart = dateStart;
    }

    public Emprunt(Document document, Adherent adherent, LocalDate dateStart, Integer dureeJours) {
        this.document = document;
        this.adherent = adherent;
        this.dateStart = dateStart;
        this.dureeJours = dureeJours;
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

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public Boolean getIsOngoing() {
        return isOngoing;
    }

    public void setIsOngoing(Boolean isOngoing) {
        this.isOngoing = isOngoing;
    }

    public Integer getDureeJours() {
        return dureeJours;
    }

    public void setDureeJours(Integer dureeJours) {
        this.dureeJours = dureeJours;
    }

    public boolean isLate() {
        return LocalDate.now().isAfter(dateStart.plusDays(dureeJours)) && isOngoing.equals(true);
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", document=" + document.getTitre() +
                ", adherent=" + adherent.getNumeroAdherant() +
                ", date start=" + dateStart +
                '}';
    }
}