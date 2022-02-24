package br.com.inthurn.VilaDevInHouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Villager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Date birthday;
    private BigDecimal income;
    private String cpf;
    private String externalId;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    public Villager() {
    }

    public Villager(Long id, String name, String surname, Date birthday, BigDecimal income, String cpf, String externalId, UserEntity user) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
        this.externalId = externalId;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Villager{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", income=" + income +
                ", cpf='" + cpf + '\'' +
                ", externalId='" + externalId + '\'' +
                ", user=" + user +
                '}';
    }
}
