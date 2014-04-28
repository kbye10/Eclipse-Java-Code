/* Converts seconds into minutes, hours, days */

import javax.swing.*;

public class SecondsConvert {

    public static void main (String [] args) {

        String secondsStr;
        int seconds, minutes, hours;
	    
        System.out.println( "This program converts a total number of seconds ");
	System.out.println( "into the equivalent minutes and seconds. ");

	secondsStr = JOptionPane.showInputDialog(null, "Enter the seconds: ");
	seconds = Integer.parseInt(secondsStr);
	minutes = seconds / 60;
	seconds = seconds % 60;
	    
	System.out.println();
	System.out.println(seconds + " seconds = " );
	System.out.println( minutes + " minutes, and " + 
	                    seconds + " seconds. ");
    }
}
