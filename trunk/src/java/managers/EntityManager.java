/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import database.DBHandler;
import interfaces.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import main.User;

/**
 *
 * @author Ma2ter
 */
public class EntityManager {

    private DBHandler dBHandler;
    private Map<String, ArrayList<Entity>> entitiesList = null;
    private static EntityManager entityManager = null;

    private EntityManager() {
        entitiesList = new HashMap<String, ArrayList<Entity>>();
        dBHandler = DBHandler.getInstance();
    }

    /**
     * param example - "login=Ma2ter"
     */
    public User createUser(String param) {
        User result = new User(param);
        if(dBHandler.checkUserExistence(result.getLogin())) return null;
        dBHandler.addUser(result.getLogin(), result.getPassword());
        result.setParams("id=" + 
                dBHandler.getUser(result.getLogin()).get("id"));
        addEntity(result);
        return result;
    }
    public User getUser(String param) {

        User result = (User) getEntity(new User(), param);
        return result;
    }
    public void removeUser(User u){
        removeEntity(u);           
    }
    
    /*
     *Set = ADD OR UPDATE (depends on example;
     *example - type of Entity to add/update
     *params - params of entity to add/update. Example - "login=Ma2ter,password=qwe"
     */
    private void setEntity(Entity example, String params) {
        ArrayList<Entity> row = null;
        if (entitiesList.get(example.getClass().toString()) == null) {
            row = new ArrayList<Entity>();
            entitiesList.put(example.getClass().toString(), row);
        } else {
            row = entitiesList.get(example.getClass().toString());
        }

        if (row.contains(example)) {
            row.get(row.indexOf(example)).setParams(params);
        } else {
            example.setParams(params);
            row.add(example);
        }

    }

    private void addEntity(Entity entity) {
        ArrayList<Entity> row = null;
        if (entitiesList.get(entity.getClass().toString()) == null) {
            row = new ArrayList<Entity>();
            entitiesList.put(entity.getClass().toString(), row);
        } else {
            row = entitiesList.get(entity.getClass().toString());
        }
        row.add(entity);

    }

    private void removeEntity(Entity entity) {
        ArrayList<Entity> row = null;
        if (entitiesList.get(entity.getClass().toString()) == null) {
            row = new ArrayList<Entity>();
            entitiesList.put(entity.getClass().toString(), row);
        } else {
            row = entitiesList.get(entity.getClass().toString());
        }
        row.remove(entity);
    }

    private Entity getEntity(Entity example, String criteria) {
        ArrayList<Entity> row = entitiesList.get(example.getClass().toString());
        for (Entity e : row) {
            if (check(e, criteria)) {
                return e;
            }
        }
        return null;
    }

    static public EntityManager getInstance() {
        if (entityManager == null) {
            entityManager = new EntityManager();
        }
        return entityManager;

    }

    private boolean check(Entity e, String criteria) {
        String[] params = criteria.split(",");
        for (String s : params) {
            String paramKey = s.split("=")[0];
            String paramValue = s.split("=")[1];
            String test1 = e.getParam(paramKey);
            if (e.getParam(paramKey) == null) {
                return false;
            }
            if (!e.getParam(paramKey).equals(paramValue)) {
                return false;
            }
        }
        return true;
    }

}
