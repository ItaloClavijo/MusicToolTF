package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArtist;

    @Column(name = "name", nullable = false, length = 30)
    private String nameArtist;

    @Column(name = "description", nullable = false, length = 250)
    private String descriptionArtist;

    @Column(name = "email", nullable = false, length = 100)
    private String emailArtist;

    public Artist(Integer idArtist, String nameArtist, String descriptionArtist, String emailArtist) {
        this.idArtist = idArtist;
        this.nameArtist = nameArtist;
        this.descriptionArtist = descriptionArtist;
        this.emailArtist = emailArtist;
    }

    public Artist() {
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getDescriptionArtist() {
        return descriptionArtist;
    }

    public void setDescriptionArtist(String descriptionArtist) {
        this.descriptionArtist = descriptionArtist;
    }

    public String getEmailArtist() {
        return emailArtist;
    }

    public void setEmailArtist(String emailArtist) {
        this.emailArtist = emailArtist;
    }
}
