/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alunodev02
 */
public class FarmaciaMedicamento {
    public Double preco;
    public int quantEstoque;
    public Farmacia farmacia;
    public Medicamento medicamento;

    public FarmaciaMedicamento() {
    }

    public FarmaciaMedicamento(Double preco, int quantEstoque, Farmacia farmacia, Medicamento medicamento) {
        this.preco = preco;
        this.quantEstoque = quantEstoque;
        this.setFarmacia(farmacia);
        this.setMedicamento(medicamento);
    }
    
    public void setFarmacia(Farmacia farmacia){
        this.farmacia = farmacia;
        if(this.farmacia!= null){
            farmacia.adicionarFarmaciaMedicamento(this);
        }
    }
    public void setMedicamento(Medicamento medicamento){
        this.medicamento = medicamento;
        if(this.medicamento!= null){
            medicamento.adicionarFarmaciaMedicamento(this);
        }
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }
    
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }
}