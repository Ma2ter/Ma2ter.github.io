/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.servlet.http.*;
import interfaces.Observable;
import java.sql.SQLException;

/**
 *
 * @author Ma2ter
 */
public class ExceptionHandler implements interfaces.Observer { 
    
    public ExceptionHandler(){
        
    }
    
    public void addObservable(Observable o){
        o.registerObserver(this);
    }
    
    @Override
    public void update(Exception e) {
        System.out.println(e.getMessage());
        if(e instanceof SQLException){
            SQLException ex = (SQLException)e;
            System.out.println(ex.getErrorCode());
            
        }
    }
    
}
