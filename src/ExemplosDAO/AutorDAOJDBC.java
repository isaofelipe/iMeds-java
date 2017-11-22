/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Autor;
import tools.DAOBaseJDBC;

/**
 *
 * @author alunodev06
 */
public class AutorDAOJDBC extends DAOBaseJDBC implements AutorDAO {
    public boolean salvar(Autor autor) {
        PreparedStatement stmt;
        try {
            if(autor.getId() == null){
                System.out.println(" === salvando...... === ");
                stmt = conn.prepareStatement(" INSERT INTO Autor (nome) VALUES (?)");    
            }
            else {
                System.out.println(" === atualizando..... === ");
                stmt = conn.prepareStatement("UPDATE Autor SET nome = ? WHERE idAutor = ?");
                stmt.setLong(2, autor.getId());
            }
            stmt.setString(1, autor.getNome());
            stmt.executeUpdate(); stmt.close();;
            
        } catch (SQLException e){
            System.out.println("Erro SQL: " + e.getMessage());
            System.out.println("Autor não gravado pois ja esta na base de dados....: " + autor);
            return false;
        }
        return true;
    }
    public Autor consultar(String nome){
        Autor autorLido = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT idAutor, nome FROM Autor WHERE nome = ?");
            ResultSet rset = stmt.executeQuery();
            if(rset.next()) {
                autorLido = new Autor();
                autorLido.setId(new Long(rset.getLong("idAutor")));
                autorLido.setNome(rset.getString("nome")); stmt.close();
            }
            else
                return null;
        }catch (SQLException e) {
            System.out.println("Falha na consulta: " + e.getMessage());
            return null;
        }
        return autorLido;
    }
}
