package main;

import java.util.Scanner;

/**
 * Name: CodingBat
 * Email(s): LQ79896@umbc.edu , vliv1@umbc.edu , ZT74217@umbc.edu
 * Description: Displays how much a user spends on 2 categories: (food and gas)
 *              depending on user input. The user can pick a day, and will be
                prompted to input the money spent on gas, and food.
                Afterward, it will output the total spent, highest category
                and how much is spent per day.
 */
public class TrackingEnhanced {
    /*
      The user would need to do inputs of how much they have spent per day in 3 different categories, food, gas, and extra.
      The chosen categories are just for now and would be making changes soon.
      */
    public static String getDay(int val){
        /*
        Returns a String depending on the integer, val, passed.
        If val is any value outside [1,7], default to Monday.
        * */
        String Day = "Monday";
        switch (val) {
            case 0:
                break;
            case 1:
                Day = "Monday";
                break;
            case 2:
                Day = "Tuesday";
                break;
            case 3:
                Day = "Wednesday";
                break;
            case 4:
                Day = "Thursday";
                break;
            case 5:
                Day = "Friday";
                break;
            case 6:
                Day = "Saturday";
                break;
            case 7:
                Day = "Sunday";
        }
        return Day;
    }

    /*
    getDayInput Method
    Handles Input and Printing when selecting the day you'd like to track spending on.
    If a value outside of bounds [0,7] is passed, a recursive method, getInputWithinBounds() is called.
    It will run until a value within bounds is input.

    Example Use 1: getDayInput(Scanner);
    "Enter the day..."
    2
    "You have chosen: Tuesday

    Example Use 2: getDayInput(Scanner);
    "Enter the day..."
    -3
    "Unsupported value passed, Try again. (Input must be within bounds [0,7])
    * */
    public static int getDayInput(Scanner input){
        System.out.println("Enter the day you'd like to track this week's spending on. (1=Monday,7=Sunday. Type 0 to EXIT.) ");
        int day = getInputWithinBounds(input,0,7);
        if(day>0){
            System.out.println("You have chosen: "+getDay(day)); // Ex: You have chosen: Saturday
            System.out.println("-".repeat(10));
        }
        return day;
    }

    /*
    getInputWithinBounds Method
    Because this project uses a lot of integers and doubles, this method is needed.
    It will make sure the integer passed is within bounds [min,max], and will ask the user
    to try again if not.

    Example Use 1: getInputWithinBounds(input,1,7)
    if 2 is inputted, 2 is returned.

    Example Use 2: getInputWithinBounds(input,1,7)
    if 0 is inputted,
    "Unsupported value passed, Try again. (Input must be within bounds [1,7]"
    * */
    public static int getInputWithinBounds(Scanner input,int min, int max){

        int val = input.nextInt();
        if (val >= min && val <= max){
            return val;
        }else{
            System.out.println("Unsupported value passed, Try again. (Input must be within bounds ["+min+","+max+"]");
            return getInputWithinBounds(input,min,max);
        }
    }
    // Version using double values.
    public static double getInputWithinBounds(Scanner input, double min, double max){
        double val = input.nextDouble();
        if (val >= min && val <= max){
            return val;
        }else{
            System.out.println("Unsupported value passed, Try again. (Input must be within bounds ["+min+","+max+"]");
            return getInputWithinBounds(input,min,max);
        }
    }

    // Main Method Based on previous version
    public static void main(String[] args){
        // Declare Variables
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int day;
        double totalGas = 0; // Total spent on Gas
        double totalFood = 0; // Total spent on Food
        String highestDay = ""; // Day in which most money was spent.
        double highestTotal = 0; // Highest Amount spent
        double[] totals = {0,0,0,0,0,0,0}; // Array with totals. 0 being monday, 6 being sunday.

        // While Loop for continuous use.
        while (running){
            // Use GetInput Method
            day = getDayInput(input);
            // Switch Statements
            switch (day){
                default: // If 0 is passed, then Exit Program
                    // Note: This won't fire for values other than 0 due to the getInputWithinBounds() method.
                    System.out.println("Ending Program");
                    running = false;
                    break;
                case 1,2,3,4,5,6,7: // If day is in [1,7] go as intended

                    // Temporary values
                    double gas;
                    double food;


                    // Start with gas.
                    System.out.println("Enter how much you have spent in gas. Type 0 if none.");
                    double maxNumber = Double.MAX_VALUE;
                    gas = getInputWithinBounds(input,0.0,maxNumber);

                    // Now do food.
                    System.out.println("Enter how much you have spent in food. Type 0 if none.");
                    food = getInputWithinBounds(input,0.0,maxNumber);

                    // Add gas and food to the total
                    totalGas+=gas;
                    totalFood+=food;

                    // Check if gas and food combined is larger than the current highest total spent.
                    if((food+gas)>highestTotal){
                        // Set Highest Total to food and gas combined
                        highestTotal = food+gas;
                        highestDay = getDay(day); // Set highest day to the current day.
                    }

                    // Set total for today in the array.
                    totals[day-1] = (food+gas); // totals[0] is monday (0=1-1)

                    // Print Separator
                    System.out.println("-".repeat(20));
                    break;
            }

        }
        // Print Separator
        System.out.println("-".repeat(20));
        // Output after calculations

        // Go through the totals table and print out how much was spent that day.
        for(int i=0;i<totals.length;i++){
            System.out.println("The total that was spent on "+getDay(i+1)+" was $"+totals[i]);
        }
        System.out.println(" ");
        // Get and Print the day the user spent the most, and how much was spent.
        System.out.println("On "+highestDay+", you spent the most. ($"+highestTotal+")");
        System.out.println(" ");
        // See which category the user has spent the most on, food or gas.
        if(totalGas > totalFood){ // If gas is highest
            System.out.println("Gas is the highest category, at: $"+totalGas);
        }else if(totalGas < totalFood){ // If food is highest
            System.out.println("Food is the highest category, at: $"+totalFood);
        }else{ // if neither are highest (equal)
            System.out.println("Gas and Food are equal, at: $"+totalGas);
        }
    }
}