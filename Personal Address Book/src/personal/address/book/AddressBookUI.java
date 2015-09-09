/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.address.book;


import java.util.TreeMap;
import person.Person;
import static personal.address.book.AddressBookPersist.scanner;

/**
 *
 * @author 
 */
public class AddressBookUI {
    
    private static TreeMap<String,Person> addressBook ;
    
    /**
     *  main
     * @param args
     */
    public static void main(String[] args) {
        
        boolean runAppAgain=true;
        printMainMenu();
        
        do{    
        System.out.println("Select operation:\n[Enter 8 for help]\n");
        int mainMenuChoice=Integer.parseInt(scanner.next());
        
        switch(mainMenuChoice){
        
            case 1:
                    
                    addressBook=AddressBookOperation.createAddressBook();
                    operateAddressBook(null);
                    
                    
                    
                    break;
       
            case 2:
                    String path=AddressBookPersist.getPath();
                    String fileName=AddressBookPersist.getFileName();
                    addressBook=AddressBookOperation.loadAddressBook(path+"/"+fileName);
                    if(addressBook!=null)
                    operateAddressBook(path+"/"+fileName);
                    break;
                
            case 3:
                    runAppAgain=false;
                    break;
            
            case 8:
                    printMainMenu();
                    break;
            
            default:
                    System.out.println("Invalid Choice!");
        
             }
        
        }while(runAppAgain!=false);
       
    }
    
    /**
     *  operations on address the book
     * @param absoluteFilePath
     */
    public static void operateAddressBook(String absoluteFilePath){
        
        printOperations();
        
        boolean continueOperation=true;
        String name=null;
        
        do{
        System.out.println("Select operation:\n[Enter 8 for help]\n");
            
        int operation=scanner.nextInt();
        scanner.nextLine();
        switch(operation){
            case 1:
                System.out.println("$Add Contact$");
                AddressBookOperation.addContact(addressBook);
                
                break;
                
            case 2:
                System.out.println("$Search Contact$");
                name=getContactName();
                Person person=AddressBookOperation.searchContact(addressBook,name);
                if(person!=null)
                    AddressBookOperation.printContact(person);
                else
                    System.out.println("Error: Could not find the contact! Try again");
                break;
                
            case 3:
                System.out.println("$Edit Contact$");
                name=getContactName();
                AddressBookOperation.editContact(addressBook, name);
                break;
                
            case 4:
                System.out.println("$Remove Contact$");
                name=getContactName();
                if(AddressBookOperation.removeContact(addressBook, name))
                    System.out.println("Contact removed successfully!");
                
                break;
                
            case 5:
                System.out.println("$Save Address book$");
                if(absoluteFilePath==null){
                    AddressBookOperation.saveNewAddressBook(addressBook);
                }
                else{
                    AddressBookOperation.saveAddressBook(addressBook, absoluteFilePath);
                }
                break;
                
            case 6:
                System.out.println("$All contacts$");
                AddressBookOperation.printAddressBook(addressBook);
                break;
                
            case 7:
                System.out.println("$Exit$");
                continueOperation=false;
                break;
            
            case 8:
                System.out.println("$Help$");
                printOperations();
                break;
                
            default:
                 System.out.println("Invalid Choice!");
        }
        
        }while(continueOperation!=false);
    }
   
    /**
     *  prints all the operations
     *  to guide the user
     */
    public static void printOperations(){
        System.out.println("You can perform following operations on your Address book.\n"
                + "Please enter the number to perform the respective operation\n");
        System.out.println("1:Add contact");
        System.out.println("2:Search contact");
        System.out.println("3:Edit contact");
        System.out.println("4:Delete contact");
        System.out.println("5:Save address book");
        System.out.println("6:View all contacts");
        System.out.println("7:Exit Operations");
        System.out.println("8:Help\n");
    }
    
    /**
     * gets a contact name from user
     * for searching, deleting, editing etc.
     * @return
     */
    public static String getContactName(){
        
        System.out.println("Enter contact name:");
              return scanner.nextLine();
    }

    /**
     * Prints initial operations 
     */
    private static void printMainMenu() {
        System.out.println("\nPlease select from the following options:\n");
        System.out.println("1:Create new Address book");
        System.out.println("2:Load Existing Address book");
        System.out.println("3:Quit Application");
        System.out.println("8:Help\n");
    }
   
}
