/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 3 Sample Program: Estimate the Pole Height

    File: Ch3PoleHeight.java

*/

import java.text.*;
import java.util.*;



class Ch3PoleHeight {

    public static void main( String[] args ) {

        double height;          //height of the statue
        double distance;        //distance between points A and B
        double alpha;           //angle measured at point A
        double beta;            //angle measured at point B
        double alphaRad;        //angle alpha in radians
        double betaRad;         //angle beta in radians

        String inputStr;
        
        Scanner scan = new Scanner(System.in);

        //Get three input values
        System.out.print("Angle alpha (in degree):");
        alpha = scan.nextDouble();
       
        System.out.print("Angle beta (in degree):");
        beta  = scan.nextDouble();
        
        System.out.print("Distance between points A and B (ft):");
        distance     = scan.nextDouble();

        //compute the height of the tower
        alphaRad = Math.toRadians(alpha);
        betaRad  = Math.toRadians(beta);

        height = ( distance * Math.sin(alphaRad) * Math.sin(betaRad) )
                        /
                      Math.sqrt( Math.sin(alphaRad + betaRad) *
                                 Math.sin(alphaRad - betaRad) );

                                 
        DecimalFormat df = new DecimalFormat("0.000");

       
        System.out.println("Estimating the height of the pole"
                + "\n\n"
                + "Angle at point A (deg): "        + df.format(alpha)   + "\n"
                + "Angle at point B (deg): "        + df.format(beta)    + "\n"
                + "Distance between A and B (ft): " + df.format(distance)+ "\n"
                + "Estimated height (ft): "         + df.format(height));           

    }
}