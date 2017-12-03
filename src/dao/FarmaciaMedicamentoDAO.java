/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.FarmaciaMedicamento;

/**
 *
 * @author Isao Felipe Morigaki
 */
public interface FarmaciaMedicamentoDAO {
    public List<FarmaciaMedicamento> buscarPorIdFarmacia(int idFarmacia);
    public List<FarmaciaMedicamento> buscarPorIdMedicamento(int idMedicamento);
    public FarmaciaMedicamento buscarPorIds(int idMedicamento, int idFarmacia);
    public Double buscarPrecoPorIds(int idMedicamento, int idFarmacia);
}
