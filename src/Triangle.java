/*
 * The Triangle class determines whether a triangle can be formed from three given integers,
 * and what kind of triangle they can represent.
 *
 * @version 1
 */

import java.util.Scanner;

public class Triangle { // start of Train class.
    public static void main(String[] args) { //start of main method
        //Input 3 integers
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 3 Integers ");

        System.out.println("Please enter the value of x:");
        int x = scanner.nextInt();// Collecting the data from the user.

        System.out.println("Please enter the value of y:");
        int y = scanner.nextInt();// Collecting the data from the user.

        System.out.println("Please enter the value of z:");
        int z = scanner.nextInt();// Collecting the data from the user.

        //Logic
        int biggestLength = Math.max(x, Math.max(y, z)); //Finding the biggest length.
        int smallestLength = Math.min(x, Math.min(y, z)); //Finding the smallest length.
        int middleLength = x + y + z - biggestLength - smallestLength; //Finding the middle length.
        if (smallestLength + middleLength > biggestLength
                && smallestLength + biggestLength > middleLength
                && middleLength + biggestLength > smallestLength) { //Checking if the triangle can be formed.

            if (smallestLength == middleLength && middleLength == biggestLength) //Checking if the triangle is equilateral.
            {
                //output
                System.out.println("The numbers: " + x + ", " + y + " and " + z + " represent an equilateral triangle.");
            }
            else if (smallestLength == middleLength || middleLength == biggestLength || smallestLength == biggestLength) //Checking if the triangle is isosceles.
            {
                //output
                System.out.println("The numbers: " + x + ", " + y + " and " + z + " represent an isosceles triangle.");
            }
            else if (smallestLength * smallestLength + middleLength * middleLength == biggestLength * biggestLength) //Checking if the triangle is right-angle.
            {
                System.out.println("The numbers: " + x + ", " + y + " and " + z + " represent a right-angle triangle.");
            }
            else // Since the triangle is not equilateral, isosceles or right-angle, it is a common triangle.
            {
                //output
                System.out.println("The numbers: " + x + ", " + y + " and " + z + " represent a common triangle.");

            }
        } else { // If the main 'if' statement which checks whether a triangle can be formed fails, the triangle cannot be formed.
            System.out.println("The numbers: " + x + ", " + y + " and " + z + " cannot represent a triangle.");
        }
    }//end of main method
}//end of Train class
