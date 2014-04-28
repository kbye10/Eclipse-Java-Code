/* Some simple Trigonometry */

import javax.swing.*;

public class SimpleTrig {
    public static void main (String [] args) {
        
        String angleStr;
        double angle, angleCosine;

        angleStr = JOptionPane.showInputDialog(null,
                                               "Enter an angle (in degrees)");
        angle = Double.parseDouble(angleStr);
        angleCosine = Math.cos(angle);

        JOptionPane.showMessageDialog(null, 
                                      "The cosine of " + angle + 
                                      " degrees  is " + angleCosine);

    }
}
