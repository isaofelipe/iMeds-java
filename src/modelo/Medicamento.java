/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alunodev06
 */
public class Medicamento {
    public int idMedicamento;
    public String nome;
    public String descricao;
    public Boolean prescrito;
    private Set<Farmacia> farmacia;
    
    public Medicamento(){
        this.farmacia = new HashSet<>();
    }
    public void adicionarFarmaciaMedicamento(FarmaciaMedicamento farmaciaMedicamento){
        this.getFarmaciaMedicamento().add(farmaciaMedicamento);
    }
    public void removerFarmaciaMedicamento(Farmacia farmaciaMedicamento){
        this.getFarmaciaMedicamento().remove(farmaciaMedicamento);
    }

    public Set getFarmaciaMedicamento() {
        return farmacia;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Boolean getprescrito() {
        return prescrito;
    }

    public void setprescrito(Boolean prescrito) {
        this.prescrito = prescrito;
    }
}
