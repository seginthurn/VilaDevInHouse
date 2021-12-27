package br.com.inthurn.VilaDevInHouse.model.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillagerDTO {

    private String name;
    private String surname;
    private String birthday;
    private Long income;
    private String cpf;

}
