package br.com.inthurn.VilaDevInHouse.model.transport;

import br.com.inthurn.VilaDevInHouse.model.entity.Role;
import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class VillagerDTO implements Serializable {
    private String name;
    private String surname;
    private Date birthday;
    private BigDecimal income;
    private String cpf;
    private String email;
    private String password;
    private User user;
    private UUID externalId;

    public VillagerDTO(String name, String surname, Date birthday, BigDecimal income, String cpf, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
        setUser(email, password);
    }

    public void setUser(String email, String password){
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ADMIN"));
        this.user = new User(email, password,UUID.randomUUID(), roles);
    }
}
