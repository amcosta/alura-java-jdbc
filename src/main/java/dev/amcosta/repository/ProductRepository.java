package dev.amcosta.repository;

import java.sql.*;

public class ProductRepository {
    Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public String create (String name, String description) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO produtos (nome, descricao) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        statement.setString(1, name);
        statement.setString(2, description);
        statement.execute();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getString(1);
    }
}
