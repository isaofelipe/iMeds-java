/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            System.out.println("Erro sql" + e.getMessage());
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
            System.out.println("erro sql" + e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Farmacia> buscarTodas() {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idFarmacia, nome, CNPJ, endereco, telefone FROM Farmacia");
            ResultSet rset = stmt.executeQuery();
            ArrayList<Farmacia> listaFarmacias = new ArrayList<>();
            while (rset.next()){
                Farmacia farmacia = new Farmacia();
                farmacia.setIdFarmacia(rset.getInt("idFarmacia"));
                farmacia.setNome(rset.getString("nome"));
                farmacia.setCNPJ(rset.getString("CNPJ"));
                farmacia.setEndereco(rset.getString("endereco"));
                farmacia.setTelefone("telefone");
                listaFarmacias.add(farmacia);
            }
            return listaFarmacias;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
    
    public Farmacia buscarPorId(int idFarmacia){
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idFarmacia, nome, CNPJ, endereco, telefone FROM Farmacia WHERE idFarmacia = ?");
            stmt.setInt(1, idFarmacia);
            ResultSet rset = stmt.executeQuery();
            Farmacia farmacia = new Farmacia();
            if (rset.next()){
                farmacia.setCNPJ(rset.getString("CNPJ"));
                farmacia.setEndereco(rset.getString("endereco"));
                farmacia.setIdFarmacia(idFarmacia);
                farmacia.setNome(rset.getString("nome"));
                farmacia.setTelefone(rset.getString("telefone"));
                return farmacia;
            }
            else{
                return null;
            }
            
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
    
    public Farmacia buscarPorNome(String nome){
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idFarmacia, nome, CNPJ, endereco, telefone FROM Farmacia WHERE nome = ?");
            stmt.setString(1, nome);
            ResultSet rset = stmt.executeQuery();
            Farmacia farmacia = new Farmacia();
            if (rset.next()){
                farmacia.setCNPJ(rset.getString("CNPJ"));
                farmacia.setEndereco(rset.getString("endereco"));
                farmacia.setIdFarmacia(rset.getInt("idFarmacia"));
                farmacia.setNome(rset.getString("nome"));
                farmacia.setTelefone(rset.getString("telefone"));
                return farmacia;
            }
            else{
                return null;
            }
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
}