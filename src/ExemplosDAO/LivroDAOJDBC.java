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
import modelo.Livro;
import tools.DAOBaseJDBC;

/**
 *
 * @author alunodev06
 */
public class LivroDAOJDBC extends DAOBaseJDBC implements LivroDAO {
    public boolean salvar(Livro livro) {
        PreparedStatement stmt = null;
        try{
            conn.setAutoCommit(false);
            if(livro.getId() == null)
                stmt = conn.prepareStatement("INSERT INTO Livro (tituloLivro) VALUES (?) ");
            else{
                stmt = conn.prepareStatement("UPDATE Livro SET tituloLivro = ? WHERE idLivro = ?");
                stmt.setLong(2, livro.getId());
            }
            stmt.setString(1, livro.getTitulo());
            stmt.executeUpdate(); stmt.close();
        } catch (SQLException e) {
            try{
                conn.rollback(); conn.setAutoCommit(true);
            } catch (SQLException ex) {System.out.println("Erro no rollback...");}
            return false;
        }
        return true;
    }
    
    private void gravarAutor(Livro livro){
        String sql = "UPDATE Autor SET Livro_idLivro = WHERE IDaUTOR = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, this.lerIdLivro());
            Autor autor = livro.getAutor();
            stmt.setLong(2, autor.getId());
            stmt.executeUpdate(); stmt.close();
        } catch (SQLException e) {
            System.out.println("Autor não atualizado");
        }
    }
    
    private int lerIdLivro() {
        String sql = "SELECT MAX(idLivro) FROM livro";
        PreparedStatement stmt = null;
        int idLivro = 0;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            idLivro = rs.getInt(1); stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possivel recuperar o MAX idLivro");
        }
        return idLivro;
    }
    
    public Livro consultar(String titulo) {
        Livro livroLido = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT idLivro, tituloLivro FROM Livro WHERE tituloLivro = ?");
            stmt.setString(1, titulo);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()) {
                livroLido = new Livro();
                livroLido.setId(new Long(rset.getLong("idLivro")));
                livroLido.setTitulo(rset.getString("tituloLivro"));
                Autor autor = this.lerAutor(livroLido.getId());
                livroLido.setAutor(autor); stmt.close();
            }
            else
                return null;
        } catch (SQLException e) {
            System.out.println("Falha na consulta: " + e.getMessage());
            return null;
        }
        return livroLido;
    }
    
    private Autor lerAutor(long idLivro) {
        String sql = "SELECT Autor.idAutor, Autor.nome " + "FROM Livro, Autor " + "WHERE Livro.idLivro = ? AND " + "Livro.idLivro = AutorLivro_idLivro";
        PreparedStatement stmt = null;
        Autor autorLido = null;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, idLivro);
            ResultSet rset = stmt.executeQuery();
            if(rset.next()) {
                autorLido = new Autor();
                autorLido.setId(rset.getLong("idAutor"));
                autorLido.setNome(rset.getString("nome"));
            } else 
                return null;
        } catch (SQLException e) {
            System.out.println("Falha na consulta para recuperar o Autor do Livro: ");
            return null;
        }
        return autorLido;
    }
    
    
}
