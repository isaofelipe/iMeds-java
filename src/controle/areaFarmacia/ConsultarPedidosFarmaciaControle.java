/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.areaFarmacia;

import dao.PedidoDAOJDBC;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author Mateus
 */
public class ConsultarPedidosFarmaciaControle {

    public List<Pedido> listarPedidosAbertos() {
        return new PedidoDAOJDBC().buscarPedidosAbertosPorFarmaciaLogada();
    }
    
    public Pedido ObterPedidoSelecionado(int idPedido){
        return new PedidoDAOJDBC().buscarPedidoPorId(idPedido);
    }
}
