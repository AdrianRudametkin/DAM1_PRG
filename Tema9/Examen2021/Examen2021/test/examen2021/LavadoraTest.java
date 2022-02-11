/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package examen2021;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rogelio Rodriguez
 */
public class LavadoraTest {
    
    public LavadoraTest() {
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
     * Test of setCarga method, of class Lavadora.
     */
    @Test
    public void testGetSetCarga() {
        Lavadora instance = new Lavadora();
        System.out.println("setCarga");
        double carga = 55.0;
        instance.setCarga(carga);
        
        System.out.println("getCarga");
        double expResult = 55.0;
        double result = instance.getCarga();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of setCarga method, of class Lavadora.
     */
    @Test
    public void testGetCarga() {
        Lavadora instance = new Lavadora();
        System.out.println("getCarga");
        double expResult = 5.0;
        double result = instance.getCarga();
        assertEquals(expResult, result, 0.0);
        
        //Otro constructor
        instance = new Lavadora(null,10.0, 50.0, 'c', 10.0);
        
        System.out.println("getCarga");
        expResult = 10.0;
        result = instance.getCarga();
        assertEquals(expResult, result, 0.0);
    }
    
    

    /**
     * Test of precioFinal method, of class Lavadora.
     */
    @Test
    public void testPrecioFinal() {
        System.out.println("precioFinal");
        Lavadora instance = new Lavadora();
        double expResult = 0.0;
        double result = instance.precioFinal();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Lavadora.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Lavadora instance = new Lavadora();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Lavadora.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Lavadora lav = null;
        Lavadora instance = new Lavadora();
        boolean expResult = false;
        boolean result = instance.equals(lav);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
