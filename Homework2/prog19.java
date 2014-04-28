/* Kevin Bye
 	1/26/2012
 	Program displays two messages in 2 message boxes, one in each.
 	file name = prog19
 */

//Import statements
import javax.swing.*;

public class prog19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Define Strings
		String message1,message2;
		
		//Get messages
		message1 = "I Can Design";
		message2 = "And I Can Program";
		
		//Display Messages
		JOptionPane.showMessageDialog(null,message1);
		JOptionPane.showMessageDialog(null,message2);
		
	}

}
