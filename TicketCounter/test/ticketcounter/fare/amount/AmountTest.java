/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketcounter.fare.amount;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author javidkhan
 */
public class AmountTest {
    
    public AmountTest() {
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
     * Test of getValue method, of class Amount.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Amount instance = new Amount(0);
        double expResult = 0.0;
        double result = instance.getValue();
        assertEquals(expResult, result, 0.0);
    }

 

    /**
     * Test of add method, of class Amount.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Amount amount = new Amount(10);
        Amount instance = new Amount(11);
        Amount expResult = new Amount(21);
        Amount result = instance.add(amount);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of compareTo method, of class Amount.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object o = new Amount(10);
        Amount instance = new Amount(10);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
}
