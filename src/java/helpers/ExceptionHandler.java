/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import interfaces.Observable;

/**
 *
 * @author Ma2ter
 */
public class ExceptionHandler implements interfaces.Observer {

    public ExceptionHandler(Observable o){
        o.registerObserver(this);
    }
    
    @Override
    public void update(Exception e) {
        System.out.println(e.getMessage());
    }
    
}
