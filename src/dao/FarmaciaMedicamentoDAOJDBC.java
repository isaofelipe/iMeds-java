/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.FarmaciaMedicamento;
import tools.DAOBaseJDBC;

/**
 *
 * @author Isao Felipe Morigaki
 */
public class FarmaciaMedicamentoDAOJDBC extends DAOBaseJDBC implements FarmaciaMedicamentoDAO {
    public List<FarmaciaMedicamento> buscarPorIdFarmacia(int idFarmacia)
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idFarmacia, idMedicamento, preco, quantEstoque FROM farmacia_medicamento WHERE idFarmacia = ?");
            stmt.setInt(1, idFarmacia);
            ResultSet rset = stmt.executeQuery();
            List<FarmaciaMedicamento> listaFarmaciaMedicamento = null;
            while (rset.next()){
                listaFarmaciaMedicamento = new LinkedList<>();
                FarmaciaMedicamento farmaciaMedicamento = new FarmaciaMedicamento();
                farmaciaMedicamento.setPreco(rset.getFloat("preco"));
                farmaciaMedicamento.setQuantEstoque(rset.getInt("quantEstoque"));
                farmaciaMedicamento.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(idFarmacia));
                farmaciaMedicamento.setMedicamento(new MedicamentoDAOJDBC().buscarPorId(rset.getInt(("idMedicamento"))));
                listaFarmaciaMedicamento.add(farmaciaMedicamento);
            }
            return listaFarmaciaMedicamento;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }

    @Override
    public List<FarmaciaMedicamento> buscarPorIdMedicamento(int idMedicamento) {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idFarmacia, idMedicamento, preco, quantEstoque FROM farmacia_medicamento WHERE idMedicamento = ?");
            stmt.setInt(1, idMedicamento);
            ResultSet rset = stmt.executeQuery();
            List<FarmaciaMedicamento> listaFarmaciaMedicamento = null;
            while (rset.next()){
                listaFarmaciaMedicamento = new LinkedList<>();
                FarmaciaMedicamento farmaciaMedicamento = new FarmaciaMedicamento();
                farmaciaMedicamento.setPreco(rset.getFloat("preco"));
                farmaciaMedicamento.setQuantEstoque(rset.getInt("quantEstoque"));
                farmaciaMedicamento.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(rset.getInt("idFarmacia")));
                farmaciaMedicamento.setMedicamento(new MedicamentoDAOJDBC().buscarPorId(rset.getInt("idMedicamento")));
                listaFarmaciaMedicamento.add(farmaciaMedicamento);
            }
            return listaFarmaciaMedicamento;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }

    @Override
    public FarmaciaMedicamento buscarPorIds(int idMedicamento, int idFarmacia) {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idFarmacia, idMedicamento, preco, quantEstoque FROM farmacia_medicamento WHERE idMedicamento = ? AND idFarmacia = ?");
            stmt.setInt(1, idMedicamento);
            stmt.setInt(2, idFarmacia);
            ResultSet rset = stmt.executeQuery();
            FarmaciaMedicamento farmaciaMedicamento = null;
            if (rset.next()){
                farmaciaMedicamento = new FarmaciaMedicamento();
                farmaciaMedicamento.setPreco(rset.getFloat("preco"));
                farmaciaMedicamento.setQuantEstoque(rset.getInt("quantEstoque"));
                farmaciaMedicamento.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(rset.getInt("idFarmacia")));
                farmaciaMedicamento.setMedicamento(new MedicamentoDAOJDBC().buscarPorId(rset.getInt("idMedicamento")));
            }
            return farmaciaMedicamento;
        }
        catch(SQLException e){
            System.out.println("Erro de sql\n\n" + e.getMessage());
            return null;
        }
    }

    @Override
    public Double buscarPrecoPorIds(int idMedicamento, int idFarmacia) {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT preco FROM farmacia_medicamento WHERE idMedicamento = ? AND idFarmacia = ?");
            stmt.setInt(1, idMedicamento);
            stmt.setInt(2, idFarmacia);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                return rset.getDouble(1);
            }
            return null;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
    
}
