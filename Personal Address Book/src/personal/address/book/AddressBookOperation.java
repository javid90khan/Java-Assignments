/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.address.book;
import java.util.Map;
import java.util.TreeMap;
import person.Person;
import static personal.address.book.AddressBookPersist.scanner;

/**
 *
 * @author 
 */
public class AddressBookOperation {

   /* public AddressBook(TreeMap<String, Person> contacts) {
        this.contacts = contacts;
    }
    */

    /**
     *  Adds a contact to the address book with the details from user
     * @param addressBook
     */
    public static void addContact(TreeMap<String,Person> addressBook){
      
        Person person=null;
        
        System.out.println("Enter contact details\n[Enter -1 to skip a field]\n");
        System.out.println("Name:");
        
        String name=scanner.nextLine();
       
        
           
         person=new Person(name);
            if(name.trim().equals("-1")){
                System.out.println("Error: Contact name cannot be empty! Try again.");
                return;
            }
            else{
                 person.setName(name);
            }
            
            System.out.println("Address:");
            String address=scanner.nextLine();
            if(address.trim().equals("-1")){
            }
            else{
                 person.setAddress(address);
            }
            
        
            System.out.println("Email:");
            String email=scanner.nextLine();
            if(email.trim().equals("-1")){
            }
            else{
                 person.setEmail(email);
            }
        
        
            System.out.println("Phone number:");
            long phoneNumber=scanner.nextLong();
            if(phoneNumber==-1){
            }
            else{
                 person.setPhoneNumber(phoneNumber);
            }
        
            System.out.println("Alternate phone number:");
            long alternateMobileNumber=scanner.nextLong();
            if(alternateMobileNumber==-1){
            }
            else{
                 person.setAlternatePhoneNumber(alternateMobileNumber);
            }
        
            scanner.nextLine();
            System.out.println("Note:");
            String note=scanner.nextLine();
        
            if(note.trim().equals("-1")){
            }
            else{
                 person.setNote(note);
            }
        
            addressBook.put(person.getName(), person);
        
        
        System.out.println("Contact Created!"); 
        printContact(person);
    }
    
    /**
     *  Edits an address book
     * @param addressBook
     * @param name
     */
    public static void editContact(TreeMap<String,Person> addressBook,String name){
        
        Person person=searchContact(addressBook,name);
        if(person!=null){
            System.out.println("Edit contact details\n[Enter -1 to skip editing a field]\n");
            System.out.println("name:");
            
            String newName=scanner.nextLine();
        
            if(newName.trim().equals("-1")){
            }
            else{
                 person.setName(newName);
            }
            
            System.out.println("Address:");
            String address=scanner.nextLine();
            if(address.trim().equals("-1")){
            }
            else{
                 person.setAddress(address);
            }
            
        
            System.out.println("Email:");
            String email=scanner.nextLine();
            if(email.trim().equals("-1")){
            }
            else{
                 person.setEmail(email);
            }
        
        
            System.out.println("Phone number:");
            long phoneNumber=scanner.nextLong();
            if(phoneNumber==-1){
            }
            else{
                 person.setPhoneNumber(phoneNumber);
            }
        
            System.out.println("Alternate phone number:");
            long alternateMobileNumber=scanner.nextLong();
            if(alternateMobileNumber==-1){
            }
            else{
                 person.setAlternatePhoneNumber(alternateMobileNumber);
            }
        
            System.out.println("Note:");
            scanner.nextLine();
            String note=scanner.nextLine();
        
            if(note.trim().equals("-1")){
            }
            else{
                 person.setNote(note);
            }
        
            addressBook.put(person.getName(), person);

            printContact(person);
        
        }else{
            System.out.println("Error: Could not find the contact! Try again");
        }
   
      }

    /**
     * Searches and removes the contact if found
     *
     * @param addressBook
     * @param name
     * @return
     */
    public static boolean removeContact(TreeMap<String,Person> addressBook,String name){
        if(searchContact(addressBook,name)==null)
            return false;
        else{
            addressBook.remove(name);
            return true;
        }
    }
    
    /**
     *  search a contact
     * @param addressBook
     * @param name
     * @return
     */
    public static Person searchContact(TreeMap<String,Person> addressBook,String name){
        if(addressBook.containsKey(name)){
          //return the details if contact found  
          return addressBook.get(name);
        }
        else
          //return null if not found
            return null;     
    }
    
    /**
     * prints the person object
     * @param person
     */
    public static void printContact(Person person){
        System.out.println(person);
        
    }
    
    /**
     *  prints the whole address book
     * @param addressBook
     */
    public static void printAddressBook(TreeMap<String,Person> addressBook){
            int i=1;
            for (Map.Entry<String, Person> entry : addressBook.entrySet()) {
            System.out.println((i++)+". "+entry.getValue());
            }
    }
    
    /**
     *  creates a new address book
     * @return
     */
    public static TreeMap<String,Person> createAddressBook(){
         
        TreeMap<String,Person> addressBook=new TreeMap<String,Person>();
        System.out.println("Address book created");
        return addressBook;
          
    }
     
    static void saveNewAddressBook(TreeMap<String, Person> addressBook) {
         String fileName=AddressBookPersist.getFileName();
        String path=AddressBookPersist.getPath();
        if(AddressBookPersist.saveBook(addressBook, path+"/"+fileName))
            System.out.println("Address book saved successfully!");
        
        else
            System.out.println("Error saving Address book! Please try again.");
    }
    
    /**
     *  save changes to already existing address book
     * @param addressBook
     * @param absoluteFilePath
     */
    public static void saveAddressBook(TreeMap<String,Person> addressBook,String absoluteFilePath){
       if(AddressBookPersist.saveBook(addressBook, absoluteFilePath))
            System.out.println("Address book saved successfully!");
        
        else
            System.out.println("Error saving Address book! Please try again.");
         
    }
    
    /**
     * saves a new address book as a new file
     * @param absoluteFilePath
     * @return
     */
    public static TreeMap<String,Person> loadAddressBook(String absoluteFilePath){
         TreeMap<String,Person> addressBook=null;
         addressBook=AddressBookPersist.loadBook(absoluteFilePath);
         if(addressBook==null)
            System.out.println("Could not find the Address book! Please try again.");
         else{
              System.out.println("Address book loaded successfully!");
              return addressBook;
         }
        return null;        
     }

   
    
}
