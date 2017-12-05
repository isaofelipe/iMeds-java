/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import dao.ClienteDAOJDBC;
import dao.FarmaciaDAOJDBC;
import modelo.Cliente;
import modelo.Farmacia;

/**
 *
 * @author Isao Felipe Morigaki
 */
public class Sessao {
    public static Farmacia farmaciaLogada = new FarmaciaDAOJDBC().buscarPorId(1);
    public static Cliente clienteLogado = new ClienteDAOJDBC().buscarClientePorId(3);
}
