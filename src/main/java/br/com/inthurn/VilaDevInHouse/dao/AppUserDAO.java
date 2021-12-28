package br.com.inthurn.VilaDevInHouse.dao;

import br.com.inthurn.VilaDevInHouse.interfaces.DAO;
import br.com.inthurn.VilaDevInHouse.model.entity.AppUserEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.appuser.AppUserDTO;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppUserDAO implements DAO<AppUserEntity> {

    @Override
    public ResponseEntity<String> addNew(AppUserEntity appUserEntity) {
        try {
            final String SQL = "INSERT INTO app_user (username, password) values (?,?)";
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(SQL);
            statement.setString(1, appUserEntity.getUsername());
            statement.setString(2, appUserEntity.getPassword());
            statement.executeQuery();
            return new ResponseEntity<>("Usuário Criado", HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    @Autowired
    DatabaseConnector dbConnector;

    @Override
    public List<AppUserEntity> listAll() {
        try {
            List<AppUserEntity> appUserDTOList = new ArrayList<>();
            final String SQL = "SELECT * FROM app_user";
            Connection connection = dbConnector.getConnection();
            PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                appUserDTOList.add(
                        new AppUserEntity(
                                resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getInt("role_id")
                        )
                );

                connection.close();
            }

            return appUserDTOList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public AppUserEntity listDetailsPerId(Integer id) {
        try {
            final String SQL = "SELECT * FROM app_user WHERE id = ?";
            PreparedStatement statement = dbConnector
                    .getConnection()
                    .prepareStatement(SQL);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next() == true){
               return new AppUserEntity( resultSet.getInt("id"),
                       resultSet.getString("username"),
                       resultSet.getString("password"),
                       resultSet.getInt("role_id"));
            }else{
                System.out.println("Usuário não encontrado");
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AppUserEntity> listPerPage(Integer Page) {
        return null;
    }

    @Override
    public List<AppUserEntity> listPerName(String usernaname) {
        return null;
    }

    @Override
    //Not Used
    public List<AppUserEntity> listPerMonth(String Month) {
        return null;
    }


    @Override
    public ResponseEntity<String> deletePerId() {
        return null;
    }
}
