/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Medicamento;

/**
 *
 * @author alunodev06
 */
public interface MedicamentoDAO {
    public ArrayList<Medicamento> buscarTodos();
    public Medicamento buscarPorNome(String nome);
}
