package br.com.inthurn.VilaDevInHouse.model.transport.villager;

import br.com.inthurn.VilaDevInHouse.model.entity.utilities.DateUtility;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VillagerDTO {

    private Integer id;
    private String name;
    private String surname;
    private Date birthday;
    private String formattedBirthday;
    private BigDecimal income;
    private String cpf;
    private String email;
    private String password;

    //For system converts a VillagerEntity to VillagerDTO
    public VillagerDTO(Integer id, String name, String surname, Date birthday, BigDecimal income, String cpf) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.formattedBirthday = DateUtility.dateFormatter(birthday);
        this.income = income;
        this.cpf = cpf;
    }

    //For register a new Villager
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
