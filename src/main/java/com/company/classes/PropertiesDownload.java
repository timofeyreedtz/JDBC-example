package com.company.classes;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesDownload {
    public static DriverManagerDataSource downloadProps(){
        Properties props = new Properties();
        try {
            props.load(PropertiesDownload.class.getClassLoader().getResourceAsStream("/db.properties"));
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            String driverClassName = props.getProperty("db.driverClassName");
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setDriverClassName(driverClassName);
            return dataSource;
        }
        catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
