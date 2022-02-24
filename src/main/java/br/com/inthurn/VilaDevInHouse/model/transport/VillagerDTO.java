package br.com.inthurn.VilaDevInHouse.model.transport;

import br.com.inthurn.VilaDevInHouse.model.entity.User;
import br.com.inthurn.VilaDevInHouse.utilities.UUIDManager;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class VillagerDTO implements Serializable {

    public static final Long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String surname;
    private Date birthday;
    private BigDecimal income;
    private String cpf;
    private String username;
    private String password;
    private String externalId = UUIDManager.generate();
    private User user;

    public VillagerDTO(String name, String surname, Date birthday, BigDecimal income, String cpf, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
        this.username = username;
        this.password = password;
        this.user = new UserDTO(username, password).convertToEntity();
    }

}
