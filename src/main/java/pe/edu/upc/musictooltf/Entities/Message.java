package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(name = "descriptionMessage",nullable = false,length = 500)
    private String descriptionMessage ;

    @Column(name = "dateMEssage",nullable = false)
    private LocalDate dateMessage;

    public Message() {
    }

    public Message(Integer idMessage, String descriptionMessage, LocalDate dateMessage) {
        this.idMessage = idMessage;
        this.descriptionMessage = descriptionMessage;
        this.dateMessage = dateMessage;
    }

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
