/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Farmacia;

/**
 *
 * @author alunodev06
 */
public interface FarmaciaDAO {
    public boolean salvarFarmacia(Farmacia farmacia);
    
    public List<Farmacia> buscarTodas();
    
    public Farmacia buscarPorId(int idFarmacia);
    public Farmacia buscarPorNome(String nome);
}
