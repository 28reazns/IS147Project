//Coding cave
//This is to spend your tracking

package bank;

import java.util.Scanner;
public class Tracking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Vars assignment
        int day;
        double gas;
        double food;
        double totalGas = 0, totalFood = 0;
        String HighestDay = " ";
        double totalDay, totalSunday = 0, totalMonday = 0,totalTuesday = 0, totalWednesday = 0, totalThursday = 0, totalFriday = 0, totalSaturday = 0, highTotalDay = 0;
        double highesCat = 0;
        String HighestCat = " ";
        String Monday = " ", Tuesday = " ", Wednesday = " ", Thursday = " ",Friday = " ", Saturday = " ", Sunday = " ";

        while(true) {//Looping for the day's

            System.out.println("7 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday");
            System.out.println("Please type in a 0 to end the code");
            System.out.print("Please type in a number to start on a day: ");

            day = input.nextInt();//Picking the day
            System.out.println("You have chosen : " + dayWeek(day));

            if (day == 0) {//For ending the program
                System.out.println("you have ended the program");
                break;
            }
            if (day > 7 || day < 0) {//For retrying
                System.out.println("Please try again");
            }
            if (day >= 1 && day <= 7) {//This is the beginning of all the inputs for the user to put in
                System.out.println("Please input how much you have spent in Gas and food. First input would be gas, add a space and the second input is for Food");
                System.out.println("If you didn't spend anything type in a 0. ");
                gas = input.nextDouble();
                food = input.nextDouble();
                totalDay = gas + food;
                totalGas += gas;
                totalFood += food;
                System.out.println("Total for gas for the week is: $" + totalGas);
                System.out.println(" ");
                System.out.println("Total for food for the week is: $" + totalFood);
                System.out.println(" ");
                System.out.println(" You have spent: " + totalDay + " On " + dayWeek(day));
                System.out.println(" ");

                if (dayWeek(day).equalsIgnoreCase("Sunday")) {//Assigning the total to Sunday
                    Sunday = dayWeek(day);
                    totalDay += totalSunday;
                    totalSunday = totalDay;
                }
                if (dayWeek(day).equalsIgnoreCase("Monday")) {//Assigning the total to Monday
                    Monday = dayWeek(day);
                    totalDay += totalMonday;
                    totalMonday = totalDay;
                }
                if (dayWeek(day).equalsIgnoreCase("Tuesday")) {//Assigning the total to Tuesday
                    Tuesday = dayWeek(day);
                    totalDay += totalTuesday;
                    totalTuesday = totalDay;
                }
                if (dayWeek(day).equalsIgnoreCase("Wednesday")) {//Assigning the total to Wednesday
                    Wednesday = dayWeek(day);
                    totalDay += totalWednesday;
                    totalWednesday = totalDay;
                }
                if (dayWeek(day).equalsIgnoreCase("Thursday")) {//Assigning the total to Thursday
                    Thursday = dayWeek(day);
                    totalDay += totalThursday;
                    totalThursday = totalDay;
                }
                if (dayWeek(day).equalsIgnoreCase("Friday")) {//Assigning the total to Friday
                    Friday  = dayWeek(day);
                    totalDay += totalFriday;
                    totalFriday = totalDay;
                }
                if (dayWeek(day).equalsIgnoreCase("Saturday")) {//Assigning the total to Saturday
                    Saturday = dayWeek(day);
                    totalDay += totalSaturday;
                    totalSaturday = totalDay;
                }
                if (totalDay > highTotalDay) {//This is for comparing the day's to see which day you have spent the most
                    HighestDay = dayWeek(day);
                    highTotalDay = totalDay;
                }
            }
        }

        System.out.println("The total that was spent on " + Sunday + " was " + totalSunday);
        System.out.println("the total that was spent on " + Monday + " was " + totalMonday);
        System.out.println("The total that was spent on " + Tuesday + " was " + totalTuesday);
        System.out.println("The total that was spent on " + Wednesday + " was " + totalWednesday);
        System.out.println("the total that was spent on " + Thursday + " was " + totalThursday);
        System.out.println("the total that was spent on " + Friday + " was " + totalFriday);
        System.out.println("The total that was spent on " + Saturday + " was " + totalSaturday);
        System.out.println(" ");
        System.out.println("The day you have spent the most is " + HighestDay + " Spending $" + highTotalDay);

        if(totalGas > totalFood){//This is for comparing the 2 categories
            System.out.println(" ");
            System.out.println("Gas is the highest category at: $" + totalGas);
        }else{
            System.out.println(" ");
            System.out.println("Food is the highest category at: $" + totalFood);
        }
    }

    public static String dayWeek(int day) {//This is for the day output.
        String Day = " ";
        switch (day) {
            case 0:
                Day = "No day's chosen";
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

    //public static double high(int a){

    //}

}