package test.utils;

import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerWithIncome;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenerateVillager {

    public static VillagerEntity generateEntity(){
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(new RoleEntity("ADMIN"));
        return new VillagerEntity("John", "Doe", "43212343093", new Date(1965, 10,27), new BigDecimal(102980), "8f3a0117-56d4-486a-82a1-a7399e14ff8e", new UserEntity("jhon@mail.com", "loremIps!um@", roles));
    }
}
