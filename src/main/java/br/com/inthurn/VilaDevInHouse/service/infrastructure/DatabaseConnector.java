package br.com.inthurn.VilaDevInHouse.service.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import java.beans.BeanProperty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class DatabaseConnector {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public Connection getConnection(){
        try {
            System.out.println("LOG: Banco Conectado");
            return DriverManager.getConnection(url, username, password);
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
