package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDate;

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

}
