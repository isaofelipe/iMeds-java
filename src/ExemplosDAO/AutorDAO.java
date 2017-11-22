/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosDAO;

import modelo.Autor;

/**
 *
 * @author alunodev06
 */
public interface AutorDAO {
    public boolean salvar(Autor artista);
    public Autor consultar(String nome);
}
