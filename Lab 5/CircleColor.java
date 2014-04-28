import java.awt.*;
import javax.swing.*;

public class CircleColor extends JFrame {

    Color color;

    public CircleColor() {
	super("Circle");
	setSize(300,200);
	setLocation(100,100);
	setVisible(true);
    }
 
    public void paint (Graphics g) {
	g.setColor(color);
	g.fillOval(50,50,50,50);
    }

    public void changeColor (Color c) {
	color = c;
        repaint();
    }


    public static void main (String [] args) {

	CircleColor cc;
	int colorNumber;

	cc = new CircleColor();
	colorNumber = Integer.parseInt(
	        JOptionPane.showInputDialog(null,
                    "What color?\n" +
		    "1 = red\n" +
                    "2 = green\n" +
                    "3 = yellow\n" +
		    "4 = blue\n"));

        // change the color based on the value of colorNumber
        switch (colorNumber)
        {
        case 1: cc.changeColor(Color.red);
        	break;
        case 2: cc.changeColor(Color.green);
        	break;
        case 3: cc.changeColor(Color.yellow);
        	break;
        case 4: cc.changeColor(Color.blue);
        	break;
        }

	JOptionPane.showMessageDialog(null, "Click OK to exit");
	System.exit(0);
    }
}
