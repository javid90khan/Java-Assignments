/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.address.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import person.Person;


/**
 *
 * @author 
 */
public class AddressBookPersist {
    static FileOutputStream fos=null;
    static ObjectOutputStream oos=null;
    static Scanner scanner=new Scanner(System.in);
   
    /**
     * Loads an address book from the specified absoluteFilePath 
     * @param absoluteFilePath
     * @return
     */
    public static TreeMap<String,Person> loadBook(String absoluteFilePath){
        
        File file=new File(absoluteFilePath);
        
        //check if the address book file exists 
        if(file.exists()){
        TreeMap<String,Person> addressBook;
        
        FileInputStream fis;
            try {
                fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                addressBook = (TreeMap<String, Person>) ois.readObject(); ois.close();
                return addressBook;
                
            } catch (FileNotFoundException ex) {
                
                return null;
            } catch (IOException ex) {
                
                return null;
            } catch (ClassNotFoundException ex) {
               
                return null;
            }
       
        }
        //address book file doesnt exist
        return null;
        
    }
    
    /**
     * Saves the address book to a specified absolute path
     * @param addressBook
     * @param absoluteFilePath
     * @return
     */
    public static boolean saveBook(TreeMap<String,Person> addressBook,String absoluteFilePath){
            
            File file=new File(absoluteFilePath);
            
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(addressBook); 
           
            return true;
            
        } catch (FileNotFoundException ex) {
            
            return false;
        } catch (IOException ex) {
            System.out.println("Error saving Address book! Please try again");
            return false;
        }
        finally{
                try {
                    oos.close();
                    fos.close();
                   
                } catch (IOException ex) {
                    
                }
            
        }
    }

    /**
     * Gets the file name from user for saving or loading the address book
     * @return
     */
    public static String getFileName(){
        System.out.println("Enter name of the Address book");
        return scanner.next();
    }
    
    /**
     * Launches jFileChooser to select a directory
     * @return
     */
    public static String getPath(){
        System.out.println("Select a directory");
            String selected=null;
            JFileChooser chooser = new JFileChooser();
            
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.setDialogTitle("Choose directory for your Address book");
            if( jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ){
                selected = jfc.getSelectedFile().getAbsolutePath();
            }
           
            return selected;
    }
}
