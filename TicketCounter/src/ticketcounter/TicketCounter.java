/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketcounter;

import java.util.Scanner;
import ticketcounter.stations.Station;
import ticketcounter.ticket.Ticket;

/**
 *
 * @author javidkhan
 */
public class TicketCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        
        int from,to=0;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter FROM Station number");
        from=input.nextInt();
        System.out.println("Enter TO Station Number");
        to=input.nextInt();
        
        Ticket ticket=new Ticket(Station.getStationByStopNumber(from),Station.getStationByStopNumber(to));
        System.out.println(ticket);
        
        
    }
    
}
