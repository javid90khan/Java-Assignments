/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hammurabi;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Hammurabi { 
    
    
    private String OGH = "O Great Hammurabi";
    
    private Random rand = new Random();
    private Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new Hammurabi().playGame();
    }
    
 void playGame() {
     
     
     int year=0;
     int population=0;
     int grain=0;
     int acres=0;
     int landValue=0;

    
     int starved=0;
     int percentStarved=0;
     int plagueVictims=0;
     int immigrants=0;
     int grainHarvested=0;
     int harvestPerAcre=0;
     int amountEatenByRats=0;

     int grainFedToPeople=0;
     int acresPlanted=0;
    
     boolean playAgain = true;
        //print game intoduction        
            printIntroductoryParagraph();
        while (playAgain) {
            year=1;
            //run
            boolean stillInOffice = true;

        //initialize variables 
            population=100;
            grain=2800;
            acres=1000;
            landValue=19;
        //reset variables
            
            starved=0;
            percentStarved=0;
            plagueVictims=0;
            immigrants=5;
            grainHarvested=3000;
            harvestPerAcre=3;
            amountEatenByRats=200;

            grainFedToPeople=0;
            acresPlanted=1000; 
            
          
        while (year <= 10 && stillInOffice) {
            printSummary(plagueVictims, immigrants, starved, year, population, grainHarvested, harvestPerAcre, amountEatenByRats, grain, landValue, acres);
            
            
            //buy land 
            int acresToBuy=askHowManyAcresToBuy(landValue, grain);
           
            int cost = landValue * acresToBuy;

            grain = grain - cost;
            acres = acres + acresToBuy;
            System.out.println(OGH + ", you now have " + acres
                    + " acres of land");
            System.out.println("and " + grain + " bushels of grain.");
            //buy land ends
            
            
             if(acresToBuy==0){
            // sell land 
            int acresToSell = askHowManyAcresToSell(acres);
        
            grain = grain + landValue * acresToSell;
            acres = acres - acresToSell;
            System.out.println(OGH + ", you now have " + acres
                    + " acres of land");
            System.out.println("and " + grain + " bushels of grain.");
            //sell land ends
             }
             
            //feed people 
             grainFedToPeople = askHowMuchGrainToFeedPeople(grain);
        
            grain = grain - grainFedToPeople;
            System.out.println(OGH + ", " + grain
                    + " bushels of grain remain.");
            
            //feed people end
            
            
            //plant grain 
            acresPlanted = askHowManyAcresToPlant(acres, population, grain);
            int amountPlanted=acresPlanted*2;

            grain = grain - amountPlanted;
            System.out.println(OGH + ", we now have " + grain
                    + " bushels of grain in storage.");
            //plant grain end

            
            
            //check for plague 
            plagueVictims=plagueDeaths(population);
            population = population - plagueVictims;
            //check for plague ends
            
            //count starved people
             starved=starvationDeaths(population, grainFedToPeople);
             percentStarved = (100 * starved) / population;
            population=population-starved;
            if (percentStarved >= 45) {
                stillInOffice = false;
            }
             //count starved people ends
            
            //count immigrants 
             immigrants=immigrants(population, acresPlanted, grainFedToPeople);
             population+=immigrants;
                     ////count immigrants ends
            
            //harvest start 
             grainHarvested=harvest(acresPlanted);
             if(grainHarvested!=0)
             harvestPerAcre=grainHarvested/acresPlanted;
             grain+=grainHarvested;
             
            //harvest ends
            
            
            //check For Rats;
             amountEatenByRats=grainEatenByRats(grain);
                grain-=amountEatenByRats;
            
            
            //update Land Value;
            landValue=newCostOfLand();
            year = year + 1;
        }
        finalSummary(population, acres, starved);
            
            
            //run end
            playAgain = getYesOrNo("Would you like to play again?");
        }
        System.out.println("Goodbye!");
 }

 
 
    /**
     * Prints the introductory paragraph.
     */
    private void printIntroductoryParagraph() {
        System.out.println(
                "Congratulations! You are the newest ruler of ancient Samaria,\n"
                + "elected for a ten year term of office. Your duties are to\n"
                + "dispense food, direct farming, and buy and sell land as\n"
                + "needed to support your people. Watch out for rat infestations\n"
                + "and the plague! Grain is the general currency, measured in\n"
                + "bushels. The following will help you in your decisions:\n"
                + "\n"
                + "   * Each person needs at least 20 bushels of grain per year to survive\n"
                + "   * Each person can farm at most 10 acres of land\n"
                + "   * It takes 2 bushels of grain to farm an acre of land\n"
                + "   * The market price for land fluctuates yearly\n"
                + "\n"
                + "Rule wisely and you will be showered with appreciation at the\n"
                + "end of your term. Rule poorly and you will be kicked out of office!\n");
    }
    
     /**
     * Returns a boolean response to a yes-no question. (At this point my
     * students only know about reading in integers, but I couldn't bring myself
     * to do the ugly "1 = yes" kind of thing.)
     * 
     * @param string
     *            The question to be asked.
     * @return The answer to the question.
     */
    private boolean getYesOrNo(String question) {
        String answer;
        while (true) {
            System.out.print(question + "  ");
            answer = scanner.next();
            if (answer.toLowerCase().charAt(0) == 'y')
                return true;
            if (answer.toLowerCase().charAt(0) == 'n')
                return false;
        }
    }
    
    /**
     * Tells user that the request cannot be fulfilled.
     * 
     * @param message The reason the request cannot be fulfilled.
     */
    private void jest(String message) {
        System.out.println(OGH + ", surely you jest!");
        System.out.println(message);
    }
      
    int askHowManyAcresToBuy(int price, int bushels){
        String question = "How many acres of land will you buy? ";

        int acresToBuy = getNumber(question);
        int cost = price * acresToBuy;
        while (cost > bushels) {
            jest("But We have " + bushels + " bushels of grain, not "
                    + cost + "!");
            acresToBuy = getNumber(question);
            cost = price * acresToBuy;
        }
        return acresToBuy;
    }

    int askHowManyAcresToSell(int acresOwned){
        String question = "How many acres of land will you sell? ";
        int acresToSell = getNumber(question);

        while (acresToSell > acresOwned) {
            jest("But We have " + acresOwned + " acres!");
            acresToSell = getNumber(question);
        }
        return acresToSell;
    }
    
    int askHowMuchGrainToFeedPeople(int bushels){
        String question = "How much grain will you feed to the people? ";
        int grainFedToPeople = getNumber(question);

        while (grainFedToPeople > bushels) {
            jest("But We have " + bushels + " bushels!");
            grainFedToPeople = getNumber(question);
        }
        return grainFedToPeople;
    }
    
    int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        String question = "How many acres will you plant? ";
        int acresToPlant = 0;
        boolean haveGoodAnswer = false;

        while (!haveGoodAnswer) {
            acresToPlant = getNumber(question);
            if (acresToPlant*2 > bushels) {
                jest("But We have " + bushels + " bushels left!");
            } else if (acresToPlant > acresOwned) {
                jest("But We have " + acresOwned + " acres available for planting!");
            } else if (acresToPlant/10 > population) {
                jest("But We have " + population
                        + " people to do the planting!");
            } else {
                haveGoodAnswer = true;
            }
        }
        return acresToPlant;
    }

    
    int plagueDeaths(int population){
        int plagueVictims;
        if (rand.nextDouble() < 0.15) {
            System.out.println("*** A horrible plague kills half your people! ***");
            plagueVictims = population / 2;
        } else {
            plagueVictims = 0;
        }
        return plagueVictims;
    }
    
    int starvationDeaths(int population, int bushelsFedToPeople){
        int peopleFed = bushelsFedToPeople / 20;
        int starved;
        if (peopleFed >= population) {
            starved = 0;
            
            System.out.println("Your people are well fed and happy.");
        } else {
            starved = population - peopleFed;
            System.out.println(starved + " people starved to death.");
            
        }
        
        return starved;
    }
    
    
    boolean uprising(int population, int howManyPeopleStarved){
        if (howManyPeopleStarved >= (45 * population) / 100) 
            return true;
        else
            return false;
    }
    
    int immigrants(int population, int acresOwned, int grainInStorage){
        int immigrants=0;
            if(population!=0){
            immigrants = (20 * acresOwned + grainInStorage) / (100 * population) + 1;
            }
            population += immigrants;
       
        return immigrants;
    }
    
    int harvest(int acres){
        int harvestPerAcre = rand.nextInt(5) + 1;
        int grainHarvested = harvestPerAcre * acres;
        
        return grainHarvested;
        
    }
    
        int grainEatenByRats(int bushels){
        int amountEatenByRats=0;
        if (rand.nextInt(100) < 40) {
            int percentEatenByRats = 10 + rand.nextInt(21);
            System.out.println("*** Rats eat " + percentEatenByRats
                    + " percent of your grain! ***");
            amountEatenByRats = (percentEatenByRats * bushels) / 100;
        } else {
            amountEatenByRats = 0;
        }
        return amountEatenByRats;
    }
    
    int newCostOfLand(){
        return 17 + rand.nextInt(7);
    }

      /**
     * Prints the given message (which should ask the user for some integral
     * quantity), and returns the number entered by the user. If the user's
     * response isn't an integer, the question is repeated until the user does
     * give a integer response.
     * 
     * @param message
     *            The request to present to the user.
     * @return The user's numeric response.
     */
    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }
    
    
    /**
     * Prints the year-end summary.
     */
    private void printSummary(int plagueVictims,int immigrants, int starved, int year,
            int population,int grainHarvested,int harvestPerAcre,int amountEatenByRats,
            int grain,int landValue,int acres) {
        
        System.out
                .println("___________________________________________________________________");
        System.out.println("\n" + OGH + "!");
        System.out.println("You are in year " + year + " of your ten year rule.");
        if (plagueVictims > 0) {
            System.out.println("A horrible plague killed " + plagueVictims
                    + " people.");
        }
        System.out.println("In the previous year " + starved
                + " people starved to death.");
        System.out.println("In the previous year " + immigrants
                + " people entered the kingdom.");
        System.out.println("The population is now " + population);
        System.out.println("We harvested " + grainHarvested + " bushels at "
                + harvestPerAcre + " bushels per acre.");
        if (amountEatenByRats > 0) {
            System.out.println("*** Rats destroyed " + amountEatenByRats
                    + " bushels, leaving " + grain + " bushels in storage.");
        } else {
            System.out.println("We have " + grain + " bushels of grain in storage.");
        }
        System.out.println("The city owns " + acres + " acres of land.");
        System.out.println("Land is currently worth " + landValue
                + " bushels per acre.");
        System.out.println();
    }
    
    private void finalSummary(int population,int acres,int starved){
        if (starved >= (45 * population) / 100) {
            System.out
                    .println("O Once-Great Hammurabi,\n"
                            + starved
                            + " of your people starved during the last year of your\n"
                            + "incompetent reign! The few who remain have stormed the palace\n"
                            + "and bodily evicted you!\n"
                            + "\nYour final rating: TERRIBLE.");
            return;
        }
        int plantableAcres = acres;
        if (20 * population < plantableAcres) {
            plantableAcres = 20 * population;
        }

        if (plantableAcres < 600) {
            System.out
                    .println("Congratulations, "
                            + OGH
                            + " You have ruled wisely but not\n"
                            + "well; you have led your people through ten difficult years, but\n"
                            + "your kingdom has shrunk to a mere " + acres
                            + " acres.\n" + "\nYour final rating: ADEQUATE.");
        } else if (plantableAcres < 800) {
            System.out
                    .println("Congratulations, " + OGH + " You  have ruled wisely, and\n"
                            + "shown the ancient world that a stable economy is possible.\n"
                            + "\nYour final rating: GOOD.");
        } else {
            System.out
                    .println("Congratulations, " + OGH + " You  have ruled wisely and well, and\n"
                            + "expanded your holdings while keeping your people happy.\n"
                            + "Altogether, a most impressive job!\n"
                            + "\nYour final rating: SUPERB.");
        }
    }
}

