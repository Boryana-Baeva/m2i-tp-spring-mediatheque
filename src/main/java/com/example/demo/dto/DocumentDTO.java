package com.example.demo.dto;

import java.io.Serializable;

public class DocumentDTO implements Serializable {
    private String titre;
    private String type;
    private String disponible;
    public DocumentDTO() {
    }

    public DocumentDTO(String titre, String type, String disponible) {
        this.titre = titre;
        this.type = type;
        this.disponible = disponible;
    }

    public String getTitre() {
        return titre;
    }

    public String getType() {
        return type;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "titre = " + titre + ", " +
                "type = " + type + ", " +
                "isAvailable = " + disponible + ")";
    }
}