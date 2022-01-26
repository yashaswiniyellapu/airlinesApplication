package com.everest.airline.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

public class DataSourceConfig {
//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String userName;
//    @Value("${spring.datasource.password}")
//    private String password;
private String url = "jdbc:mysql://localhost:3306/flights";
private String password="";
private String userName="root";
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("url "+ url);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
    public NamedParameterJdbcTemplate JdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

}
