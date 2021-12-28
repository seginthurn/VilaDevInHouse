package br.com.inthurn.VilaDevInHouse.model.entity;

import br.com.inthurn.VilaDevInHouse.dao.AppUserDAO;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

}
