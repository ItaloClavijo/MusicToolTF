package pe.edu.upc.musictooltf.DTOs;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class MessageDTO {

    private Integer idMessage;


    private String descriptionMessage ;


    private LocalDate dateMessage;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getDescriptionMessage() {
        return descriptionMessage;
    }

    public void setDescriptionMessage(String descriptionMessage) {
        this.descriptionMessage = descriptionMessage;
    }

    public LocalDate getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(LocalDate dateMessage) {
        this.dateMessage = dateMessage;
    }
}
