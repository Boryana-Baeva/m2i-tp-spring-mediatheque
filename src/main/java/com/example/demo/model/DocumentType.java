package com.example.demo.model;

public enum DocumentType {
    BOOK("Livre"),
    ARTICLE("Article"),
    FILM("Film / Documentaire"),
    IMAGE("Image / Photo");

    public final String typeName;
    DocumentType(String typeName) {
        this.typeName = typeName;
    }
}
