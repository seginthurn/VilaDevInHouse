package br.com.inthurn.VilaDevInHouse.dao;

import br.com.inthurn.VilaDevInHouse.interfaces.DAO;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VillagerDAO implements DAO<VillagerDTO> {

    @Autowired
    DatabaseConnector dbConnector;

    @Override
    public List<VillagerDTO> listAll(){
        try {
            List<VillagerDTO> villagerDTOList = new ArrayList<>();
            final String SQL = "SELECT * FROM villager LEFT JOIN app_user ON (villager.appuser_id = app_user.id)";
            Connection connection = dbConnector.getConnection();
            PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                villagerDTOList.add(
                        new VillagerDTO(resultSet.getInt("id"),resultSet.getString("name"))
                );
            }

            return villagerDTOList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public VillagerDTO listDetailsPerId(Integer id) {
        try{
            final String SQL = "SELECT name,surname, birthday, income, cpf, username from villager LEFT JOIN app_user ON (villager.appuser_id = app_user.id) WHERE villager.id = ?";
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(SQL);
            ResultSet resultSet = statement.executeQuery();

            if(!resultSet.next()){
                return new VillagerDTO(
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDate("birthday"),
                        resultSet.getBigDecimal("income"),
                        resultSet.getString("cpf"),
                        resultSet.getString("username")
                );
            }else {
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<VillagerDTO> listPerPage(Integer Page) {
        return null;
    }

    @Override
    public List<VillagerDTO> listPerName(String name) {
        return null;
    }

    @Override
    public List<VillagerDTO> listPerMonth(String Month) {
        return null;
    }

    @Override
    public ResponseEntity<String> addNew(VillagerDTO villagerDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePerId() {
        return null;
    }
}
