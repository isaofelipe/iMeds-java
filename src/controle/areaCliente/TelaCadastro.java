/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.areaCliente;

import dao.ClienteDAOJDBC;
import modelo.Cliente;

/**
 *
 * @author alunodev02
 */
public class TelaCadastro {
    public boolean cadastrarCliente(String nome, String cpf, String endereco, String telefone, String email, String senha){
        Cliente cliente = new Cliente(nome,cpf,endereco,telefone,email,senha);
        ClienteDAOJDBC clienteDAO = new ClienteDAOJDBC();
        if(clienteDAO.salvarCliente(cliente)){
            return true;
        }
        return false;
    }
}
