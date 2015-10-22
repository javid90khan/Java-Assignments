/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.hotel.rate.calculator;

import hotelreservation.customer.CustomerType;
import hotelreservation.hotel.rate.Rate;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author javidkhan
 */
public class NormalRateCalStrategy implements IRateCalStrategy{

    /**
     * calculate rate based on Normal strategy,
     * create additional classes for other rate calculation strategies
     * @param customerType customer type
     * @param days days of stay
     * @param rate rate object
     */
    @Override
    public void calculateRate(CustomerType customerType, Date[] days, Rate rate) {
        double totalRate=0;
        double weekdayRate=0;
        double weekendRate=0;
        if(customerType.equals(CustomerType.REGULAR)){
            weekdayRate=rate.getRegularWeekday();
            weekendRate=rate.getRegularWeekend();
        }else{
            weekdayRate=rate.getRewardWeekday();
            weekendRate=rate.getRewardWeekend();
        }
        
        for(Date day:days){
            if(isWeekend(day)){
                totalRate+=weekendRate;
            }else{
                totalRate+=weekdayRate;
            }
        }
        
        rate.setRate(totalRate);
    }
    
    /**
     * check if date is a weekend
     * @param date Date object
     * @return true if the Date is of weekend
     */
    public boolean isWeekend(Date date){
        //Date.getDay is depricated hence using Calander object
        Calendar calender=Calendar.getInstance();
        calender.setTime(date);
        int day=calender.get(Calendar.DAY_OF_WEEK);
        if(day==Calendar.SATURDAY || day==Calendar.SUNDAY){
            return true;
        }else{
            return false;
        }
    }
}
