/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alunodev06
 */
public class DAOBaseJDBC {
    protected static Connection conn;
    static {
        try {
            Class.forName(Config.NOME_DRIVER);
            conn = DriverManager.getConnection(Config.BD_URL, Config.BD_LOGIN, Config.BD_SENHA);
        } 
        catch (ClassNotFoundException e) {
            System.out.println("FATAL: driver não encontrado" + e.getMessage());
            System.exit(1);
        } 
        catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
            System.exit(1);
        }
    }
}
