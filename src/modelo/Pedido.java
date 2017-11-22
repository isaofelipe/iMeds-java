/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author alunodev06
 */
public class Pedido {
    public int idPedido;
    public Date data;
    public Blob imagemReceita;
    public Farmacia farmacia;
}
