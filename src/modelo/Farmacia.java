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
public class Farmacia extends Usuario{
    public int idFarmacia;
    public String nome;
    public String CNPJ;
    public String endereco;
    public String telefone;
    public Usuario usuario;
    
    private Set farmaciaMedicamento;
    
    public Farmacia(){
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
    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
