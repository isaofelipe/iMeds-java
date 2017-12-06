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
import modelo.ItemPedido;
import tools.DAOBaseJDBC;
import tools.Sessao;

/**
 *
 * @author alunodev06
 */
public class ItemPedidoDAOJDBC extends DAOBaseJDBC implements ItemPedidoDAO{

    @Override
    public void salvarItemDePedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemPedido> buscarPorIdPedido(int idPedido) {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idItemPedido, quantidade, idMedicamento, idPedido, preco_unitario FROM item_pedido WHERE idPedido = ?");
            stmt.setInt(1, idPedido);
            ResultSet rset = stmt.executeQuery();
            List<ItemPedido> listaItensPedido = new ArrayList<>();
            while (rset.next()){
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setIdItemPedido(idPedido);
                itemPedido.setMedicamento(new MedicamentoDAOJDBC().buscarPorId(rset.getInt("idMedicamento")));
                itemPedido.setPedido(new PedidoDAOJDBC().buscarPedidoPorId(rset.getInt("idPedido")));
                itemPedido.setQuantidade(rset.getInt("quantidade"));
                itemPedido.setPrecoUnitario(rset.getDouble("preco_unitario"));
                
                listaItensPedido.add(itemPedido);
            }
            return listaItensPedido;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
    
}
