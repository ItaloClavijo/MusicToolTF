package pe.edu.upc.musictooltf.DTOs;

public class ArtistDTO {
    private Integer idArtist;

    private String nameArtist;

    private String descriptionArtist;

    private String emailArtist;

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
