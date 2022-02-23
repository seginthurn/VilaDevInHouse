package br.com.inthurn.VilaDevInHouse.model.transport;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDTO implements Serializable {
    private String username;
    private String password;
    private List<RoleDTO> roles;
}
