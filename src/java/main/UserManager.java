/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserManager {
    
    static UserManager userManager = null;
    
    private UserManager() {
        
    }
    
    static public UserManager getInstance(){
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }
    

    //TODO
    static List<User> userList = new ArrayList<User>();
}
