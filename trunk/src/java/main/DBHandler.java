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
import helpers.CommonHelper;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHandler {

    //Экземпляр объекта-одиночки.
    static String dbUrl = CommonHelper.getInstance().getInitParam("dbUrl");
    static String dbDriver = CommonHelper.getInstance().getInitParam("dbDriver");
    static String dbLogin = CommonHelper.getInstance().getInitParam("dbLogin");
    static String dbPassword = CommonHelper.getInstance().getInitParam("dbPassword");

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
        try {
            Class.forName(dbDriver);
        } catch (Exception e) {
            //TODO ТУТ БУДЕТ ВЫЗОВ ФУНКЦИИ ВЫДАЧИ ОШИБКИ
        }
        ResultSet rs = null;
        Connection c = null;
        try {
            c = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
            Statement statement = c.createStatement();
            rs = statement.executeQuery(cmd);
        } catch (SQLException e) {
            //TODO ТУТ БУДЕТ ВЫЗОВ ФУНКЦИИ ВЫДАЧИ ОШИБКИ
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
