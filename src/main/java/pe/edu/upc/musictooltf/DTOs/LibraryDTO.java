package pe.edu.upc.musictooltf.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class LibraryDTO {
    private Integer id;
    private Boolean libraryAvailable;
    private String libraryName;
    private String libraryDescription;

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
