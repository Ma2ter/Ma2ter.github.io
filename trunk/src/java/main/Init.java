/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import helpers.CommonHelper;
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
    CommonHelper commonHelper = CommonHelper.getInstance();
    //TODO Make list of  param-names to load all at ones
    commonHelper.setInitParam(servletConfig.getServletContext(), "rootPath");
    commonHelper.setInitParam(servletConfig.getServletContext(), "dbUrl");
    commonHelper.setInitParam(servletConfig.getServletContext(), "dbDriver");
    commonHelper.setInitParam(servletConfig.getServletContext(), "dbLogin");
    commonHelper.setInitParam(servletConfig.getServletContext(), "dbPassword");
}

}