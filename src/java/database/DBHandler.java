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
import interfaces.Observer;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import managers.UserManager;

public class DBHandler implements interfaces.Observable {

    //Экземпляр объекта-одиночки.
    private ArrayList<Observer> observersList = new ArrayList<>();

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
        queryUpdate(cmd);
    }

    public Map<String, Object> getUser(String login) {
        String cmd = String.format("Select * from USERS "
                + "where LOGIN=\'%s\'", login);
        ArrayList<Map<String, Object>> resultSet = querySelect(cmd);
        if (resultSet.size() == 0) {
            return null;
        } else {
            return resultSet.get(0);
        }
    }

    public Boolean checkUserExistence(String login, String password) {
        String cmd = String.format("Select count(*) as COUNT from USERS "
                + "where LOGIN=\'%s\' and PASSWORD=\'%s\' ", login, password);
        List<Map<String, Object>> result = querySelect(cmd);
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
    public int queryUpdate(String cmd) {
        try {
            Class.forName(dbDriver);
        } catch (Exception e) {
            notifyObservers(e);
        }
        int result = 0;
        Connection c = null;
        Statement statement = null;
        try {
            c = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
            statement = c.createStatement();
            result = statement.executeUpdate(cmd);
        } catch (SQLException e) {
            notifyObservers(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                notifyObservers(e);
            }

            return result;
        }
    }

    public ArrayList<Map<String, Object>> querySelect(String cmd) {
        try {
            Class.forName(dbDriver);
        } catch (Exception e) {
            notifyObservers(e);
        }
        ArrayList<Map<String, Object>> result = null;
        Connection c = null;
        Statement statement = null;
        try {
            c = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
            statement = c.createStatement();
            ResultSet resSet = statement.executeQuery(cmd);
            result = convert(resSet);
        } catch (SQLException e) {
            notifyObservers(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                notifyObservers(e);
            }
        }

        return result;
    }

    @Override
    public void registerObserver(Observer obs) {
        observersList.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observersList.remove(obs);
    }

    @Override
    public void notifyObservers(Exception e) {
        for (Observer obs : observersList) {
            obs.update(e);
        }
    }

    private ArrayList<Map<String, Object>> convert(ResultSet resSet) {
        ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            ResultSetMetaData metaData = resSet.getMetaData();
            int colCount = metaData.getColumnCount();
            while (resSet.next()) {
                Map<String, Object> columns = new HashMap<String, Object>();
                for (int i = 1; i <= colCount; i++) {
                    columns.put(metaData.getColumnLabel(i), resSet.getObject(i));
                }
                ((ArrayList<Map<String, Object>>) result).add(columns);
            }
        } catch (SQLException e) {
            notifyObservers(e);
        }
        return result;
    }
}
