import javax.swing.*;

public class Demo {

    public static void main (String [] args) {

        int n;

        n = Integer.parseInt(
	         JOptionPane.showInputDialog(null, "Enter an integer:"));

        if (n < 0)
            System.out.println("Adjusting the input to be nonnegative.");
            n = -n;

        JOptionPane.showMessageDialog(null,"Adjusted input value: " + n);
     }
}
