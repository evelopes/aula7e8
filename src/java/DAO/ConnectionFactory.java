/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author eveli
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/empresa","empresa","empresa");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o Banco de Dados: " + e);
        }
        return null;
    }  
}