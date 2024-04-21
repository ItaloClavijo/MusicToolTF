package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@Table(name = "Comentary")
public class Comentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coment", nullable = false, length = 255)
    private String comentatyComent;

    @Column(name = "date", nullable = false)
    private LocalDate comentaryDate;
    @ManyToOne
    @JoinColumn(name = "contentId")

    private Content contentId;

    public Comentary(Integer id, String comentatyComent, LocalDate comentaryDate, Content contentId) {
        this.id = id;
        this.comentatyComent = comentatyComent;
        this.comentaryDate = comentaryDate;
        this.contentId = contentId;
    }

    public Comentary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentatyComent() {
        return comentatyComent;
    }

    public void setComentatyComent(String comentatyComent) {
        this.comentatyComent = comentatyComent;
    }

    public LocalDate getComentaryDate() {
        return comentaryDate;
    }

    public void setComentaryDate(LocalDate comentaryDate) {
        this.comentaryDate = comentaryDate;
    }

    public Content getContentId() {
        return contentId;
    }

    public void setContentId(Content contentId) {
        this.contentId = contentId;
    }
}

