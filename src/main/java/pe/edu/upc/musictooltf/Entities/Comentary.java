package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@Table(name = "Comentary")
public class Comentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComent;

    @Column(name = "coment", nullable = false, length = 255)
    private String comentaryComent;

    @Column(name = "date", nullable = false)
    private LocalDate comentaryDate;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content contentId;

    public Comentary(Integer id, String comentatyComent, LocalDate comentaryDate, Content contentId) {
        this.idComent = id;
        this.comentaryComent = comentatyComent;
        this.comentaryDate = comentaryDate;
        this.contentId = contentId;
    }

    public Comentary() {
    }

    public Integer getIdComent() {
        return idComent;
    }

    public void setIdComent(Integer idComent) {
        this.idComent = idComent;
    }

    public String getComentaryComent() {
        return comentaryComent;
    }

    public void setComentaryComent(String comentaryComent) {
        this.comentaryComent = comentaryComent;
    }
}

