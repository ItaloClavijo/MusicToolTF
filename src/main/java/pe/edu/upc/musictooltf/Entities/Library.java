package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "available",nullable = false)
    private Boolean libraryAvailable;

    @Column(name = "name",nullable = false, length = 100)
    private String libraryName;

    @Column(name = "description",nullable = false, length = 100)
    private String libraryDescription;

    public Library(Integer id, Boolean libraryAvailable, String libraryName, String libraryDescription) {
        this.id = id;
        this.libraryAvailable = libraryAvailable;
        this.libraryName = libraryName;
        this.libraryDescription = libraryDescription;
    }

    public Library() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getLibraryAvailable() {
        return libraryAvailable;
    }

    public void setLibraryAvailable(Boolean libraryAvailable) {
        this.libraryAvailable = libraryAvailable;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryDescription() {
        return libraryDescription;
    }

    public void setLibraryDescription(String libraryDescription) {
        this.libraryDescription = libraryDescription;
    }
}
