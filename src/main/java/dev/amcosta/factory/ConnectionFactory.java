package dev.amcosta.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final ComboPooledDataSource dataSource;

    public ConnectionFactory() {
        this.dataSource = new ComboPooledDataSource();
        this.dataSource.setJdbcUrl("jdbc:mysql://localhost:3301/loja_virtual?useTimezone=true&serverTimezone=UTC");
        this.dataSource.setUser("root");
        this.dataSource.setPassword("java-jdbc");

        this.dataSource.setMaxPoolSize(5);
    }

    public Connection create() throws SQLException {
        return this.dataSource.getConnection();
    }
}
