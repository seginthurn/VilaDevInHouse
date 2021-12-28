package br.com.inthurn.VilaDevInHouse.model.transport.appuser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO {

    private String username;
    private String password;
}
