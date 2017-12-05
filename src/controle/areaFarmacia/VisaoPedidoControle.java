/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.areaFarmacia;

import dao.ItemPedidoDAOJDBC;
import dao.PedidoDAOJDBC;
import java.util.List;
import modelo.ItemPedido;
import modelo.Pedido;

/**
 *
 * @author Isao Felipe Morigaki
 */
public class VisaoPedidoControle {

    public List<ItemPedido> listarItensPedido(int idPedido) {
        return new ItemPedidoDAOJDBC().buscarPorIdPedido(idPedido);
    }
    public void setEstado(Pedido pedido, int estado){
        new PedidoDAOJDBC().setEstadoPedido(pedido, estado);
    }
    
}
