/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketcounter.fare;

import ticketcounter.fare.amount.Amount;
import ticketcounter.stations.Station;

/**
 *
 * @author javidkhan
 */
public class TrainTicketFare implements IFare{        
    /**
     * Calculates Fare 
     * @param to
     * @param from
     * @return
     */
    public Amount calculateFare(Station to,Station from){
        double fare=0;
        
        int stopCount=from.getStopCount(to);
        
        if(stopCount==Station.length()-1){
            fare=flatPrice;
        }else if(stopCount!=0){
            
                stopCount-=baseFareDistance;
                fare+=baseFare;
                 
           /*
                if(stopCount>0 && stopCount>baseFareDistance){
                fare+=afterBaseFare;
                stopCount-=baseFareDistance;
            }
         
           if(stopCount>0){
               fare+=afterBaseFare;
           }
                   */
        if(stopCount>0 && stopCount>baseFareDistance){
            int multiplier=stopCount%baseFareDistance==0?stopCount/baseFareDistance:(stopCount/baseFareDistance)+1;
            fare+=multiplier*afterBaseFare;
        }
        }
        return new Amount(fare);
    }
}
    

