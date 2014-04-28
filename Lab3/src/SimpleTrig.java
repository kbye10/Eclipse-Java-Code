/* Some simple Trigonometry */

import javax.swing.*;
import java.text.*;

public class SimpleTrig {
    public static void main (String [] args) {
        
        String angleStr;
        double angleDeg, angleRad, angleCosine;
        DecimalFormat df = new DecimalFormat("0.000");

        angleStr = JOptionPane.showInputDialog(null,
                                               "Enter an angle (in degrees)");
        angleDeg = Double.parseDouble(angleStr);
        angleRad = Math.toRadians(angleDeg);
        angleCosine = Math.cos(angleRad);

        JOptionPane.showMessageDialog(null, 
                                      "The cosine of " + angleDeg + 
                                      " degrees  is " + df.format(angleCosine));

    }
}
