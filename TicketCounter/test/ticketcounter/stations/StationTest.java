/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketcounter.stations;

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
public class StationTest {
    
    public StationTest() {
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
     * Test of toString method, of class Station.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Station instance = Station.CHETPET;
        String expResult = "Chetpet";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of getSopNumber method, of class Station.
     */
    @Test
    public void testGetSopNumber() {
        System.out.println("getSopNumber");
        Station instance = Station.TAMBARAM_SANATORIUM;
        int expResult = 17;
        int result = instance.getSopNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Station.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Station instance = Station.ST_THOMAS_MOUNT;
        String expResult = "St. Thomas Mount";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

   

    /**
     * Test of getStopCount method, of class Station.
     */
    @Test
    public void testGetStopCount() {
        System.out.println("getStopCount");
        Station to = Station.CHENNAI_FORT;
        Station instance = Station.GUINDY;
        int expResult = 8;
        int result = instance.getStopCount(to);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of valueOf method, of class Station.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "CHETPET";
        Station expResult = Station.CHETPET;
        Station result = Station.valueOf(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of values method, of class Station.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Station[] expResult = null;
        Station[] result = Station.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class Station.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        int expResult = 0;
        int result = Station.length();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStationByStopNumber method, of class Station.
     */
    @Test
    public void testGetStationByStopNumber() {
        System.out.println("getStationByStopNumber");
        int stopNumber = 19;
        Station expResult = Station.TAMBARAM;
        Station result = Station.getStationByStopNumber(stopNumber);
        assertEquals(expResult, result);
    }
    
}
