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
    
    private User createUser(int id, String login, String password){
        User user = new User(id, login, password);
        userList.add(user);
        return user;
    };
    //TODO
    private void deleteUser(User user){
        userList.remove(user);
    };
    
   /* private User findUserById(int id){
        
    };*/
    
    private void findUserBySessionId(String sessionID){};
    private void findUserByLogin(String login){};
    static List<User> userList = new ArrayList<User>();
}
