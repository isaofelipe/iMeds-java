/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author alunodev06
 */
public class Pedido {
    public int idPedido;
    public Date data;
    public Blob imagemReceita;
    public Farmacia farmacia;
    public Cliente cliente;
    public int estado;
    public Boolean requerReceita = false;
    
    public static final int ABERTO = 1;
    public static final int CONCLUIDO = 2;
    public static final int RECUSADO = 9;

    public Pedido(Cliente cliente, int estado) {
        this.cliente = cliente;
        this.estado = estado;
    }

    public Pedido() {
    }

    public Boolean getRequerReceita() {
        return requerReceita;
    }

    public void setRequerReceita(Boolean requerReceita) {
        this.requerReceita = requerReceita;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Blob getImagemReceita() {
        return imagemReceita;
    }

    public void setImagemReceita(Blob imagemReceita) {
        this.imagemReceita = imagemReceita;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
