/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;

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
  /*  public String getRootPath (HttpServletRequest request){
        return rootPath == null ? request.getServletContext().getInitParameter("rootPath"): rootPath;
    };*/
    public void setInitParam (ServletContext servletContext, String paramName){
        initParamList.put(paramName, servletContext.getInitParameter(paramName));
    }
    
    public String getInitParam (String paramName){
        return initParamList.get(paramName);
    }
    private static Map <String, String> initParamList = new HashMap <String, String>();
}
