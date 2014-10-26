/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author admin
 */
public class User extends interfaces.Entity {

    //
    public User(){
        super();
    }

    public User(String params) {
        super();
        setParams(params);
    }


    //<editor-fold defaultstate="collapsed" desc="Getters">
    public int getId() {
        return paramList.get("id") == null ? null : Integer.parseInt(paramList.get("id"));
    }

    public String getLogin() {
        return paramList.get("login") == null ? null : paramList.get("login");
    }

    public String getPassword() {
        return paramList.get("password") == null ? null : paramList.get("password");
    }

    public String getEmail() {
        return paramList.get("email") == null ? null : paramList.get("email");
    }

//</editor-fold>
}
