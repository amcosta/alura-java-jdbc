package dev.amcosta.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDeConexao1 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3301/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "java-jdbc");

        con.close();

        System.out.println("Conexão realizada com sucesso!");
    }
}
