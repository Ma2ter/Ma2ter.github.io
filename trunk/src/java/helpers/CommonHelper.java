/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author admin
 */
public class CommonHelper {
    
    static CommonHelper commoneHelper = null;
    
    private CommonHelper() {
        
    };
    
    static public CommonHelper getInstance() {
      if (commoneHelper == null)  {
          commoneHelper = new CommonHelper();         
      }
      return commoneHelper;
    };
    

    //Metod returns RootPath for web-application (in our case "/trunk")
    public String getRootPath (HttpServletRequest request){
        return rootPath == null ? request.getServletContext().getInitParameter("pathRoot"): rootPath;
    };
    
    private static String rootPath = null;
}
