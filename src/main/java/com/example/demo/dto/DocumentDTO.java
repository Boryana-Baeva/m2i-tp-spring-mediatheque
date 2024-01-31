package com.example.demo.dto;

import com.example.demo.model.DocumentType;

import java.io.Serializable;
import java.util.Objects;

public class DocumentDTO implements Serializable {
    private String titre;
    private String type;
    private Boolean isAvailable;

    public DocumentDTO() {
    }

    public DocumentDTO(String titre, String type, Boolean isAvailable) {
        this.titre = titre;
        this.type = type;
        this.isAvailable = isAvailable;
    }

    public String getTitre() {
        return titre;
    }

    public String getType() {
        return type;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "titre = " + titre + ", " +
                "type = " + type + ", " +
                "isAvailable = " + isAvailable + ")";
    }
}