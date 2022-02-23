package br.com.inthurn.VilaDevInHouse.model.transport;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class UserDTO implements Serializable {
    private String username;
    private String password;
    private List<RoleDTO> roles;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
