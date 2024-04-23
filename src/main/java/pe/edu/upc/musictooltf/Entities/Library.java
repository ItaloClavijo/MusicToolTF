package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "libraryAvailable",nullable = false)
    private Boolean libraryAvailable;

    @Column(name = "libraryName",nullable = false, length = 100)
    private String libraryName;

    @Column(name = "libraryDescription",nullable = false, length = 100)
    private String libraryDescription;

    @ManyToOne
    @JoinColumn(name = "user_idl")
    private Users usersId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id")
    private List<Content> contentId;

    public Library(Integer id, Boolean libraryAvailable, String libraryName, String libraryDescription, Users usersId, List<Content> contentId) {
        this.id = id;
        this.libraryAvailable = libraryAvailable;
        this.libraryName = libraryName;
        this.libraryDescription = libraryDescription;
        this.usersId = usersId;
        this.contentId = contentId;
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

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    public List<Content> getContentId() {
        return contentId;
    }

    public void setContentId(List<Content> contentId) {
        this.contentId = contentId;
    }
}
