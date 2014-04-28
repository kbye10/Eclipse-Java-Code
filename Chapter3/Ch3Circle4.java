/*
    Introduction to OOP with Java 4th, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Program: Compute Area and Circumference
                              with formatting using standard
                              input and output

    File: Ch2Circle4.java

*/

import java.util.*;
import java.text.*;

class Ch3Circle4 {

    public static void main( String[] args ) {

        final double PI = 3.14159;

        double radius, area, circumference;
        Scanner scanner;

        DecimalFormat df = new DecimalFormat("0.000");

        scanner = new Scanner(System.in);

        //Get input
        System.out.print("Enter radius: ");
        
        radius = scanner.nextDouble();

        //Compute area and circumference
        area          = PI * radius * radius;
        circumference = 2.0 * PI * radius;

        //Display the results
        System.out.println("");
        System.out.println("Given Radius: " + radius);
        System.out.println("Area: " + df.format(area));
        System.out.println("Circumference: " + df.format(circumference));
    }
}