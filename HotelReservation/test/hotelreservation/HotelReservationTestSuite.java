package hotelreservation;

import hotelreservation.common.util.InputUtilTest;
import hotelreservation.customer.CustomerTypeTest;
import hotelreservation.hotel.HotelTest;
import hotelreservation.hotel.rate.calculator.NormalRateCalStrategyTest;
import hotelreservation.hotel.rating.RatingTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author javidkhan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({InputUtilTest.class,CustomerTypeTest.class,
        HotelTest.class,NormalRateCalStrategyTest.class,RatingTest.class})
public class HotelReservationTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
