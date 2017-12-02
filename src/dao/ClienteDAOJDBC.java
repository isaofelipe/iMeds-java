/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;
import tools.DAOBaseJDBC;

/**
 *
 * @author alunodev06
 */
public class ClienteDAOJDBC extends DAOBaseJDBC implements ClienteDAO{

    @Override
    public boolean salvarCliente(Cliente cliente) {
        PreparedStatement stmt;
        try{
            //tabela cliente
            stmt = conn.prepareStatement("INSERT INTO cliente(idCliente, nome, cpf, endereco, telefone) VALUES(?, ?, ?, ?, ?)");
            int id = inserirUsuario(cliente.getEmail(), cliente.getSenha());
            if(id != 0){
                stmt.setInt(1, id);
                stmt.setString(2, cliente.getNome());
                stmt.setString(3, cliente.getCPF());
                stmt.setString(4, cliente.getEndereco());
                stmt.setString(5, cliente.getTelefone());
                stmt.executeUpdate();
                stmt.close();
            }
            else{
                System.out.println("erro encontrar id do usuario");
                return false;
            }
        }
        catch(SQLException e) {
            System.out.println("Erro sql" + e.getStackTrace());
            return false;
        }
        return true;
    }
 
    private int inserirUsuario(String email, String senha){
        PreparedStatement stmt2;
        try{
            stmt2 = conn.prepareStatement("INSERT INTO usuario(email, senha, tipo) VALUES(?, ?, 0)");
            stmt2.setString(1, email);
            stmt2.setString(2, senha);
            stmt2.executeUpdate();
            stmt2.clearBatch();     //limpa a query anterior do objeto
            
            //seleção do ID
            stmt2 = conn.prepareStatement("SELECT idusuario FROM usuario where email = ? and senha = ? and tipo = 0");
            stmt2.setString(1, email);
            stmt2.setString(2, senha);
            ResultSet rs = stmt2.executeQuery();
            int id = rs.getInt("idusuario");
            stmt2.close();
            return id;
        }
        catch(SQLException e){
            System.out.println("erro sql" + e.getStackTrace());
        }
        return 0;
    }
}

