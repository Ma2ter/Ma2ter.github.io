/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import main.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ma2ter
 */
public class EntityManagerIT {
    
    public EntityManagerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        EntityManager instance = EntityManager.getInstance();
        instance.createUser("login=Ma2ter,password=1234,email=qweqwe");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getUser method, of class EntityManager.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String param = "login=Ma2ter";
        EntityManager instance = EntityManager.getInstance();
        
        User result = instance.getUser(param);
        assertEquals("Ma2ter", result.getLogin());
        assertEquals("1234", result.getPassword());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createUser method, of class EntityManager.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        String param = "";
        EntityManager instance = EntityManager.getInstance();
        
        User result = instance.createUser("login=test,password=test");
        assertEquals("test", result.getLogin());
        assertEquals("test", result.getPassword());
        assertEquals("7", result.getId());
        
    }
    
}
