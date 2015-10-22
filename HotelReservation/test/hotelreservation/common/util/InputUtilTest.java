package hotelreservation.common.util;

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
public class InputUtilTest {
    
    public InputUtilTest() {
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
     * Test of readCSVFile method, of class InputUtil.
     */
    @Test
    public void testReadCSVFile() {
        System.out.println("readCSVFile");
        String filePath = "/hotelreservation/common/config/hotelData.csv";
        String[][] expResult ={
            {"Lakewood","3","110","80","90","80"},
            {"Bridgewood","4","160","110","60","50"},
            {"Ridgewood","5","220","100","150","40"}
        };
        String[][] result = InputUtil.readCSVFile(filePath);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of pareDate method, of class InputUtil.
     */
    @Test
    public void testPareDate() {
        System.out.println("pareDate");
        String dateString = "17Mar2009(tues)";
        String format = "ddMMMyyyy";
        Date expResult = new Date("03/17/2009");
 
        Date result = InputUtil.pareDate(dateString, format);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateInput method, of class InputUtil.
     */
    @Test
    public void testValidateInput() {
        System.out.println("validateInput");
        String inputPattern = "\\w*:\\s*\\w{9}\\(\\w{0,}\\),\\s*\\w{0,}\\(\\w{0,}\\),\\s*\\w{9}\\(\\w{0,}\\)";
        String input = "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)";
        InputUtil.validateInput(inputPattern, input);
    }

}