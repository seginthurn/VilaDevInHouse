package br.com.inthurn.VilaDevInHouse.infrastructure;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class JDBCConfig {

    @Value("datasource.url")
    private String url;
    @Value("datasource.username")
    private String username;
    @Value("datasource.password")
    private String password;

    public Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            return connection;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
