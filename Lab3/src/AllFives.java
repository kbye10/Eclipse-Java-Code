
/* Program to calculate the value of:   5
 *                                     a  + 5
 *                                    ________
 *                                       5a
 */

import javax.swing.*;
import java.util.*;

public class AllFives {
	public static void main (String [] args)
	{ 
	double a,power,answer;
    String input;
      
    
    input = JOptionPane.showInputDialog(null,"Enter a value");
    Scanner scanner = new Scanner(input);
    a = scanner.nextDouble();
    power = Math.pow(a,5);
    answer = ((power+5)/(5*a));
    JOptionPane.showMessageDialog(null,"The calculated value is "+answer);
    // finish this program
    }
}
