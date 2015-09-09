
import java.util.TreeMap;
import person.Person;
import personal.address.book.AddressBookOperation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("addContact");
        TreeMap<String, Person> addressBook = null;
        AddressBookOperation.addContact(addressBook);
        AddressBookOperation.printAddressBook(addressBook);
    }
}
