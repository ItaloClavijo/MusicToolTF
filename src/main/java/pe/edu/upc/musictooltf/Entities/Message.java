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

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat_id;

    public Message() {
    }

    public Message(Integer idMessage, String descriptionMessage, LocalDate dateMessage, Chat chat_id) {
        this.idMessage = idMessage;
        this.descriptionMessage = descriptionMessage;
        this.dateMessage = dateMessage;
        this.chat_id = chat_id;
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

    public Chat getChat_id() {
        return chat_id;
    }

    public void setChat_id(Chat chat_id) {
        this.chat_id = chat_id;
    }
}
