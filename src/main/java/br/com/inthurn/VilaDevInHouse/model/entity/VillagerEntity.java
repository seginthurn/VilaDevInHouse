package br.com.inthurn.VilaDevInHouse.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "villager")
public class VillagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Date birthday;
    private BigDecimal income;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private UUID externalId;

    @OneToOne
    private UserEntity user;

    public VillagerEntity() {
    }

    public VillagerEntity(Long id, String name, String surname, Date birthday, BigDecimal income, String cpf, UserEntity appUser) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
    }

    public VillagerEntity(String name, String surname, Date birthday, BigDecimal income, String cpf, UUID externalId) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
        this.externalId = externalId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VillagerEntity that = (VillagerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(birthday, that.birthday) && Objects.equals(income, that.income) && Objects.equals(cpf, that.cpf) && Objects.equals(externalId, that.externalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, income, cpf, externalId);
    }
}
