package com.example.demo.dto;

import com.example.demo.model.Adherent;
import com.example.demo.model.Document;
import com.example.demo.model.Emprunt;

public class DTOMapper {
    public static EmpruntDTO convertEmpruntToDTO(Emprunt entity) {
        EmpruntDTO dto = new EmpruntDTO();
        dto.setDate(entity.getDateStart());

        AdherentDTO adherentDTO = convertAdherentToDTO(entity.getAdherent());
        dto.setAdherent(adherentDTO);

        DocumentDTO documentDTO = convertDocumentToDTO(entity.getDocument());
        dto.setDocument(documentDTO);

        return dto;
    }

    public static AdherentDTO convertAdherentToDTO(Adherent entity) {
        AdherentDTO dto = new AdherentDTO();
        dto.setPrenom(entity.getPrenom());
        dto.setNom(entity.getNom());
        dto.setNumeroAdherant(entity.getNumeroAdherant());
        dto.setDateExpirationAbonnement(entity.getDateExpirationAbonnement());
        return dto;
    }

    public static DocumentDTO convertDocumentToDTO(Document entity) {
        DocumentDTO dto = new DocumentDTO();
        dto.setTitre(entity.getTitre());
        dto.setType(entity.getType().typeName);
        dto.setDisponible(entity.getIsAvailable() ? "OUI" : "NON");
        return dto;
    }
}
