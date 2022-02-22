package br.com.inthurn.VilaDevInHouse.model.transport.user;

import br.com.inthurn.VilaDevInHouse.interfaces.LocalDTO;
import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements LocalDTO<UserEntity> {

    private Long id;
    private String username;
    private String password;
    private UUID externalId;
    private List<RoleEntity> roles = new ArrayList<>();

    @Override
    public UserEntity convertToEntity() {
        return new UserEntity(this.id, this.username, this.password, this.externalId, this.roles);
    }
}
