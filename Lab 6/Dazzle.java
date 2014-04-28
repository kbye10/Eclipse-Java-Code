import javax.swing.*;
import java.awt.*;

public class Dazzle extends JFrame {

    public Dazzle() {
        super("Dazzle");
        setSize(600,600);
        setVisible(true);
    }
 
    public void paint (Graphics graphics) {
	for (int i = 0 ; i <= 255 ; i++) {
	    int r, g, b;
	    r = 134;
	    g = 234;
	    b = 100;
	    
	    Color color = new Color(r,g,b);
	    graphics.setColor(color);
	    graphics.drawOval(300-i,300-i,2*i,2*i);
	}
    }

    public static void main (String [] args) {

	Dazzle demo = new Dazzle();

        
	JOptionPane.showMessageDialog(null, "Click OK to exit");
        System.exit(0);
    }
}
