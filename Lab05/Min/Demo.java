import javax.swing.*;

public class Demo {

    public static void main (String [] args) {

	int i1, i2, i3;
	int min = 0;
     
	i1 = Integer.parseInt(
	     JOptionPane.showInputDialog(null,"Enter the first integer"));
	i2 = Integer.parseInt(
	     JOptionPane.showInputDialog(null,"Enter the second integer"));
	i3 = Integer.parseInt(
	     JOptionPane.showInputDialog(null,"Enter the third integer"));
	
	// implement the rest of the algorithm here
	// using a single if-else with possibly nested ifs
	// and no && or ||.

	JOptionPane.showMessageDialog(null,"The smallest integer is " + min);
     }
}
