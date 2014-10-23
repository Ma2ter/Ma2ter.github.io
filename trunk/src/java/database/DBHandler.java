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
import helpers.ConstantHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.UserManager;

public class DBHandler {

    //Экземпляр объекта-одиночки.
    static String dbUrl = ConstantHelper.dbUrl;
    static String dbDriver = ConstantHelper.dbDriver;
    static String dbLogin = ConstantHelper.dbLogin;
    static String dbPassword = ConstantHelper.dbPassword;

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
                + "where LOGIN=\'%s\' and PASSWORD=\'%s\' ", login, password);
        List<Map<String, Object>> result = (List<Map<String, Object>>) query(cmd, QueryType.SELECT_TYPE);
        if (result != null) {
            return (long) result.get(0).get("COUNT") != 0 ? true : false;
        }
        return false;
    }

    /*   public User findUserById(int id){
    String cmd = String.format ("Select * from USERS where ID = \'%s\'", id);
    List<Map<String, Object>> result = (List<Map<String, Object>>) query(cmd, QueryType.SELECT_TYPE);
    if (result != null) {
    return UserManager.getInstance().createUser((int)result.get(0).get("ID"),
    (String)result.get(0).get("LOGIN"), (String)result.get(0).get("PASSWORD"));
    }
    return null;
    }*/
    
    public Object query(String cmd, QueryType queryType) {
        try {
            Class.forName(dbDriver);
        } catch (Exception e) {
            //DOEXCEPTION
            System.out.println(e.getMessage());
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
            //DOEXCEPTION
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
