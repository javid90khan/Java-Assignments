package hotelreservation.hotel;

import hotelreservation.customer.CustomerType;
import hotelreservation.hotel.rate.Rate;
import hotelreservation.hotel.rate.calculator.IRateCalStrategy;
import hotelreservation.hotel.rating.Rating;
import java.util.Date;

/**
 * Hotel entity class
 * @author javidkhan
 */
public class Hotel implements Comparable<Hotel>{
    private String name;
    private Rating rating;
    private Rate rate;

    /**
     * 
     * @param name hotel name
     * @param rating hotel rating
     * @param rate hotel rate
     */
    public Hotel(String name, Rating rating, Rate rate) {
        this.name = name;
        this.rating = rating;
        this.rate = rate;
    }
    
    /**
     * 
     * @param customerType type of customer
     * @param days array of booking dates 
     * @param rateCalStrategy rate calculation strategy object
     */
    public void calculateRate(CustomerType customerType,Date[] days,IRateCalStrategy rateCalStrategy){
        rateCalStrategy.calculateRate(customerType, days,this.rate);
    }

    @Override
    public int compareTo(Hotel o) {
        //check if both hotels have the same RATE
        int returnVal=this.rate.compareTo(o.rate);
        
        //if they do, compare them based on Rating
        if(returnVal==0){
            returnVal= this.rating.compareTo(o.rating);
        }
        return returnVal;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
