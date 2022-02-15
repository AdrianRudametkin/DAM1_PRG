/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package examen2021;

import java.util.Map.Entry;
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
public class ElectrodomesticosTest {
    
    public ElectrodomesticosTest() {
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
     * Test of rellenarLetras method, of class Electrodomestico.
     */
    @Test
    public void testRellenarLetras() {
        System.out.println("rellenarLetras");
        Electrodomestico.rellenarLetras();
        if(Electrodomestico.precioPorCons == null){
            fail("No se rellenaron las letras.");
        }
        for(Entry<Character,Double> e : Electrodomestico.precioPorCons.entrySet()){
            System.out.print(e.getKey()+" "+e.getValue()+" |-|");
        }
        System.out.println("");
        
    }
}
