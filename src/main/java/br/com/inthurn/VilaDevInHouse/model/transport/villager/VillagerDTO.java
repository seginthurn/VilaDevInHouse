package br.com.inthurn.VilaDevInHouse.model.transport.villager;

import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.View;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VillagerDTO {
    private Integer id;
    private String name;
    private String surname;
    private Date birthday;
    private BigDecimal income;
    private String cpf;
    private String email;
    private String password;

    public VillagerDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public VillagerDTO(String name, String surname, Date birthday, BigDecimal income, String cpf, String email) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
        this.email = email;
    }

    public VillagerDTO(Integer id, String name, String surname, Date birthday, BigDecimal income, String cpf) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
    }

    public VillagerDTO(String name, String surname, Date birthday, BigDecimal income, String cpf, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }


}
