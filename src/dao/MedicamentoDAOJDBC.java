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
            PreparedStatement stmt = conn.prepareStatement("SELECT idMedicamento, nome, tipo, prescricao FROM Medicamento");
            ResultSet rset = stmt.executeQuery();
            ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
            while (rset.next()){
                Medicamento medicamento = new Medicamento();
                medicamento.setIdMedicamento(rset.getInt("idMedicamento"));
                medicamento.setNome(rset.getString("nome"));
                medicamento.setTipo(rset.getString("tipo"));
                medicamento.setPrescricao(rset.getBoolean("prescricao"));
                listaMedicamentos.add(medicamento);
            }
            return listaMedicamentos;
        }
        catch(SQLException e){
            System.out.println("Erro de sql");
            return null;
        }
    }
}
