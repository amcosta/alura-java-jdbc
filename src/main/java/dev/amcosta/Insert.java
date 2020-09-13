package dev.amcosta;

import dev.amcosta.connection.ConnectionFactory;
import dev.amcosta.repository.ProductRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.create();
        connection.setAutoCommit(false);
//        connection.setTransactionIsolation();
        ProductRepository repository = new ProductRepository(connection);
        String id = repository.create("cadeira", "confortável");
        System.out.println("Produto gerado com o Id: " + id);
//        connection.close();
    }
}
