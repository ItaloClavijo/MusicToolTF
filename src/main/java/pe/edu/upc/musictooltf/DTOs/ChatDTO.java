package pe.edu.upc.musictooltf.DTOs;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.musictooltf.Entities.Users;

import java.time.LocalDate;

public class ChatDTO {
    private Integer idChat;

    private Users user1id;

    private Users user2id;

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Users getUser1id() {
        return user1id;
    }

    public void setUser1id(Users user1id) {
        this.user1id = user1id;
    }

    public Users getUser2id() {
        return user2id;
    }

    public void setUser2id(Users user2id) {
        this.user2id = user2id;
    }
}
