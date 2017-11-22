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
    public String tipo;
    public Boolean prescricao;
    private Set farmaciaMedicamento;
    
    public Medicamento(){
        this.farmaciaMedicamento = new HashSet<>();
    }
    public void adicionarFarmaciaMedicamento(FarmaciaMedicamento farmaciaMedicamento){
        this.getFarmaciaMedicamento().add(farmaciaMedicamento);
    }
    public void removerFarmaciaMedicamento(FarmaciaMedicamento farmaciaMedicamento){
        this.getFarmaciaMedicamento().remove(farmaciaMedicamento);
    }

    public Set getFarmaciaMedicamento() {
        return farmaciaMedicamento;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Boolean prescricao) {
        this.prescricao = prescricao;
    }
}
