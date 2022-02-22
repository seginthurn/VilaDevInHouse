package br.com.inthurn.VilaDevInHouse.model.entity;

import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "app_user")
public class UserEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private UUID externalId;

    @ManyToMany
    private List<RoleEntity> roles;

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String password, UUID external_id, List<RoleEntity> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.externalId = external_id;
        this.roles = roles;
    }

    public UserEntity(String username, String password, UUID external_id, List<RoleEntity> roles) {
        this.username = username;
        this.password = password;
        this.externalId = external_id;
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

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    public UserDTO convertToDTO(){
        return new UserDTO(this.username, this.password, this.externalId, this.roles);
    }
}
