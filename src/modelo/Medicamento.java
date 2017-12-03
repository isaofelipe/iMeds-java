/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
    public List<FarmaciaMedicamento> listaFarmaciaMedicamento = new LinkedList<>();
    
    public Medicamento(){
    }
    
    public void adicionarFarmaciaMedicamento(FarmaciaMedicamento farmaciaMedicamento){
        this.getListaFarmaciaMedicamento().add(farmaciaMedicamento);
    }
    
    public void removerFarmaciaMedicamento(Farmacia farmaciaMedicamento){
        this.getListaFarmaciaMedicamento().remove(farmaciaMedicamento);
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

    public List<FarmaciaMedicamento> getListaFarmaciaMedicamento() {
        return listaFarmaciaMedicamento;
    }

    public void setListaFarmaciaMedicamento(List<FarmaciaMedicamento> listaFarmaciaMedicamento) {
        this.listaFarmaciaMedicamento = listaFarmaciaMedicamento;
    }
}
