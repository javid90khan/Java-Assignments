/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketcounter.fare;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ticketcounter.fare.amount.Amount;
import ticketcounter.stations.Station;

/**
 *
 * @author javidkhan
 */
public class TicketFareTest {
    
    public TicketFareTest() {
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
     * Test of CalculateFare method, of class TicketFare.
     */
    @Test
    public void testCalculateFare() {
        System.out.println("CalculateFare");
        Station to = Station.CHENNAI_BEACH;
        Station from = Station.TAMBARAM_SANATORIUM;
        Amount expResult = new Amount(20);
        Amount result = new TrainTicketFare().calculateFare(to, from);
        assertEquals(expResult, result);
    }
    
}
