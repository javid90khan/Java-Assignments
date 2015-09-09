/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 
 */
public class Person implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String address; // physical address
    private String email; // email address
    private long phoneNumber;
    private long alternatePhoneNumber;
    private String note;

    //Constructor
    public Person(String name){
        this.name = name;
        this.address = "";
        this.email = "";
        this.note = "";
    }
    public Person(String name, String address, String email, long phoneNumber, long alternatePhoneNumber, String note) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.alternatePhoneNumber = alternatePhoneNumber;
        this.note = note;
    }

    public Person() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void editPerson(String name, String address, String email, long phoneNumber, long alternatePhoneNumber, String note){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.alternatePhoneNumber = alternatePhoneNumber;
        this.note = note; 
    }
    //overridden toString() method for returning contact information
    @Override
    public String toString(){
       return "\n\t\tName: "+name
               +"\n\t\tAddress: "+address
               +"\n\t\tEmail: "+email
               +"\n\t\tPhone Number: "+phoneNumber
               +"\n\t\tAlternate Phone Number: "+alternatePhoneNumber
               +"\n\t\tNote: "+note;
        
    }
    
    @Override
    public boolean equals(Object obj) {
        
       if(obj instanceof Person){
           
        Person person=(Person)obj;
       
       if(name.equalsIgnoreCase(person.name) && address.equalsIgnoreCase(person.address) 
          && email.equalsIgnoreCase(person.email) && phoneNumber==person.phoneNumber 
          && alternatePhoneNumber==person.alternatePhoneNumber && note.equalsIgnoreCase(person.note))
           
           return true;    
        }
        return false;
    }
 /*
    getters and setters for all the fields
    */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.address);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + (int) (this.phoneNumber ^ (this.phoneNumber >>> 32));
        hash = 41 * hash + (int) (this.alternatePhoneNumber ^ (this.alternatePhoneNumber >>> 32));
        hash = 41 * hash + Objects.hashCode(this.note);
        return hash;
    }

    /**
     *
     * @return
     */
    
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @param alternatePhoneNumber
     */
    public void setAlternatePhoneNumber(long alternatePhoneNumber) {
        this.alternatePhoneNumber = alternatePhoneNumber;
    }

    /**
     *
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @return
     */
    public long getAlternatePhoneNumber() {
        return alternatePhoneNumber;
    }

    /**
     *
     * @return
     */
    public String getNote() {
        return note;
    }

}
