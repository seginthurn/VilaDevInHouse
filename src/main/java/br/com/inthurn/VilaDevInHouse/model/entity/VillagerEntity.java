package br.com.inthurn.VilaDevInHouse.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillagerEntity {

    private Integer id;
    private String name;
    private String surname;
    private Date birthday;
    private BigDecimal income;
    private String cpf;
    private Integer appUser_id;

    public VillagerEntity(String name, String surname, Date birthday, BigDecimal income, String cpf) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
    }
}
