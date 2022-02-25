package br.com.inthurn.VilaDevInHouse.model.transport;

import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO implements Serializable {

    public static final Long serialVersionUID = 1L;

    private String username;
    private String password;
    private List<RoleDTO> roles = new ArrayList<>();

    public UserDTO() {
        super();
    }

    public UserDTO(String username, String password, List<RoleDTO> roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = verifyRoleDTO(roles);
    }

    public UserEntity convertToEntity(){
        return new UserEntity(username, password, roles.stream().map(RoleDTO::convertToEntity).collect(Collectors.toList()));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public List<RoleDTO> verifyRoleDTO(List<RoleDTO> roleDTOList){
        if(roleDTOList == null){
            this.roles.add(new RoleDTO("USER"));
        }
        return roleDTOList;
    }
}
