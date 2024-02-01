package com.example.demo.dto;

import com.example.demo.model.Adherent;
import com.example.demo.model.Document;
import com.example.demo.model.Emprunt;

public class DTOMapper {
    /** Convertions Entity to DTO **/
    public static EmpruntDTO convertEmpruntToDTO(Emprunt entity) {
        EmpruntDTO dto = new EmpruntDTO();
        dto.setDate(entity.getDateStart());
        dto.setOngoing(entity.getIsOngoing());

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

    /** Convertions DTO to Entity **/
    public static Adherent convertDTOToAdherent(AdherentDTO dto) {
        Adherent entity = new Adherent();
        entity.setPrenom(dto.getPrenom());
        entity.setNom(dto.getNom());
        entity.setNumeroAdherant(dto.getNumeroAdherant());
        entity.setDateExpirationAbonnement(dto.getDateExpirationAbonnement());
        entity.setDateStartAbonnement(dto.getDateExpirationAbonnement().minusYears(1));
        return entity;
    }
}
