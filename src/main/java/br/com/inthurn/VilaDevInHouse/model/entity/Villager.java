package br.com.inthurn.VilaDevInHouse.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Villager {
    private Integer id;
    private String name;
    private String surname;
    private Date birthday;
    private Long income;
    private String cpf;
    private Integer appuser_id;


}
