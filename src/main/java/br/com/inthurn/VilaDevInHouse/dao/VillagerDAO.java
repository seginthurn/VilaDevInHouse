package br.com.inthurn.VilaDevInHouse.dao;

import br.com.inthurn.VilaDevInHouse.interfaces.DAO;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.villager.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VillagerDAO{

    @Autowired
    DatabaseConnector dbConnector;

    @Autowired
    AppUserDAO appUserDAO;


    public List<VillagerEntity> listAll(){
        try {
            List<VillagerEntity> villagerEntityList = new ArrayList<>();
            final String SQL = "SELECT * FROM villager";
            Connection connection = dbConnector.getConnection();
            PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                villagerEntityList.add(villagerEntityFactory(resultSet));
            }

            return villagerEntityList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }


    public VillagerEntity listDetailsPerId(Integer id) {
        try{
            final String SQL = "SELECT * from villager LEFT JOIN app_user ON (villager.appuser_id = app_user.id) WHERE villager.id = ?";
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(SQL);
            ResultSet resultSet = statement.executeQuery();

            if(!resultSet.next()){
                return villagerEntityFactory(resultSet);
            }else {
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<VillagerEntity> listPerName(String name) {
       try{
           final String SQL = "SELECT (id, name) from villager WHERE name LIKE ?";
           PreparedStatement statement = dbConnector
                   .getConnection()
                   .prepareStatement(SQL);
           List<VillagerEntity> villagerEntityList = new ArrayList<>();
           ResultSet resultSet = statement.executeQuery();

           while (resultSet.next()){
                villagerEntityList.add(villagerEntityFactory(resultSet));
           }
           return villagerEntityList;

       }catch (SQLException e){
           e.printStackTrace();
           return null;
       }
    }


    public List<VillagerEntity> listPerMonth(String Month) {
        return null;
    }

    public ResponseEntity<String> addNew(VillagerDTO villagerDTO) {
        try {
            final String SQL = "INSERT INTO villager (name, surname, birthday, income, cpf, appuser_id) values (?,?,?,?,?,?)";
            appUserDAO.addNew(villagerDTO.getEmail(), villagerDTO.getPassword());
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(SQL);
            statement.setString(1, villagerDTO.getName());
            statement.setString(2, villagerDTO.getSurname());
            statement.setDate(3, villagerDTO.getBirthday());
            statement.setBigDecimal(4, villagerDTO.getIncome());
            statement.setString(5, villagerDTO.getCpf());
            statement.setInt(6, appUserDAO.catchByUsername(villagerDTO.getEmail()));
            statement.executeQuery();

            return new ResponseEntity("OK", HttpStatus.OK);
        }catch (SQLException e){
            e.printStackTrace();
            return new ResponseEntity<String>("Deu ruim", HttpStatus.I_AM_A_TEAPOT);
        }

    }


    public ResponseEntity<String> deletePerId(Integer id) {
        try {

            final String SQL = "DELETE FROM villager where id = ?";
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(SQL);
            statement.setInt(1, id);
            statement.executeQuery();
            return new ResponseEntity<String>("Morador deletado", HttpStatus.OK);

        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Erro ao gerar usuário", HttpStatus.BAD_REQUEST);
        }
    }

    private VillagerEntity villagerEntityFactory(ResultSet resultSet) throws SQLException{
        return new VillagerEntity(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getDate("birthday"),
                            resultSet.getBigDecimal("income"),
                            resultSet.getString("cpf"),
                            resultSet.getInt("appuser_id")
                    );

    }

}