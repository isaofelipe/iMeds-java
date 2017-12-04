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
import java.util.List;
import modelo.Pedido;
import tools.DAOBaseJDBC;
import tools.Sessao;

/**
 *
 * @author alunodev06
 */
public class PedidoDAOJDBC  extends DAOBaseJDBC implements PedidoDAO {

    public List<Pedido> buscarPedidosPorFarmaciaLogada()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idPedido, data, imagemReceita, idFarmacia, idCliente FROM Pedido WHERE idCliente = ?");
            stmt.setInt(1, Sessao.clienteLogado.getIdCliente());
            ResultSet rset = stmt.executeQuery();
            List<Pedido> listaPedidos = new ArrayList<>();
            while (rset.next()){
                Pedido pedido = new Pedido();
                pedido.setCliente(Sessao.clienteLogado);
                pedido.setData(rset.getDate("data"));
                pedido.setEstado(rset.getInt("estado"));
                pedido.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(rset.getInt("idFarmacia")));
                pedido.setIdPedido(rset.getInt("idFarmacia"));
                listaPedidos.add(pedido);
            }
            return listaPedidos;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }

    public List<Pedido> buscarPedidosDoClienteLogado()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idPedido, data, imagemReceita, idFarmacia, idCliente FROM Pedido WHERE idCliente = ?");
            stmt.setInt(1, Sessao.clienteLogado.getIdCliente());
            ResultSet rset = stmt.executeQuery();
            List<Pedido> listaPedidos = new ArrayList<>();
            while (rset.next()){
                Pedido pedido = new Pedido();
                pedido.setCliente(Sessao.clienteLogado);
                pedido.setData(rset.getDate("data"));
                pedido.setEstado(rset.getInt("estado"));
                pedido.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(rset.getInt("idFarmacia")));
                pedido.setIdPedido(rset.getInt("idFarmacia"));
                listaPedidos.add(pedido);
            }
            return listaPedidos;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
}
