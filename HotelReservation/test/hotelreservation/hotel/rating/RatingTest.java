package hotelreservation.hotel.rating;

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
public class RatingTest {
    
    public RatingTest() {
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
     * Test of valueOf method, of class Rating.
     */
    @Test
    public void testValueOf_int() {
        System.out.println("valueOf");
        int legNo = 1;
        Rating expResult = Rating.ONE_STAR;
        Rating result = Rating.valueOf(legNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Rating.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Rating instance = Rating.THREE_STAR;
        String expResult = "THREE_STAR";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Rating.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTO");
        Rating instance1 = Rating.THREE_STAR;
        Rating instance2 = Rating.FOUR_STAR;
        int expResult = 1;
        int result = instance1.compareTo(instance2);
        assertEquals(expResult, result);
    }
    
}
