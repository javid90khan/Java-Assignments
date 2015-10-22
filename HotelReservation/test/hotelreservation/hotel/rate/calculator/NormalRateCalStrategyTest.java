package hotelreservation.hotel.rate.calculator;

import hotelreservation.customer.CustomerType;
import hotelreservation.hotel.rate.Rate;
import java.util.Date;
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
public class NormalRateCalStrategyTest {
    
    public NormalRateCalStrategyTest() {
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
     * Test of calculateRate method, of class NormalRateCalStrategy.
     */
    @Test
    public void testCalculateRate() {
        System.out.println("calculateRate");
        CustomerType customerType = CustomerType.REGULAR;
        Date[] days ={new Date()};
        Rate rate = new Rate(60,20,30,25);
        NormalRateCalStrategy instance = new NormalRateCalStrategy();
        instance.calculateRate(customerType, days, rate);
        String actualResult=rate.toString();
        String expectedResult="60.0";
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test of isWeekend method, of class NormalRateCalStrategy.
     */
    @Test
    public void testIsWeekend() {
        System.out.println("isWeekend");
        Date date = new Date();
        NormalRateCalStrategy instance = new NormalRateCalStrategy();
        boolean expResult = false;
        boolean result = instance.isWeekend(date);
        assertEquals(expResult, result);
    }
    
}
