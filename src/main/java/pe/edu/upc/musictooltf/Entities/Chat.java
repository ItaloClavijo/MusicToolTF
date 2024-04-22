package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChat;

    @Column (name = "chatContent",nullable = false)
    private String chatContent;
    @Column(name = "date",nullable = false)
    private LocalDate chatDate;
    @Column(name = "contentId",nullable = false)
    private int contentId;


    public Chat() {
    }

    public Chat(Integer idChat, String chatContent, LocalDate chatDate, int contentId) {
        idChat = idChat;
        this.chatContent = chatContent;
        this.chatDate = chatDate;
        this.contentId = contentId;
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        idChat = idChat;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public LocalDate getChatDate() {
        return chatDate;
    }

    public void setChatDate(LocalDate chatDate) {
        this.chatDate = chatDate;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }
}
