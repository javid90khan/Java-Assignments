/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.address.book;

import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import person.Person;

/**
 *
 * @author 
 */
public class AddressBookOperationTest {
    
    public AddressBookOperationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addContact method, of class AddressBookOperation.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        TreeMap<String, Person> addressBook = null;
        AddressBookOperation.addContact(addressBook);
        AddressBookOperation.printAddressBook(addressBook);
    }

    /**
     * Test of editContact method, of class AddressBookOperation.
     */
    @Test
    public void testEditContact() {
        System.out.println("editContact");
        TreeMap<String, Person> addressBook = null;
        String name = "";
        AddressBookOperation.editContact(addressBook, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeContact method, of class AddressBookOperation.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        TreeMap<String, Person> addressBook = null;
        String name = "";
        boolean expResult = false;
        boolean result = AddressBookOperation.removeContact(addressBook, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchContact method, of class AddressBookOperation.
     */
    @Test
    public void testSearchContact() {
        System.out.println("searchContact");
        TreeMap<String, Person> addressBook = null;
        String name = "";
        Person expResult = null;
        Person result = AddressBookOperation.searchContact(addressBook, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printContact method, of class AddressBookOperation.
     */
    @Test
    public void testPrintContact() {
        System.out.println("printContact");
        Person person = null;
        AddressBookOperation.printContact(person);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printAddressBook method, of class AddressBookOperation.
     */
    @Test
    public void testPrintAddressBook() {
        System.out.println("printAddressBook");
        TreeMap<String, Person> addressBook = null;
        AddressBookOperation.printAddressBook(addressBook);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAddressBook method, of class AddressBookOperation.
     */
    @Test
    public void testCreateAddressBook() {
        System.out.println("createAddressBook");
        TreeMap<String, Person> expResult = null;
        TreeMap<String, Person> result = AddressBookOperation.createAddressBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewAddressBook method, of class AddressBookOperation.
     */
    @Test
    public void testSaveNewAddressBook() {
        System.out.println("saveNewAddressBook");
        TreeMap<String, Person> addressBook = null;
        AddressBookOperation.saveNewAddressBook(addressBook);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAddressBook method, of class AddressBookOperation.
     */
    @Test
    public void testSaveAddressBook() {
        System.out.println("saveAddressBook");
        TreeMap<String, Person> addressBook = null;
        String absoluteFilePath = "";
        AddressBookOperation.saveAddressBook(addressBook, absoluteFilePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadAddressBook method, of class AddressBookOperation.
     */
    @Test
    public void testLoadAddressBook() {
        System.out.println("loadAddressBook");
        String absoluteFilePath = "";
        TreeMap<String, Person> expResult = null;
        TreeMap<String, Person> result = AddressBookOperation.loadAddressBook(absoluteFilePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
