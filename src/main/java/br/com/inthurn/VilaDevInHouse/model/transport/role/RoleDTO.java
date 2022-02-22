package br.com.inthurn.VilaDevInHouse.model.transport.role;

import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {

    private Long id;
    private String role;
    private List<UserEntity> users;

    public RoleDTO(String role) {
        this.role = role;
    }


}
