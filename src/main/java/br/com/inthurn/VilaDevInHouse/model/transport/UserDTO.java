package br.com.inthurn.VilaDevInHouse.model.transport;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDTO implements Serializable {
    private final String username;
    private final String password;
    private final List<RoleDTO> roles;
}
