package br.com.inthurn.VilaDevInHouse.model.transport;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class VillagerDto implements Serializable {
    private final String name;
    private final String surname;
    private final Date birthday;
    private final BigDecimal income;
    private final String cpf;
    private final UserDTO user;
}
