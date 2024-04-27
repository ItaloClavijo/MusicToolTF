package pe.edu.upc.musictooltf.DTOs;

public class  UserDTO {
    private Long id;
    private String userName;
    private String userPassword;
    private Boolean userEnabled;

    public UserDTO(Long id, String userName, String userPassword, Boolean userEnabled) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEnabled = userEnabled;
    }
    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(Boolean userEnabled) {
        this.userEnabled = userEnabled;
    }
}
