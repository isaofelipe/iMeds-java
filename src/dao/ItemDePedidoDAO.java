/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.ItemPedido;

/**
 *
 * @author alunodev06
 */
public interface ItemDePedidoDAO {
    public void salvarItemDePedido();
    public List<ItemPedido> buscarPorIdPedido(int idPedido);
}
