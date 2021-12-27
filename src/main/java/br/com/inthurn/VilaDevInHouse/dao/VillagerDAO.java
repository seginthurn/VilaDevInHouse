package br.com.inthurn.VilaDevInHouse.dao;


import br.com.inthurn.VilaDevInHouse.infrastructure.JDBCConfig;
import br.com.inthurn.VilaDevInHouse.model.entity.Villager;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VillagerDAO {

    @Autowired
    JDBCConfig jdbcConfig;

    public List<VillagerDTO> getVillager(){
        try{
            final String SQL = "SELECT * FROM villager";
            List<VillagerDTO> villagersList = new ArrayList<>();
            Connection connection = jdbcConfig.getConnection();
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(SQL);

            while(queryResult.next()){
                villagersList.add(
                        new VillagerDTO(
                                queryResult.getString("name"),
                                queryResult.getString("surname"),
                                queryResult.getString("birthday"),
                                queryResult.getLong("income"),
                                queryResult.getString("cpf")
                        )
                );

                return villagersList;
            }

        }catch (SQLException e){
            return null;
        }
    }

}
