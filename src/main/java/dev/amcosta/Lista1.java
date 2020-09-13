package dev.amcosta;

import dev.amcosta.dao.ProductDao;
import dev.amcosta.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lista1 {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
//        Statement statement = con.createStatement();
//        statement.execute("SELECT * FROM produtos");
//        ResultSet resultSet = statement.getResultSet();
//        while (resultSet.next()) {
//            String msg = String.format(
//                    "Id: %d, Nome: %s, Descrição: %s",
//                    resultSet.getInt("id"),
//                    resultSet.getString("nome"),
//                    resultSet.getString("descricao")
//            );
//            System.out.println(msg);
//        }

        ProductDao productDao = new ProductDao(factory.create());
        productDao.findAll().forEach(product -> System.out.println(product));
    }
}
