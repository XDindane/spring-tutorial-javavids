/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.tutorial.javavids.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spring.tutorial.javavids.entity.Item;
import spring.tutorial.javavids.exception.RssException;

/**
 *
 * @author denis
 */
public class RssServiceTest {
    
    
    public RssServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getItems method, of class RssService.
     */
    @org.junit.Test
    public void testGetItems_File() throws RssException {
        System.out.println("getItems File");
        File file = new File("src/test/java/javavids.xml");
        RssService instance = new RssService();
        List<Item> result = instance.getItems(file);
//        size of list
        assertEquals(10, result.size());
        
//        testing first item
        Item firstItem = result.get(0);
        assertEquals("How to solve Source not found error during debug in Eclipse", firstItem.getTitle());
        assertEquals("22 06 2014 22:35:49", 
                new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
    }

//    /**
//     * Test of getItems method, of class RssService.
//     */
//    @org.junit.Test
//    public void testGetItems_String() throws Exception {
//        System.out.println("getItems String");
//        String url = "";
//        RssService instance = new RssService();
//        List<Item> expResult = null;
//        List<Item> result = instance.getItems(url);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
