package dev.amcosta.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection create() throws SQLException {
        return DriverManager
                .getConnection(
                        "jdbc:mysql://localhost:3301/loja_virtual?useTimezone=true&serverTimezone=UTC",
                        "root",
                        "java-jdbc"
                );
    }
}
