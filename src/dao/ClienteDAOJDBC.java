/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tools.DAOBaseJDBC;

/**
 *
 * @author alunodev06
 */
public class ClienteDAOJDBC extends DAOBaseJDBC implements ClienteDAO{

    @Override
    public void salvarCliente(String nome, String endereco, String cpf, String telefone, String email, String senha) {
        PreparedStatement stmt;
        try{
            //tabela cliente
            stmt = conn.prepareStatement("INSERT INTO cliente(idCliente, nome, cpf, endereco, telefone) VALUES(?, ?, ?, ?, ?)");
            int id = retornaIdUsuario(email, senha);
            if(id != 0){
                stmt.setInt(1, id);
                stmt.setString(2, nome);
                stmt.setString(3, cpf);
                stmt.setString(4, endereco);
                stmt.setString(5, telefone);
                stmt.executeUpdate();
                stmt.close();
            }
            else{
                System.out.println("usuario nao encontrado!");
            }
        }
        catch(SQLException e){
            System.out.println("Erro sql" + e.getStackTrace());
        }
    }
 
    private int retornaIdUsuario(String email, String senha){
        PreparedStatement stmt2;
        try{
            stmt2 = conn.prepareStatement("INSERT INTO usuario(email, senha) VALUES(?, ?)");
            stmt2.setString(1, email);
            stmt2.setString(2, senha);
            stmt2.executeUpdate();
            stmt2.clearBatch();     //limpa a query anterior do objeto
            
            //seleção do ID
            stmt2 = conn.prepareStatement("SELECT idusuario FROM usuario where email = ? and senha = ?");
            stmt2.setString(1, email);
            stmt2.setString(2, senha);
            ResultSet rs = stmt2.executeQuery();
            int id = rs.getInt("id");
            stmt2.close();
            return id;
        }
        catch(SQLException e){
            System.out.println("erro sql" + e.getStackTrace());
        }
        return 0;
    }
}

