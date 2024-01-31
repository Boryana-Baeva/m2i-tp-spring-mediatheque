package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titre", unique = true)
    private String titre;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DocumentType type;

    public Document() {
    }

    public Document(String titre, DocumentType type) {
        this.titre = titre;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", type=" + DocumentType.valueOf(type.name()) +
                '}';
    }
}