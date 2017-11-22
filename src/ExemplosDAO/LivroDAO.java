/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosDAO;

import modelo.Livro;

/**
 *
 * @author alunodev06
 */
public interface LivroDAO {
    public boolean salvar(Livro livro);
    public Livro consultar(String titulo);
}
