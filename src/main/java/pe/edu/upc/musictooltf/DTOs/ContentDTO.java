package pe.edu.upc.musictooltf.DTOs;

import pe.edu.upc.musictooltf.Entities.Library;

public class ContentDTO {

    private Integer idContent;
    private String titleContent;
    private String descriptionContent;
    private Double priceContent;
    private Boolean freeContent;
    private String typeContent;
    private String fileContent;
    private Library library;

    public Integer getIdContent() {
        return idContent;
    }

    public void setIdContent(Integer idContent) {
        this.idContent = idContent;
    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent;
    }

    public String getDescriptionContent() {
        return descriptionContent;
    }

    public void setDescriptionContent(String descriptionContent) {
        this.descriptionContent = descriptionContent;
    }

    public Double getPriceContent() {
        return priceContent;
    }

    public void setPriceContent(Double priceContent) {
        this.priceContent = priceContent;
    }

    public Boolean getFreeContent() {
        return freeContent;
    }

    public void setFreeContent(Boolean freeContent) {
        this.freeContent = freeContent;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
