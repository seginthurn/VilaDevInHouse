package br.com.inthurn.VilaDevInHouse.model.transport;

import br.com.inthurn.VilaDevInHouse.model.entity.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class UserDTO implements Serializable {
    private String username;
    private String password;
    private UUID externalId;
    private List<Role> roles;

}
