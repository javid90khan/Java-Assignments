package hotelreservation.hotel;

import hotelreservation.customer.CustomerType;
import hotelreservation.hotel.rate.Rate;
import hotelreservation.hotel.rate.calculator.IRateCalStrategy;
import hotelreservation.hotel.rating.Rating;
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
public class HotelTest {
    
    public HotelTest() {
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
     * Test of compareTo method, of class Hotel.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Rate rate1=new Rate(12,13,12,13);
        rate1.setRate(100);
        Hotel o = new Hotel("test",Rating.FOUR_STAR,rate1);
        
        Hotel instance = new Hotel("test",Rating.FIVE_STAR,rate1);
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
}
