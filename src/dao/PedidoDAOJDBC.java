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
import java.util.ArrayList;
import java.util.List;
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
                pedido.setData(rset.getDate("data"));
                pedido.setEstado(rset.getInt("estado"));
                pedido.setFarmacia(Sessao.farmaciaLogada);
                pedido.setIdPedido(rset.getInt("idFarmacia"));
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
                pedido.setData(rset.getDate("data"));
                pedido.setEstado(rset.getInt("estado"));
                pedido.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(rset.getInt("idFarmacia")));
                pedido.setIdPedido(rset.getInt("idFarmacia"));
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
                pedido.setData(rset.getDate("data"));
                pedido.setEstado(rset.getInt("estado"));
                pedido.setFarmacia(new FarmaciaDAOJDBC().buscarPorId(rset.getInt("idFarmacia")));
                pedido.setIdPedido(rset.getInt("idFarmacia"));
                pedido.setRequerReceita(rset.getBoolean("requerReceita"));
                return pedido;
            }
        }
        catch(SQLException e){
            System.out.println("Erro de sql" + e.getMessage());
            return null;
        }
        return null;
    }

    public int inserirPedido(Pedido pedido) {
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement("INSERT INTO Pedido(data, imagemReceita, idFarmacia, idCliente, estado, requerReceita)" + 
                    "VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setDate(1, java.sql.Date.valueOf(pedido.getData().toString()));
            stmt.setBlob(2, pedido.getImagemReceita());
            stmt.setInt(3, pedido.getFarmacia().getIdFarmacia());
            stmt.setInt(4, pedido.getCliente().getIdCliente());
            stmt.setInt(5, pedido.getEstado());
            stmt.setBoolean(6, pedido.getRequerReceita());
            stmt.executeUpdate();
            stmt.clearBatch();     //limpa a query anterior do objeto
            
            //seleção do ID
            stmt = conn.prepareStatement("SELECT MAX(idPedido) FROM Pedido");
            ResultSet rs = stmt.executeQuery();
            int id = rs.getInt(1);
            stmt.close();
            return id;
        }
        catch(SQLException e){
            System.out.println("erro sql" + e.getMessage());
        }
        return 0;
    }
}
