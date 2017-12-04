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

    public List<Pedido> buscarPedidosPorFarmaciaLogada(){
    try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idPedido, data, imagemReceita, idFarmacia, idCliente FROM Pedido WHERE idPedido = ?");
            stmt.setInt(1, Sessao.farmciaLogada.getIdFarmacia());
            ResultSet rset = stmt.executeQuery();
            List<Pedido> listaPedidos = new ArrayList<>();
            while (rset.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rset.getInt("idPedido"));
                pedido.setData(rset.getString("data"));
                pedido.setImagemReceita(rset.getString("imagemReceita"));
                pedido.setIdFarmacia(rset.getString("idFarmacia"));
                pedido.setIdCliente("idCliente");
                listaPedidos.add(pedido);
            }
            return listaPedidos;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    
}
