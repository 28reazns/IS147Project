package main;

import basic.Category;

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

    /*
    * addValue() method
    * Adds a value to an array, pretty simple.
    *
    * Example Use 1:
    * addValue(Category[]{...},1,1)
    * */
    public static Category[] addValue(Category[] array,int size,Category val){
        // Create new array of size+1
        Category[] newArray = new Category[size+1];
        // insert the previous elements of the array into the new array
        for(int i=0;i<size;i++){
            newArray[i] = array[i];
        }
        // set arrays last value to val.
        newArray[size] = val;
        // return new array
        return  newArray;
    }

    // Main Method Based on previous version
    public static void main(String[] args){
        // Declare Variables
        Scanner input = new Scanner(System.in);
        boolean running = true;
        Category[] categories = {new Category("Gas"), new Category("Food")};
        int day;
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
                    // Total Spent Today
                    double totalToday = 0;
                    // Preset Gas and Food
                    Category gas = categories[0];
                    Category food = categories[1];

                    // For loop to create categories
                    while (true){
                        System.out.println("What would you like to name this category? (TYPE 0 to end.)");
                        String response = input.next();
                        if(response.trim().equals("0")){
                           break;
                        }else{
                            Category newCat = new Category(response);
                            categories = addValue(categories,categories.length,newCat);
                        }
                    }
                    // Go through all categories and ask the user how much they spent on it.
                    for(int i=0; i<categories.length;i++){
                        System.out.println("Enter how much you've spent on "+categories[i].getName()+". Type 0 if none.");
                        // Will set the total for said category to however much is spent.
                        double spent = getInputWithinBounds(input,0.0,Double.MAX_VALUE);
                        categories[i].setTotal(spent);
                        totalToday+=spent;
                    }
                    // Check if total spent today is highest
                    if(totalToday>highestTotal){
                        highestTotal = totalToday;
                        highestDay = getDay(day);
                    }

                    // Set total for today in the array.
                    totals[day-1] = totalToday;

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
        // See which category the user has spent the most on
        double highestSpentCategory = 0;
        Category highestCategory = new Category("None");

        for(int i=0; i<categories.length;i++){
            if(categories[i].getTotal()>highestSpentCategory){
                highestCategory = categories[i];
            }
        }
        // Print
        System.out.println(highestCategory.getName()+" is the highest category, at: $"+highestCategory.getTotal());


    }
}
