/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Ma2ter
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHandler {

    //Экземпляр объекта-одиночки.
    String dbUrl = "jdbc:derby://localhost:1527/sample";
    String Driver = "org.apache.derby.jdbc.ClientDriver";
    String dbLogin = "Letanir";
    String dbPassword = "1qaz@WSX";

    static DBHandler dbHandler = null;

    //приватный конструктор, чтобы избежать возможность повторного создания.
    private DBHandler() {

    }

    //Метод получения объекта одиночки.
    static public DBHandler getInstance() {
        if (dbHandler == null) {
            dbHandler = new DBHandler();
        }
        return dbHandler;
    }

    public ResultSet query(String cmd) {
        ResultSet rs = null;
        Connection c = null;
        try {
            c = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
            Statement statement = c.createStatement();
            rs = statement.executeQuery(cmd);
        } catch (SQLException e) {
            //ТУТ БУДЕТ ВЫЗОВ ФУНКЦИИ ВЫДАЧИ ОШИБКИ
            System.out.println(e.getMessage());
        } finally {
            try {
                c.close();
            } catch (Exception ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }

}
