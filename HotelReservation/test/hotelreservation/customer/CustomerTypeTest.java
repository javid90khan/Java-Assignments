package hotelreservation.customer;

import java.util.Locale;
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
public class CustomerTypeTest {
    
    public CustomerTypeTest() {
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
     * Test of valueOf method, of class CustomerType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
       
        CustomerType expResult = CustomerType.REGULAR;
        CustomerType result = CustomerType.valueOf("Regular".toUpperCase(Locale.ENGLISH));
        assertEquals(expResult, result);
        
        
    }
    
}
