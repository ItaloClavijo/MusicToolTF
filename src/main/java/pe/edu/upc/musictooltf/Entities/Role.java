package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

@Entity
@Table(name ="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 35)
    private String roleName;

    @Column(name = "description",nullable = false, length = 255)
    private String roleDescription;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    public Role() {
    }

    public Role(Integer id, String roleName, String roleDescription, User userId) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

}