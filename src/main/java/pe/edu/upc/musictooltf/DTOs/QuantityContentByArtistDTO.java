package pe.edu.upc.musictooltf.DTOs;

public class QuantityContentByArtistDTO {
    private String nameArtist;

    private Integer quantityContent;

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public Integer getQuantityContent() {
        return quantityContent;
    }

    public void setQuantityContent(Integer quantityContent) {
        this.quantityContent = quantityContent;
    }
}
