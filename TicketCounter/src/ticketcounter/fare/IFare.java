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
public interface IFare {
    static final double baseFare=10;
    static final double flatPrice=20;
    static final int baseFareDistance=5;
    static final double afterBaseFare=5;
    public Amount calculateFare(Station to,Station from);
}
