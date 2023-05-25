/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author eveli
 */


import java.sql.*;
import java.util.*;

public class FuncionarioDao {

    private Connection connection;

    public FuncionarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, funcionario.getNumat());
            statement.setString(2, funcionario.getNome());
            statement.setFloat(3, funcionario.getSalario());
            statement.setString(4, funcionario.getSexo());
            statement.setInt(5, funcionario.getNdepto());
            statement.setInt(6, funcionario.getNsuper());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    
    
    
    
    public ArrayList<Funcionario> getLista() {
        PreparedStatement statement = null;
        ResultSet resultStatement = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try {
            String sql = "SELECT * FROM funcionario";
            statement = connection.prepareStatement(sql);
            resultStatement = statement.executeQuery();

            while (resultStatement.next()) {
                int numat = resultStatement.getInt("numat");
                String nome = resultStatement.getString("nome");
                float salario = resultStatement.getFloat("salario");
                String sexo = resultStatement.getString("sexo");
                int ndepto = resultStatement.getInt("ndepto");
                int nsuper = resultStatement.getInt("nsuper");
                Funcionario funcionario = new Funcionario(numat, nome, salario, sexo, ndepto, nsuper);
                funcionarios.add(funcionario);
            }
            resultStatement.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionarios;
    }

    public boolean atualiza(Funcionario funcionario){
        String sql = "UPDATE funcionario SET nome = ?, salario = ?, ndepto = ?, nsuper = ? WHERE numat = ?";
        int funcionariosAtualizados = 0;
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setFloat(2, funcionario.getSalario());
            stmt.setInt(3, funcionario.getNdepto());
            stmt.setInt(4, funcionario.getNsuper());
            stmt.setInt(5, funcionario.getNumat());
            funcionariosAtualizados = stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return funcionariosAtualizados == 1;
    }
    
    public boolean remove(int numat){
        String sql = "DELETE FROM funcionario WHERE numat = ?";
        int funcionariosRemovidos = 0;
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, numat);
            funcionariosRemovidos = stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return funcionariosRemovidos == 1;
    }
    
    
    
    
    
    
    
    public Funcionario consulta(int numatParam) {
        String sql = "SELECT * from funcionario WHERE numat = ?";
        Funcionario funcionario = null;

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, numatParam);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int numat = rs.getInt("numat");
                String nome = rs.getString("nome");
                float salario = rs.getFloat("salario");
                String sexo = rs.getString("sexo");
                int ndepto = rs.getInt("ndepto");
                int nsuper = rs.getInt("nsuper");
                funcionario = new Funcionario(numat, nome, salario, sexo, ndepto, nsuper);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionario;
    }
    
        public ArrayList<Funcionario> getSupervisores() {
        PreparedStatement statement = null;
        ResultSet resultStatement = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try {
            String sql = "SELECT * FROM EMPRESA.FUNCIONARIO WHERE nsuper = 8886 OR nsuper = 0";
            statement = connection.prepareStatement(sql);
            resultStatement = statement.executeQuery();

            while (resultStatement.next()) {
                int numat = resultStatement.getInt("numat");
                String nome = resultStatement.getString("nome");
                float salario = resultStatement.getFloat("salario");
                String sexo = resultStatement.getString("sexo");
                int ndepto = resultStatement.getInt("ndepto");
                int nsuper = resultStatement.getInt("nsuper");
                Funcionario funcionario = new Funcionario(numat, nome, salario, sexo, ndepto, nsuper);
                funcionarios.add(funcionario);
            }
            resultStatement.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionarios;
    }
}