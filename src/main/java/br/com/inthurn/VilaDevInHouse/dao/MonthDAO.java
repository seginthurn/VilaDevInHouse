package br.com.inthurn.VilaDevInHouse.dao;

import br.com.inthurn.VilaDevInHouse.interfaces.DAO;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Locale;


@Repository
public class MonthDAO {

    @Autowired
    DatabaseConnector dbconnector;

    public Integer getMonth(Object month){
        try {
            final String SQL = "SELECT id FROM months WHERE month = ?";
            PreparedStatement statement = dbconnector
                    .getConnection()
                    .prepareStatement(SQL);
            statement.setString(1, month.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt("id");
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
