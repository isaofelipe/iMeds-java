/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Pedido;

/**
 *
 * @author alunodev06
 */
public interface PedidoDAO {
    public List<Pedido> buscarPedidosDoClienteLogado();
}
