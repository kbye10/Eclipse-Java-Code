/* Converts seconds into minutes, hours, days */

import javax.swing.*;

public class SecondsConvert {

    public static void main (String [] args) {

        String secondsStr;
        int seconds1,seconds2, minutes1,minutes2, hours;
	    
        System.out.println( "This program converts a total number of seconds ");
	System.out.println( "into the equivalent minutes and seconds. ");

	secondsStr = JOptionPane.showInputDialog(null, "Enter the seconds: ");
	seconds1 = Integer.parseInt(secondsStr);
	minutes1 = seconds1 / 60;
	minutes2 = minutes1 % 60;
	seconds2 = seconds1 % 60;
	hours = minutes1 / 60;
	
	    
	System.out.println();
	System.out.println(seconds1 + " seconds = " );
	System.out.println( hours +" hours, and "+ minutes2 + " minutes, and " + 
	                    seconds2 + " seconds. ");
    }
}
