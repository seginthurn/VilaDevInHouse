package br.com.inthurn.VilaDevInHouse.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    private UUID externalId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_has_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )

    private List<Role> roles;

    public User() {
    }

    public User(Long id, String username, String password, UUID externalId, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.externalId = externalId;
        this.roles = roles;
    }

    public User(String username, String password, UUID externalId, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.externalId = externalId;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}