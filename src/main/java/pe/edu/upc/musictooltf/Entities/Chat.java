package pe.edu.upc.musictooltf.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChat;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private Users user1id;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private Users user2id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id")
    private List<Message> messages;

    public Chat(Integer idChat, Users user1id, Users user2id, List<Message> messages) {
        this.idChat = idChat;
        this.user1id = user1id;
        this.user2id = user2id;
        this.messages = messages;
    }

    public Chat() {
    }

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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
