/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.areaCliente;

import dao.FarmaciaDAOJDBC;
import dao.FarmaciaMedicamentoDAOJDBC;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import modelo.Farmacia;
import modelo.FarmaciaMedicamento;
import modelo.Medicamento;

/**
 *
 * @author Isao Felipe Morigaki
 */
public class SelecionarFarmaciaPedidoControle {
    public Map<String, Double> obterOrcamentos(List<Pair<Medicamento, Integer>> medicamentosQuantidadeCarrinho)
    {
        List<Farmacia> listaFarmacias = new FarmaciaDAOJDBC().buscarTodas();
        Map<String, Double> listaOrcamento = new HashMap<>();
        for (Farmacia farmacia : listaFarmacias)
        {
            Boolean farmaciaPossuiTodosMedicamentos = true;
            Double orcamento = 0.0;
            for (Pair<Medicamento, Integer> medicamentosQuantidade : medicamentosQuantidadeCarrinho)
            {
                FarmaciaMedicamento farmaciaMedicamento = new FarmaciaMedicamentoDAOJDBC().buscarPorIds(
                        medicamentosQuantidade.getKey().idMedicamento, farmacia.getIdFarmacia());
                if (farmaciaMedicamento != null && farmaciaMedicamento.quantEstoque > medicamentosQuantidade.getValue())
                {
                    orcamento += medicamentosQuantidade.getValue() * farmaciaMedicamento.getPreco();
                }
                else
                {
                    farmaciaPossuiTodosMedicamentos = false;
                    break;
                }
            }
            if (farmaciaPossuiTodosMedicamentos)
                listaOrcamento.put(farmacia.getNome(), orcamento);
        }
        return listaOrcamento;
    }
}
