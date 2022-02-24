package br.com.inthurn.VilaDevInHouse.model.entity;

import br.com.inthurn.VilaDevInHouse.model.transport.RoleDTO;

import javax.persistence.*;

@Entity
@Table(name = "app_role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String permission;

    public RoleEntity() {
    }

    public RoleEntity(Long id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public RoleEntity(String permission) {
        this.permission = permission;
    }

    public RoleDTO convertToDTO(){
        return new RoleDTO(this.permission);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}
