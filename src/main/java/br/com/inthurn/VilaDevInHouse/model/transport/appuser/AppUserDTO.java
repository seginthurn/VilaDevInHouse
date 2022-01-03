package br.com.inthurn.VilaDevInHouse.model.transport.appuser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO {

    private Integer id;
    private String username;
    private String password;

    public AppUserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
