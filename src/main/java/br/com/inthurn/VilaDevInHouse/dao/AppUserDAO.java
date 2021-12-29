package br.com.inthurn.VilaDevInHouse.dao;

import br.com.inthurn.VilaDevInHouse.interfaces.DAO;
import br.com.inthurn.VilaDevInHouse.model.entity.AppUserEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.appuser.AppUserDTO;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppUserDAO{

    @Autowired
    DatabaseConnector dbConnector;

    public ResponseEntity<Object> addNew(String username, String password) {
        try {
            final String SQL = "INSERT INTO app_user (username, password) VALUES (?,?)";
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(SQL);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeQuery();
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>("Erro ao gerar usuário", HttpStatus.BAD_REQUEST);
        }
    }

    public List<AppUserEntity> listAll() {
        try {
            List<AppUserEntity> appUserDTOList = new ArrayList<>();
            final String SQL = "SELECT * FROM app_user";
            Connection connection = dbConnector.getConnection();
            PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public AppUserEntity listDetailsPerId(Integer id) {
        try {
            final String SQL = "SELECT * FROM app_user WHERE id = ?";
            PreparedStatement statement = dbConnector
                    .getConnection()
                    .prepareStatement(SQL);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == true) {
                return new AppUserEntity(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("role_id"));
            } else {
                System.out.println("Usuário não encontrado");
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void deletePerId(Integer id) {
        try {
            final String SQL = "DELETE FROM app_user where id = ?";
            PreparedStatement statement = dbConnector
                    .getConnection()
                    .prepareStatement(SQL);
            statement.setInt(1, id);
            statement.executeQuery();
            System.out.println("Usuário Deletado");

        } catch (SQLException e) {
            System.out.println("Não deletou!");
        }
    }

    public Integer catchByUsername(String username) {
        try {
            final String SQL = "SELECT id FROM app_user WHERE username = ?";
            PreparedStatement statement = dbConnector
                    .getConnection()
                    .prepareStatement(SQL);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == true) {
                return resultSet.getInt("id");
            } else {
                System.out.println("Algo saiu errado!");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

