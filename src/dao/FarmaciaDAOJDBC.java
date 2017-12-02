/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Farmacia;
import tools.DAOBaseJDBC;

/**
 *
 * @author alunodev06
 */
public class FarmaciaDAOJDBC extends DAOBaseJDBC implements FarmaciaDAO{
    @Override
    public boolean salvarFarmacia(Farmacia farmacia) {
        PreparedStatement stmt;
        try{
            //tabela farmacia
            stmt = conn.prepareStatement("INSERT INTO farmacia(idFarmacia, nome, cnpj, endereco, telefone) VALUES(?, ?, ?, ?, ?)");
            int id = retornaIdFarmacia(farmacia.getEmail(), farmacia.getSenha());
            if(id != 0){
                stmt.setInt(1, id);
                stmt.setString(2, farmacia.getNome());
                stmt.setString(3, farmacia.getCNPJ());
                stmt.setString(4, farmacia.getEndereco());
                stmt.setString(5, farmacia.getTelefone());
                stmt.executeUpdate();
                stmt.close();
            }
            else{
                System.out.println("Erro encontrar id usuario");
                return false;
            }
        }
        catch(SQLException e){
            System.out.println("Erro sql" + e.getStackTrace());
            return false;
        }
        return true;
    }
    
    private int retornaIdFarmacia(String email, String senha){
        PreparedStatement stmt2;
        try{
            stmt2 = conn.prepareStatement("INSERT INTO usuario(email, senha, tipo) VALUES(?, ?, 1)");
            stmt2.setString(1, email);
            stmt2.setString(2, senha);
            stmt2.executeUpdate();
            stmt2.clearBatch();     //limpa a query anterior do objeto
            
            //seleção do ID
            stmt2 = conn.prepareStatement("SELECT idusuario FROM usuario WHERE email = ? AND senha = ? AND tipo = 1");
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