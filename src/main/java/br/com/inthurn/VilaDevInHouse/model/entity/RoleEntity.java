package br.com.inthurn.VilaDevInHouse.model.entity;

import br.com.inthurn.VilaDevInHouse.interfaces.LocalEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.role.RoleDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name ="app_role")
public class RoleEntity implements LocalEntity<RoleDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;

    public RoleEntity() {
    }

    public RoleEntity(Long id, String role, List<UserEntity> users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }

    public RoleEntity(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(role, that.role) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, users);
    }

    @Override
    public RoleDTO convertToDTO() {
        return new RoleDTO(this.id, this.role, this.users);
    }
}
