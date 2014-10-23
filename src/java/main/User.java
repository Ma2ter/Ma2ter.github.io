/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author admin
 */
public class User {
    int id;
    String login;
    String password = null;
    
    public User(int id, String login, String password) {
       setId(id);
       setLogin(login);
       setPassword(password);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

}
