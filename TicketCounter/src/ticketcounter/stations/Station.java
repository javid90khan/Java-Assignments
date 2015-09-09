/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketcounter.stations;

/**
 *
 * @author javidkhan
 */
public enum Station {

    /**
     *
     */
    CHENNAI_BEACH(1,"Chennai Beach"),

    /**
     *
     */
    CHENNAI_FORT(2,"Chennai Fort"),

    /**
     *
     */
    CHENNAI_PARK(3,"Chennai Park"),

    /**
     *
     */
    CHENNAI_EGMORE(4,"Chennai Egmore"),

    /**
     *
     */
    CHETPET(5,"Chetpet"),

    /**
     *
     */
    NUNGAMBAKKAM(6,"Nungambakkam"),

    /**
     *
     */
    KODAMBAKKAM(7,"Kodambakkam"),

    /**
     *
     */
    MAMBALAM(8,"Mambalam"),

    /**
     *
     */
    SAIDAPET(9,"Saidapet"),

    /**
     *
     */
    GUINDY(10,"Guindy"),

    /**
     *
     */
    ST_THOMAS_MOUNT(11,"St. Thomas Mount"),

    /**
     *
     */
    PAZHAVANTHANGAL(12,"Pazhavanthangal"),

    /**
     *
     */
    MEENAMBAKKAM(13,"Meenambakkam"),

    /**
     *
     */
    TRISULAM(14,"Trisulam"),

    /**
     *
     */
    PALLAVARAM(15,"Pallavaram"),

    /**
     *
     */
    CHROMEPET(16,"Chromepet"),

    /**
     *
     */
    TAMBARAM_SANATORIUM(17,"Tambaram Sanatorium"),

    /**
     *
     */
    TAMBARAM(18,"Tambaram");
    
    private String name;
    private int stopNumber;
    
    
    private Station(int stopNumber,String name){
        this.stopNumber=stopNumber;
        this.name=name;
    }
    
    /**
     * getter for stopNumber
     * @return
     */
    public int getSopNumber(){
        return this.stopNumber;
    }
    
    /**
     * getter for Station Name
     * @return
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * gives the no.of stops between 2 Station
     * @param to
     * @return
     */
    public int getStopCount(Station to){
        return Math.abs(to.getSopNumber()-this.getSopNumber());
    }
    
    /**
     * gives no.of stations
     * @return
     */
    public static int length(){
        return Station.values().length;
    }
    
    /**
     * gives Station based on stopNumber
     * @param stopNumber
     * @return
     */
    public static Station getStationByStopNumber(int stopNumber){
        for(Station station:Station.values()){
            if(station.stopNumber==stopNumber){
                return station;
            }
            
        }
        throw new IllegalArgumentException("Invalid Stop Number");
    }
    
    @Override
    public String toString(){
       return this.name;
    }

}
