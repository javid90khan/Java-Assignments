/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketcounter.ticket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import ticketcounter.fare.TrainTicketFare;
import ticketcounter.fare.amount.Amount;
import ticketcounter.stations.Station;

/**
 *
 * @author javidkhan
 */
public class Ticket {
    private Station from;
    private Station to;

    /**
     *
     * @param from
     * @param to
     */
    public Ticket(Station from, Station to) {
        this.from = from;
        this.to = to;
    }
    
    /**
     * Calculates Fare based on FROM and TO Stations
     * @return
     */
    public Amount getFare(){
        return new TrainTicketFare().calculateFare(from, to);
    }
    
    @Override
    public String toString(){
        Date currentDate=new Date();
        DateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        
        return  dateFormat.format(currentDate)+"\n"+
                from.toString()+"\n"+
                to.toString()+"\n"+
                from.getStopCount(to)+" Stop\n"+
                getFare().toString();
    }
    
}
