package br.com.inthurn.VilaDevInHouse.model.entity;

import br.com.inthurn.VilaDevInHouse.model.transport.entities.VillagerDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "villager")
public class VillagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String cpf;
    private Date birthday;
    private BigDecimal income;
    private String externalId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserEntity user;

    public VillagerEntity() {
    }

    public VillagerEntity(Long id, String name, String surname, String cpf, Date birthday, BigDecimal income, String externalId, UserEntity user) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.birthday = birthday;
        this.income = income;
        this.externalId = externalId;
        this.user = user;
    }

    public VillagerEntity(String name, String surname, String cpf, Date birthday, BigDecimal income, String externalId, UserEntity user) {
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.birthday = birthday;
        this.income = income;
        this.externalId = externalId;
        this.user = user;
    }

    public VillagerDTO convertToDTO(){
        return new VillagerDTO(this.name, this.surname, this.cpf, this.birthday, this.income, this.externalId, this.user.convertToDTO());
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
