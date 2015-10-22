package hotelreservation.hotel;

import hotelreservation.common.util.InputUtil;
import hotelreservation.customer.CustomerType;
import hotelreservation.hotel.rate.Rate;
import hotelreservation.hotel.rate.calculator.IRateCalStrategy;
import hotelreservation.hotel.rating.Rating;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author javidkhan
 */
public class HotelService {

    private List<Hotel> allHotels;
    private final String filePath = "/hotelreservation/common/config/hotelData.csv";

    /**
     * load all the hotel details from file,
     * as soon as the HotelService object is created
     */
    public HotelService() {
        super();
        intitialize();
    }

    private void intitialize() {

        String[][] hotelsFromFile = InputUtil.readCSVFile(filePath);

        allHotels = new ArrayList<>();

        try {
            for (String[] hotelData : hotelsFromFile) {

                if (hotelData.length == 6) {
                    String name = hotelData[0];
                    int rating = Integer.parseInt(hotelData[1]);
                    double regularWeekday = Double.parseDouble(hotelData[2]);
                    double rewardWeekday = Double.parseDouble(hotelData[3]);
                    double regularWeekend = Double.parseDouble(hotelData[4]);
                    double rewardWeekend = Double.parseDouble(hotelData[5]);

                    allHotels.add(
                            new Hotel(name, Rating.valueOf(rating),
                                    new Rate(regularWeekday, rewardWeekday, regularWeekend, rewardWeekend)));
                } else {
                    throw new IOException("Invalid data in CSV file");
                }

            }
        } catch (Exception e) {
            System.err.println("Error while intitilizing Hotel Service " + e.getMessage());
        }
    }

    /**
     *
     * @param customerType customer type
     * @param days days of stay
     * @param rateCalStrategy rate calculation strategy
     * @return the cheapest hotel
     */
    public Hotel getCheapestHotel(CustomerType customerType, Date[] days, IRateCalStrategy rateCalStrategy) {

        //calculate rate
        for (Hotel hotel : allHotels) {
            hotel.calculateRate(customerType, days, rateCalStrategy);
        }

        
        //find the cheapest
        Hotel cheapest = allHotels.get(0);
        for (Hotel hotel : allHotels) {

            if (cheapest.compareTo(hotel) > 0) {
                cheapest = hotel;
            }
        }
        return cheapest; 
    }

}
