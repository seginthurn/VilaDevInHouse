package br.com.inthurn.VilaDevInHouse.service.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnector {

    private final String url;
    private final String username;
    private final String password;

    @Autowired
    public DatabaseConnector(@Value("${spring.datasource.url}") String url,
                             @Value("${spring.datasource.username}")String username,
                             @Value("${spring.datasource.password}")String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
