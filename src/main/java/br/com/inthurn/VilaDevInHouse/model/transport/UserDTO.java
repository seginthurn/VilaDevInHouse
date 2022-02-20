package br.com.inthurn.VilaDevInHouse.model.transport;

import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserDTO implements Serializable {

    private String username;
    private String password;
    private UUID external_id;
    private List<RoleEntity> roles;


    public UserEntity convertToEntity(){
        return new UserEntity(this.username, this.password, this.external_id , this.roles);
    }

    public UserDTO(String username, String password, UUID external_id, List<RoleEntity> roles) {
        this.username = username;
        this.password = password;
        this.external_id = checkIfUUIDIsNull(null);
        this.roles = roles;

    }

    private UUID checkIfUUIDIsNull(UUID external_id){
        if(external_id == null){
            return UUID.randomUUID();
        }

        return external_id;
    }

    private List<RoleEntity> checkIfRolesIsNull(List<RoleEntity> roles){
        if(roles == null){
            List<RoleEntity> standardRoles = new ArrayList<>();
            standardRoles.add(new RoleEntity("USER"));

            return standardRoles;
        }

        return roles;
    }
}
