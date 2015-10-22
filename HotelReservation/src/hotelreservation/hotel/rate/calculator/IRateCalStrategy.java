package hotelreservation.hotel.rate.calculator;

import hotelreservation.customer.CustomerType;
import hotelreservation.hotel.rate.Rate;
import java.util.Date;

/**
 * Making use of Strategy design pattern as the rate calculation method-
 * may vary based on Date or any other additional criteria
 * 
 * @author javidkhan
 */
public interface IRateCalStrategy {

    /**
     *
     * @param customerType
     * @param days
     * @param rate
     */
    public void calculateRate(CustomerType customerType, Date[] days, Rate rate);
}
