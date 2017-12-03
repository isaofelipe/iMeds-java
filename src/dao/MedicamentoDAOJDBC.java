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
import modelo.Medicamento;
import tools.DAOBaseJDBC;

/**
 *
 * @author alunodev06
 */
public class MedicamentoDAOJDBC extends DAOBaseJDBC implements MedicamentoDAO{

    @Override
    public ArrayList<Medicamento> buscarTodos() {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idMedicamento, nome, tipo, prescrito FROM Medicamento");
            ResultSet rset = stmt.executeQuery();
            ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
            while (rset.next()){
                Medicamento medicamento = new Medicamento();
                medicamento.setIdMedicamento(rset.getInt("idMedicamento"));
                medicamento.setNome(rset.getString("nome"));
                medicamento.setDescricao(rset.getString("descricao"));
                listaMedicamentos.add(medicamento);
            }
            return listaMedicamentos;
        }
        catch(SQLException e){
            System.out.println("Erro de sql");
            return null;
        }
    }
    
    public Medicamento buscarPorNome(String nome){
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idMedicamento, descricao, prescrito FROM Medicamento WHERE nome = ?");
            stmt.setString(1, nome);
            ResultSet rset = stmt.executeQuery();
            Medicamento medicamento = new Medicamento();
            if (rset.next()){
                medicamento.setIdMedicamento(rset.getInt("idMedicamento"));
                medicamento.setNome(nome);
                medicamento.setDescricao(rset.getString("descricao"));
                medicamento.setprescrito(rset.getBoolean("prescrito"));
                return medicamento;
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

    @Override
    public Medicamento buscarPorId(int idMedicamento) {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idMedicamento, nome, descricao, prescrito FROM Medicamento WHERE idMedicamento = ?");
            stmt.setInt(1, idMedicamento);
            ResultSet rset = stmt.executeQuery();
            Medicamento medicamento = new Medicamento();
            if (rset.next()){
                medicamento.setIdMedicamento(rset.getInt("idMedicamento"));
                medicamento.setNome(rset.getString("nome"));
                medicamento.setDescricao(rset.getString("descricao"));
                medicamento.setprescrito(rset.getBoolean("prescrito"));
                return medicamento;
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
