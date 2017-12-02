/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.areaCliente;

import dao.MedicamentoDAOJDBC;
import modelo.Medicamento;

/**
 *
 * @author alunodev06
 */
public class ConsultarMedicamentosControle {
    public Medicamento buscarMedicamento(String nome){
        MedicamentoDAOJDBC medicamentoDAOJDBC = new MedicamentoDAOJDBC();
        return medicamentoDAOJDBC.buscarPorNome((nome));
    }
}
