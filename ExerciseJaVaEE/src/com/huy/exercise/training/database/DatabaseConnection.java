package com.huy.exercise.training.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static BasicDataSource dataSource = null;

    private static BasicDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/customerdb");
            dataSource.setUsername("postgres");
            dataSource.setPassword("123456");
            dataSource.setMaxActive(100);
            dataSource.setMaxIdle(10);
            dataSource.setPoolPreparedStatements(true);
            dataSource.setMaxOpenPreparedStatements(50);
            dataSource.setMaxWait(100);
        }
        return dataSource;
  }
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
