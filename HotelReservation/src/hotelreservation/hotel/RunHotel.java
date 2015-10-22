package hotelreservation.hotel;

import hotelreservation.common.util.InputUtil;
import hotelreservation.customer.CustomerType;
import hotelreservation.hotel.rate.calculator.NormalRateCalStrategy;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author javidkhan
 */
public class RunHotel {
    private static final String dateFormat="ddMMMyyyy";
    //regular expresion to validate the input
    private static final String inputPattern=
            "\\w*:\\s*\\w{9}\\(\\w*\\),\\s*\\w{9}\\(\\w*\\),\\s*\\w{9}\\(\\w*\\)";
    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        //Create the service once, which will initiliaze all the hotels
        HotelService service = new HotelService();
        
        /*Can use the same service instance for multiple inputs
        by adding a loop here that iteratively takes user inputs
        */
        try{
            String input = in.nextLine();
            //trim leading & trailing spaces
            input=input.trim();
            // validate input string
            InputUtil.validateInput(inputPattern,input);
            
            //extract customer type
            String type=input.substring(0, input.indexOf(":"));
            input=input.substring(input.indexOf(":")+1);

            CustomerType customerType = 
                    CustomerType.valueOf(type.toUpperCase(Locale.ENGLISH));
            
            //extract & convert dates
            String[] dates=input.split(",");
            Date[] stayDates=new Date[dates.length];

            int i=0;
            for(String date:dates){
                stayDates[i++]=InputUtil.pareDate(date.trim(),dateFormat);
            }
            //call the service to find the cheapest hotel
            //here rate cal startegy can differ based on additional constraints,
            //that might come up in future
            System.out.println(""+service.getCheapestHotel(
                    customerType,stayDates,new NormalRateCalStrategy()));
            
        }catch(Exception e){
            System.err.println("Error in input:"+e.getMessage());
        }
    }
    
    
    
}
