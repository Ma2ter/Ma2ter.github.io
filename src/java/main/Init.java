/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import helpers.CommonHelper;
import helpers.ExceptionHandler;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "Init", urlPatterns = {"/Init"})
public class Init extends HttpServlet {

@Override
public void init(ServletConfig servletConfig){
    helpers.ExceptionHandler excH = new ExceptionHandler();
    excH.addObservable(database.DBHandler.getInstance());
    
}

}