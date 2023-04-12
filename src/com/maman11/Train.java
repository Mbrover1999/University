package com.maman11;
/*
 * The Train class calculates the
 * distance between two trains after they ended their travels.
 *
 * @version 1
 */

import java.util.Scanner; //Importing Scanner.

public class Train {// start of Train class.

    public static void main(String[] args) {//start of main method
        Scanner scan = new Scanner(System.in); // Creating a new instance of Scanner.
        //Input
        System.out.println("Please enter 4 integers ");

        System.out.println("Please enter the speed of train 1: ");
        int v1 = scan.nextInt();// Collecting the data from the user.

        System.out.println("Please enter the time of train 1: ");
        int t1 = scan.nextInt();// Collecting the data from the user.

        System.out.println("Please enter the speed of train 2: ");
        int v2 = scan.nextInt();// Collecting the data from the user.

        System.out.println("Please enter the time of train 2: ");
        int t2 = scan.nextInt();// Collecting the data from the user.

        //Calculate
        double trainDistance1 = v1 * (double) t1/60; // Calculating the overall distance that train1 traveled,
        // casting the minutes to hours and casting to double
        double trainDistance2 = v2 * (double) t2/60; // Calculating the overall distance that train2 traveled,
        // casting the minutes to hours and casting to double


        double distance = Math.abs((trainDistance1 - trainDistance2)); //Calculating the absolute distance value
        // Between train 1 and 2

        //Output
        System.out.println("The distance between the trains is " + distance + " km.");/*Printing the result to the user
        attention! - the result is of type double!
        since the assignment emphasised that the output can contain fractional numbers!*/

    }//end of main method
}//end of Train class
