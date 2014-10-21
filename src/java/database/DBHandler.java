/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Ma2ter
 */
import helpers.CommonHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public void addUser(String login, String password) {
        String cmd = String.format("insert into USERS(login, password) values (\'%s\',\'%s\')", login, password);
        query(cmd, QueryType.UPDATE_TYPE);
    }

    public Boolean checkUserExistence(String login, String password) {
        String cmd = String.format("Select count(*) as COUNT from USERS "
                + "WHERE login=\'%s\' and password=\'%s\' ", login, password);
        System.out.println(cmd);
        List<Map<String, Object>> result = (List<Map<String, Object>>) query(cmd, QueryType.SELECT_TYPE);
        if (result != null) {
            return (int) result.get(0).get("COUNT") != 0 ? true : false;
        }
        return false;
    }

    public Object query(String cmd, QueryType queryType) {
        try {
            Class.forName(dbDriver);
        } catch (Exception e) {
            //TODO ТУТ БУДЕТ ВЫЗОВ ФУНКЦИИ ВЫДАЧИ ОШИБКИ
        }
        Object result = "-1";
        Object resSet = null;
        Connection c = null;
        try {
            c = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
            Statement statement = c.createStatement();
            switch (queryType) {
                case SELECT_TYPE:
                    resSet = statement.executeQuery(cmd);
                    ResultSet rs = (ResultSet) resSet;
                    ResultSetMetaData metaData = rs.getMetaData();
                    int colCount = metaData.getColumnCount();
                    result = new ArrayList<Map<String, Object>>();
                    while (rs.next()) {
                        Map<String, Object> columns = new HashMap<String, Object>();
                        for (int i = 1; i <= colCount; i++) {
                            columns.put(metaData.getColumnLabel(i), rs.getObject(i));
                        }
                        ((ArrayList<Map<String, Object>>)result).add(columns);
                    }
                    break;
                case UPDATE_TYPE:
                    result = statement.executeUpdate(cmd);
                    break;
            }

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

        return result;
    }

    enum QueryType {

        SELECT_TYPE,
        UPDATE_TYPE
    }
}
