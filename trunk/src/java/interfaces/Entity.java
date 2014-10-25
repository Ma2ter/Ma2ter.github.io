/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ma2ter
 */
public abstract class Entity {

    protected HashMap<String, String> paramList;
    
    public Entity(){
        paramList = new HashMap<String, String>();
    }
    
    public void setParams(String params) {
        String[] paramSet = params.split(",");
        for (String s : paramSet) {
            paramList.put(s.split("=")[0], s.split("=")[1]);
        }
    }

    public void setParams(Map<String, String> paramSet) {
        for(String keyName : paramSet.keySet()){
            paramList.put(keyName, paramSet.get(keyName));
        }
    }

    public String getParam(String paramName) {
        return paramList.get(paramName);
    }

    public Map<String, String> getParams() {
        return paramList;
    }
}
