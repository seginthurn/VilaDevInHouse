package br.com.inthurn.VilaDevInHouse.model.entity;

<<<<<<< Updated upstream
import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;
=======
import br.com.inthurn.VilaDevInHouse.interfaces.LocalEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.user.UserDTO;
import br.com.inthurn.VilaDevInHouse.service.utilities.UUIDManager;
>>>>>>> Stashed changes

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "app_user")
public class UserEntity implements LocalEntity<UserDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private UUID externalId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<RoleEntity> roles = new ArrayList<>();

    public UserEntity() {
        super();
    }

    public UserEntity(Long id, String username, String password, UUID externalId, List<RoleEntity> roles) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
<<<<<<< Updated upstream
        this.externalId = external_id;
        this.roles = roles;
    }

    public UserEntity(String username, String password, UUID external_id, List<RoleEntity> roles) {
        this.username = username;
        this.password = password;
        this.externalId = external_id;
        this.roles = roles;
=======
        this.externalId = checkIfUUIDIsNotNull(externalId);
        this.roles = roles;
    }

    private UUID checkIfUUIDIsNotNull(UUID uuid){
        if(uuid == null){
            return UUIDManager.generate();
        }

        return uuid;
>>>>>>> Stashed changes
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

<<<<<<< Updated upstream
    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
=======
    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
>>>>>>> Stashed changes
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity user = (UserEntity) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(externalId, user.externalId) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, externalId, roles);
    }

<<<<<<< Updated upstream
    public UserDTO convertToDTO(){
        return new UserDTO(this.username, this.password, this.externalId, this.roles);
=======
    @Override
    public UserDTO convertToDTO() {
        return new UserDTO(this.id, this.username, this.password, this.externalId, this.roles);
>>>>>>> Stashed changes
    }
}
