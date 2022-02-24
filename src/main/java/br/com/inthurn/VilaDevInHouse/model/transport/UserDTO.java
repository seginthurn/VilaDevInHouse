package br.com.inthurn.VilaDevInHouse.model.transport;

import br.com.inthurn.VilaDevInHouse.model.entity.Role;
import br.com.inthurn.VilaDevInHouse.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    public static final Long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private List<Role> roles = new ArrayList<>();

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles.add(new Role("USER"));
    }

    public User convertToEntity(){
        return new User(username, password, roles);
    }
}
