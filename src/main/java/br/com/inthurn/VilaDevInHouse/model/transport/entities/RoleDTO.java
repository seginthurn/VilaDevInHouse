package br.com.inthurn.VilaDevInHouse.model.transport.entities;

import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


public class RoleDTO implements Serializable {

    public static final Long serialVersionUID = 1L;

    private String permission;

    public RoleDTO() {
    }

    public RoleDTO(String permission) {
        this.permission = permission;
    }

    public RoleEntity convertToEntity(){
        return new RoleEntity(this.permission);
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
