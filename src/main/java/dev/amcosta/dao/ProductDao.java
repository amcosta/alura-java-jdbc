package dev.amcosta.dao;

import dev.amcosta.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<Product>();

        Statement statement = this.connection.createStatement();
        statement.execute("SELECT * FROM produtos");
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            Product product = new Product(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );

            products.add(product);
        }

        return products;
    }

    public Product save(Product product) throws SQLException {
        PreparedStatement preparedStatement = this.connection.prepareStatement(
                "INSERT INTO produtos (nome, descricao) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getDescription());
        preparedStatement.execute();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        product.setId(generatedKeys.getInt(1));

        return product;
    }
}
