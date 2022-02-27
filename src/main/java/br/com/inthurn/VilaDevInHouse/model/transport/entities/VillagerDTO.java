package br.com.inthurn.VilaDevInHouse.model.transport.entities;

import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VillagerDTO implements Serializable {

    public static final Long serialVersionUID = 1L;

    private String name;
    private String surname;
    private String cpf;
    private Date birthday;
    private BigDecimal income;
    private String externalId;
    private UserDTO user;

    public VillagerDTO() {
    }

    public VillagerDTO(String name, String surname, String cpf, Date birthday, BigDecimal income, String externalId, UserDTO user) {
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.birthday = birthday;
        this.income = income;
        this.externalId = externalId;
        this.user = user;
    }

    public VillagerDTO(String name, BigDecimal income, String externalId) {
        this.name = name;
        this.income = income;
        this.externalId = externalId;
    }

    public VillagerEntity convertToEntity(){
        return new VillagerEntity(this.name, this.surname, this.cpf, this.birthday, this.income, this.externalId, this.user.convertToEntity());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
