/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketcounter.fare.amount;

/**
 *
 * @author javidkhan
 */
public class Amount implements Comparable{
    private double value;
    private String CurrencySymbol="₹";

    /**
     *
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     *
     * @param value
     */
    public Amount(double value){
        this.value=value;
    }

    /**
     *
     * @param value
     * @param CurrencySymbol
     */
    public Amount(double value, String CurrencySymbol) {
        this.value = value;
        this.CurrencySymbol = CurrencySymbol;
    }
    
    

    @Override
    public String toString() {
        return CurrencySymbol+" "+value;
    }
    
    /**
     * Adds to Amount values
     * @param amount
     * @return
     */
    public Amount add(Amount amount){
        return new Amount(this.getValue()+amount.getValue());
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Amount){
            if(getValue()>((Amount)o).getValue()){
                return 1;
               
            }else if(getValue()<((Amount)o).getValue()){
                return -1;
            }else{
                return 0;
            }
        }
        return 0;
    }
    
    
  
}
