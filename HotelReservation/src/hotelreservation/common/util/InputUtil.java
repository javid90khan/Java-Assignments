package hotelreservation.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Utility class for input processing
 * @author javidkhan
 */
public abstract class InputUtil {
    

    /**
     * reads a file with comma separated values
     * @param filePath Path of the file to read
     * @return Two Dimensional String array containing theCSV file data
     */
    public static String[][] readCSVFile(String filePath){
        
        String[][] data=null;
        try{
            URL fileURL=InputUtil.class.getResource(filePath);
            
            if(fileURL!=null){
                File file = new File(fileURL.getFile());
                List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            
                data=new String[lines.size()][];
                int i=0;  
                for (String line : lines) {
                    data[i++] = line.split(",");
                }
                
            }else{
                throw new FileNotFoundException("CSV File not found:please check the path");
            }
        }catch(Exception e){
            System.err.println("Error while reading file: "+e.getMessage());
            e.printStackTrace();
        }
        return data;
    }
    
    /**
     * converts string into Date object
     * @param dateString String containing the date value
     * @param format date format
     * @return
     */
    public static Date pareDate(String dateString,String format){
    
        try {
            DateFormat df = new SimpleDateFormat(format);
            Date result =  df.parse(dateString);
            return result; 
        } catch (ParseException pe) {
            System.err.println("Error while parsing Date "+pe.getMessage());
        }
        return null;
    }
    
    /**
     * throws IllegalArgumentException
     * @param inputPattern Regular expression to validate
     * @param input input String to match
     */
    public static void validateInput(String inputPattern,String input){
        try{
            if(!Pattern.matches(inputPattern,input)){
                throw new IllegalArgumentException("Invalid Input String");
            }
        }catch(IllegalArgumentException pse){
                throw new IllegalArgumentException("Invalid Input Pattern: "+pse.getMessage());
        }
    }
}
