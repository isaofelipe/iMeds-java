/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alunodev06
 */
public class ItemPedido {
    public int idItemPedido;
    public int quantidade;
    public Medicamento medicamento;
    public Pedido pedido;
    public Double precoUnitario;

    public ItemPedido() {
    }

    public ItemPedido(Medicamento medicamento, Double precoUnitario, int quantidade) {
        this.quantidade = quantidade;
        this.medicamento = medicamento;
        this.precoUnitario = precoUnitario;
    }

    public int getIdItemPedido() {
        return idItemPedido;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
}
