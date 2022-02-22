package br.com.inthurn.VilaDevInHouse.dao;

import br.com.inthurn.VilaDevInHouse.interfaces.DAO;
import br.com.inthurn.VilaDevInHouse.model.entity.AppUserEntity;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.DatabaseConnector;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.security.encoder.Encryptor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AppUserDAO implements DAO<AppUserEntity>{

    private DatabaseConnector dbConnector;
    private Encryptor encryptor;

    public AppUserDAO(DatabaseConnector dbConnector, Encryptor encryptor) {
        this.dbConnector = dbConnector;
        this.encryptor = encryptor;
    }

    @Override
    public Boolean addNew(AppUserEntity appUserEntity) {
        try {
            appUserEntity.setPassword(encryptor.encode(appUserEntity.getPassword()));
            final String SQL = "INSERT INTO app_user (username, password) VALUES (?,?)";
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(SQL);
            statement.setString(1, appUserEntity.getUsername());
            statement.setString(2, appUserEntity.getPassword());
            statement.executeQuery();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
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

    @Override
    public AppUserEntity listDetailsById(Integer id) {
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

    @Override
    public Boolean delete(Integer id){
        try {
            if(listDetailsById(id) == null){
                return false;
            }

            final String SQL = "DELETE FROM app_user WHERE id = ?";
            PreparedStatement statement = dbConnector
                    .getConnection()
                    .prepareStatement(SQL);
            statement.setInt(1, id);
            statement.executeQuery();
            return true;
        }catch (SQLException e){
            return false;
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

    public Optional<AppUserEntity> findByLogin (String login){
        try {
            final String SQL = "SELECT * from app_user where (username = ?)";
            PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(SQL);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(
                        new AppUserEntity(
                                resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

