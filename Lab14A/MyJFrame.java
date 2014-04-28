
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class MyJFrame extends JFrame implements ActionListener{

    // private instance variables
    JButton button;
    int buttonCount;
    JTextField inputLine;
    JLabel prompt;
    JMenu menu;
    JMenuItem clearItem, exitItem;
    
    public static void main (String [] args) {
         
	MyJFrame mine = new MyJFrame();
        mine.setVisible(true);

    }

    public MyJFrame () {

        setTitle ("This is a \"MyJFrame\" object (V5)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning
        
        prompt = new JLabel( );
        prompt.setText("Enter a number to update the button");
        prompt.setSize(250, 25);
        prompt.setLocation(30, 50);
        contentPane.add(prompt);
        
        
        createMenu();
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menu);
        
        
        
        
        // construct a button, and set the number of click on it to 0
        button = new JButton("0");
        button.setBounds(110,230,80,40);
	button.addActionListener(this);
        contentPane.add(button);
        buttonCount = 0;

        // construct a text field
        inputLine = new JTextField();
        inputLine.setBounds(100,100,100,20);
        inputLine.addActionListener(this);
        contentPane.add(inputLine);
    }
    
    private void createMenu( ) {
        JMenuItem    item;

        menu = new JMenu("File");

        item = new JMenuItem("Clear");        //clear
        item.addActionListener( this );
        menu.add( item );

        item = new JMenuItem("Exit");    //exit
        item.addActionListener( this );
        menu.add( item );

        
    }
 
    public void actionPerformed(ActionEvent event) {
	
    	String menuName = event.getActionCommand();
    	
    if (event.getSource() instanceof JButton){
    buttonCount++;
	button.setText(Integer.toString(buttonCount));
	}
	if (event.getSource() instanceof JTextField)  {  
		buttonCount = Integer.parseInt(inputLine.getText()); 
		button.setText(Integer.toString(buttonCount));
		inputLine.setText("");
    }
    if (menuName.equals("Clear")){
		buttonCount = 0;
		button.setText(Integer.toString(buttonCount));
	}
    if (menuName.equals("Exit")){
		System.exit(0);
	}

 

}
}