/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author alunodev06
 */
public interface ClienteDAO {
    public void salvarCliente(String nome, String endereco, String cpf, String telefone, String email, String senha);
    
}