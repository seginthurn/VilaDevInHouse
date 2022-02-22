package br.com.inthurn.VilaDevInHouse.model.transport.villager;

import br.com.inthurn.VilaDevInHouse.interfaces.LocalDTO;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillagerDTO implements LocalDTO<VillagerEntity> {

    private String name;
    private String surname;
    private Date birthday;
    private BigDecimal income;
    private String cpf;
    private UUID externalId;

    public VillagerDTO(String name, String surname, Date birthday, BigDecimal income, String cpf) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.income = income;
        this.cpf = cpf;
    }

    @Override
    public VillagerEntity convertToEntity() {
        return new VillagerEntity(this.name, this.surname, this.birthday, this.income, this.cpf, this.externalId);
    }

}
