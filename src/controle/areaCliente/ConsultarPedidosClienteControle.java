/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.areaCliente;

import dao.PedidoDAOJDBC;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author Isao Felipe Morigaki
 */
public class ConsultarPedidosClienteControle {

    public List<Pedido> listarPedidos() {
        return new PedidoDAOJDBC().buscarPedidosDoClienteLogado();
    }

    public Pedido ObterPedidoSelecionado(Integer id) {
        return new PedidoDAOJDBC().buscarPedidoPorId(id);
    }
    
}
