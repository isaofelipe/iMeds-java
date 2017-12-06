/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.ItemPedido;
import modelo.Pedido;
import tools.DAOBaseJDBC;
import tools.Sessao;

/**
 *
 * @author alunodev06
 */
public class PedidoDAOJDBC extends DAOBaseJDBC implements PedidoDAO {

    public List<Pedido> buscarPedidosAbertosPorFarmaciaLogada()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idPedido, data, imagemReceita, idFarmacia, idCliente, estado, requerReceita FROM Pedido WHERE idFarmacia = ? AND estado = 1");
            stmt.setInt(1, Sessao.farmaciaLogada.getIdFarmacia());
            ResultSet rset = stmt.executeQuery();
            List<Pedido> listaPedidos = new ArrayList<>();
            while (rset.next()){
                Pedido pedido = new Pedido();
                pedido.setCliente(new ClienteDAOJDBC().buscarClientePorId(rset.getInt("idCliente")));
                pedido.setDataHora(rset.getTimestamp("data"));
                pedido.setEstado(rset.getInt("estado"));
                pedido.setFarmacia(Sessao.farmaciaLogada);
                pedido.setIdPedido(rset.getInt("idPedido"));
                pedido.setRequerReceita(rset.getBoolean("requerReceita"));
                
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
            PreparedStatement stmt = conn.prepareStatement("SELECT idPedido, data, imagemReceita, idFarmacia, idCliente, estado, requerReceita FROM Pedido WHERE idCliente = ?");
            stmt.setInt(1, Sessao.clienteLogado.getIdCliente());
            ResultSet rset = stmt.executeQuery();
            List<Pedido> listaPedidos = new ArrayList<>();
            while (rset.next()){
                Pedido pedido = new Pedido();
                pedido.setCliente(Sessao.clienteLogado);
                pedido.setDataHora(rset.getTimestamp("data"));
                pedido.setEstado(rset.getInt("estado"));
                pedido.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(rset.getInt("idFarmacia")));
                pedido.setIdPedido(rset.getInt("idPedido"));
                pedido.setRequerReceita(rset.getBoolean("requerReceita"));
                listaPedidos.add(pedido);
            }
            return listaPedidos;
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
    }
    
    public Pedido buscarPedidoPorId(int id)
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT idPedido, data, imagemReceita, idFarmacia, idCliente, estado, requerReceita FROM Pedido WHERE idPedido = ?");
            stmt.setInt(1, id);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()){
                Pedido pedido = new Pedido();
                pedido.setCliente(new ClienteDAOJDBC().buscarClientePorId(rset.getInt("idCliente")));
                pedido.setDataHora(rset.getTimestamp("data"));
                pedido.setEstado(rset.getInt("estado"));
                pedido.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(rset.getInt("idFarmacia")));
                pedido.setIdPedido(rset.getInt("idPedido"));
                pedido.setRequerReceita(rset.getBoolean("requerReceita"));
                if (pedido.getRequerReceita())
                    pedido.setImagemReceita(rset.getBlob("imagemReceita"));
                return pedido;
            }
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
        return null;
    }

    public void inserirPedido(Pedido pedido) throws SQLException {
        PreparedStatement stmt;
        try{
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO Pedido(data, imagemReceita, idFarmacia, idCliente, estado, requerReceita)" + 
                    "VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setTimestamp(1, pedido.getDataHora());
            stmt.setBlob(2, pedido.getImagemReceita());
            stmt.setInt(3, pedido.getFarmacia().getIdFarmacia());
            stmt.setInt(4, pedido.getCliente().getIdCliente());
            stmt.setInt(5, pedido.getEstado());
            stmt.setInt(6, pedido.getRequerReceita() ? 1 : 0);
            stmt.executeUpdate();
            stmt.close();
            
            //seleção do ID
            stmt = conn.prepareStatement("SELECT MAX(idPedido) FROM Pedido");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            stmt.close();
            
            for (ItemPedido itemPedido : pedido.getListaItemPedido())
            {
                stmt = conn.prepareStatement("INSERT INTO item_pedido(quantidade, idMedicamento, idPedido, preco_unitario)" + 
                    "VALUES(?, ?, ?, ?)");
                stmt.setInt(1, itemPedido.getQuantidade());
                stmt.setInt(2, itemPedido.getMedicamento().getIdMedicamento());
                stmt.setInt(3, id);
                stmt.setDouble(4, itemPedido.getPrecoUnitario());
                stmt.executeUpdate();
                stmt.close();
            }
            
            conn.commit();
            conn.setAutoCommit(true);
        }
        catch(SQLException e){
            System.out.println("erro sql" + e.getMessage());
        }
    }
    
    public void setEstadoPedido(Pedido pedido, int estado){
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement("UPDATE Pedido SET Pedido.estado = ? WHERE Pedido.idPedido = ?");
            stmt.setInt(1,estado);
            stmt.setInt(2,pedido.idPedido);
            stmt.executeUpdate();
            stmt.close();
        }
        catch(SQLException e){
            System.out.println("erro sql" + e.getMessage());
        }
    }
}
