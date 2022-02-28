package test.utils;

import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenerateUser {

    public static UserEntity generateEntity(){
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(new RoleEntity("ADMIN"));
        return new UserEntity("john.doe", "loremIpsum@2!",roles);
    }
}
