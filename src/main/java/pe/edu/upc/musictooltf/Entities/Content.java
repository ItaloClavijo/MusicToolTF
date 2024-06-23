package pe.edu.upc.musictooltf.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContent;
    @Column(name = "titleContent",nullable = false, length = 100)
    private String titleContent;
    @Column(name = "descriptionContent",nullable = false, length = 300)
    private String descriptionContent;
    @Column(name = "priceContent",nullable = false)
    private Double priceContent;
    @Column(name = "freeContent",nullable = false)
    private Boolean freeContent;
    @Column(name = "typeContent",nullable = false)
    private String typeContent;
    @Column(name = "fileContent",nullable = false)
    private String fileContent;
    @Column(name = "coverContent",nullable = false)
    private String coverContent;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library libraryId;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist_id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id")
    private List<Comentary> comentaries;


    public Content() {
    }

    public Content(Integer idContent, String titleContent, String descriptionContent, Double priceContent, Boolean freeContent, String typeContent, String fileContent, String coverContent, Library libraryId, Artist artist_id, List<Comentary> comentaries) {
        this.idContent = idContent;
        this.titleContent = titleContent;
        this.descriptionContent = descriptionContent;
        this.priceContent = priceContent;
        this.freeContent = freeContent;
        this.typeContent = typeContent;
        this.fileContent = fileContent;
        this.coverContent = coverContent;
        this.libraryId = libraryId;
        this.artist_id = artist_id;
        this.comentaries = comentaries;
    }

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

    public String getCoverContent() {
        return coverContent;
    }

    public void setCoverContent(String coverContent) {
        this.coverContent = coverContent;
    }

    public Library getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Library libraryId) {
        this.libraryId = libraryId;
    }

    public Artist getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Artist artist_id) {
        this.artist_id = artist_id;
    }

    public List<Comentary> getComentaries() {
        return comentaries;
    }

    public void setComentaries(List<Comentary> comentaries) {
        this.comentaries = comentaries;
    }
}

