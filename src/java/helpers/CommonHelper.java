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
    
    static CommonHelper commonHelper = null;
    
    private CommonHelper() {
        
    };
    
    static public CommonHelper getInstance() {
      if (commonHelper == null)  {
          commonHelper = new CommonHelper();         
      }
      return commonHelper;
    };
    
}
