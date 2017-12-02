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
public class Cliente extends Usuario {
    public int idCliente;
    public String nome;
    public String CPF;
    public String endereco;
    public String telefone;

    public Cliente(int idCliente, String nome, String CPF, String endereco, String telefone, String email, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(String nome, String CPF, String endereco, String telefone, String email, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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
}
