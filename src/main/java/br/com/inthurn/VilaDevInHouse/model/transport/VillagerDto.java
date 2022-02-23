package br.com.inthurn.VilaDevInHouse.model.transport;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class VillagerDto implements Serializable {
    private String name;
    private String surname;
    private Date birthday;
    private BigDecimal income;
    private String cpf;
    private UserDTO user;
    private UUID externalId;
}
