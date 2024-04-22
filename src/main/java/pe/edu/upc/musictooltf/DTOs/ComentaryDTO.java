package pe.edu.upc.musictooltf.DTOs;


import pe.edu.upc.musictooltf.Entities.Content;

import java.time.LocalDate;

public class ComentaryDTO {
    private Integer idComent;

    private String comentatyComent;

    private LocalDate comentaryDate;

    private Content contentId;

    public Integer getId() {return idComent;
    }

    public void setId(Integer id) {
        this.idComent = id;
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
