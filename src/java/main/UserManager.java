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
    public static User createUser(String login){
        User user = new User(login);
        userList.add(user);
        return user;
    };
    //TODO
    static void deleteUser(User user){};
    static void findUserById(int id){};
    static void findUserBySessionId(String sessionID){};
    static void findUserByLogin(String login){};
    static List<User> userList = new ArrayList<User>();
}
