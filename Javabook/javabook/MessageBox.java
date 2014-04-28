package javabook;

import java.awt.*;
import java.awt.event.*;


/**
 * This dialog is for displaying a single line of text. This dialog is intended
 * for displaying a short warning or error message. The width of this dialog
 * is adjusted to fit the displayed message and the dialog is placed at the center 
 * of the screen.
 *
 *<p> 
 * This class is provided as freeware. You are free to use as provided or modify to
 * your heart's content. But you use it at your own risk. No implied or explicit 
 * warranty is given.
 * 
 * <p>
 * @author C. Thomas Wu a.k.a Dr. Caffeine
 */
public class MessageBox extends JavaBookDialog implements ActionListener, KeyListener
{


//----------------------------------
//    Data Members:
//----------------------------------

    /**
     * The fixed height of this dialog
     */
    private static final int DIALOG_HEIGHT = 130;
    
    /**
     * The fixed width of this dialog
     */
    private static final int DIALOG_WIDTH = 300;
    
    /**
     * The escape sequence for the ENTER, equivalently RETURN, key
     */
    private static final char ENTER_KEY = '\n';

    /**
     * The displayed message of this dialog
     */
    private Label  label;
    
    /**
     * The OK button
     */
    private Button okButton;
    
    /**
     * The font used for the message
     */
    private Font   font;


//-----------------------------------------
//
//    Constructors:
//
//-----------------------------------------

    /**
     * Default constructor. The title is fixed to "Sample Java Application".
     *
     * @param owner Frame object that owns this MessageBox
     */
    public MessageBox(Frame owner)
    {
        super(owner,true);
        initialize();
    }

    /**
     * Creates a MessageBox box with the designated owner and modality.
     *
     * @param owner Frame object that owns this MessageBox
     * @param modal true for modal and false for modeless MessageBox
     */
    public MessageBox(Frame owner, boolean modal)
    {
        super(owner, modal);
        initialize();
    }


//-----------------------------------------------
//    Public Methods:
//
//            void    actionPerformed( ActionEvent            ) Note: Do not call this method
//
//            void    keyTyped    ( KeyEvent                  ) Note: Do not call this method
//            void    keyPressed  ( KeyEvent                  ) Note: Do not call this method
//            void    keyReleased ( KeyEvent                  ) Note: Do not call this method
//
//            void    show        ( char                      )
//            void    show        ( long                      )
//            void    show        ( double                    )
//            void    show        ( String                    )
//            void    show        ( StringBuffer              )
//
//            void    show        ( char,   int, int          )
//            void    show        ( long,   int, int          )
//            void    show        ( double, int, int          )
//            void    show        ( String, int, int          )
//            void    show        ( StringBuffer, int, int    )
//
//-----------------------------------------------

    /**
     * Implements the required method of the ActionListener. Do not call this
     * method. The Java virtual machine handles the action event processing.
     * This method closes the dialog if the event is an OK button click 
     * event.
     *
     * @param e the ActionEvent object.
     *
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == okButton) {
            //close the dialog
            setVisible(false);
        }
    }

    /**
     * Implements the required method of the KeyListener. No response
     * for the key typed event in this dialog.
     *
     * @param e the KeyEvent object.
     *
     */
    public void keyTyped(KeyEvent e) 
    {
        
    }
    
    
    /**
     * Implements the required method of the KeyListener. No response
     * for the key typed event in this dialog.
     *
     * @param e the KeyEvent object.
     *
     */
    public void keyPressed(KeyEvent e) 
    {
        
    }
    
    
    /**
     * Implements the required method of the KeyListener. If the
     * (pressed and) released key is ENTER key, then makes
     * this dialog disappear.
     *
     * @param e the KeyEvent object.
     *
     */
    public void keyReleased(KeyEvent e) 
    {
        if (e.getKeyChar() == ENTER_KEY) {
            setVisible(false);
        }
    }
    
    /**
     * Displays the char value after converting it to a string.
     *
     * @param character the char value to display
     *
     */
    public void show( char character )
    {
        show(" " + character + " ");
    }


    /**
     * Displays the integer value after converting it to a string. 
     *
     * @param number the integer value to display
     *
     */
    public void show (long number)
    {
        show(" " + number + " ");
    }

    /**
     * Displays the real number after converting it to a string. 
     *
     * @param number the real value to display
     *
     */
    public void show (double number)
    {
        show(" " + number + " ");
    }

    /**
     * Displays the String value. 
     *
     * @param text the String value to display
     *
     */
    public void show (String text)
    {
        label.setText(text);
   
        adjustSize();
        moveToCenter();

        super.setVisible(true);

    }

    /**
     * Displays the StringBuffer value after conveting it to a string. 
     *
     * @param text the StringBuffer value to display
     *
     */
    public void show (StringBuffer text)
    {
        show(text.toString());
    }
    
    /**
     * Displays the char value after converting it to a string. 
     * Position this dialog at (x, y).
     *
     * @param character the char value to display
     * @param x         the x-coordinate of the dialog position
     * @param y         the y-coordinate of the dialog position
     *
     */
    public void show (char character, int x, int y)
    {
        show(" " + character + " ", x, y);
    }


    /**
     * Displays the integer value after converting it to a string. 
     * Position this dialog at (x, y).
     *
     * @param number the integer value to display
     * @param x      the x-coordinate of the dialog position
     * @param y      the y-coordinate of the dialog position
     *
     */
    public void show (long number, int x, int y)
    {
        show(" " + number + " ", x, y);
    }

    
    /**
     * Displays the real number after converting it to a string. 
     * Position this dialog at (x, y).
     *
     * @param number the real value to display
     * @param x      the x-coordinate of the dialog position
     * @param y      the y-coordinate of the dialog position
     *
     */
    public void show (double number, int x, int y)
    {
        show(" " + number + " ",  x, y);
    }
    
    /**
     * Displays the String value. 
     * Position this dialog at (x, y).
     *
     * @param text the String value to display
     * @param x    the x-coordinate of the dialog position
     * @param y    the y-coordinate of the dialog position
     *
     */
    public void show (String text, int x, int y)
    {
        label.setText(text);
    
        adjustSize();
        setLocation(x,y);

		wasMoved = true;		
			
        super.setVisible(true);
    }

    
    /**
     * Displays the StringBuffer value after conveting it to a string. 
     * Position this dialog at (x, y).
     *
     * @param text the StringBuffer value to display
     * @param x    the x-coordinate of the dialog position
     * @param y    the y-coordinate of the dialog position
     *
     */
    public void show (StringBuffer text, int x, int y)
    {
        show(text.toString(), x, y);
    }



//-----------------------------------------------
//    Protected Methods:
//
//            void    adjustSize      (           )
//
//-----------------------------------------------
    
    /**
     * Place the label and button and adjust the dialog dimension
     *
     */
    protected void adjustSize()
    {
        //height will not vary
        int height = DIALOG_HEIGHT;
        int width  = DIALOG_WIDTH; //this is a minimum

//        addNotify();
        Insets inset = getInsets();

        //get the label string length in pixels
        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        FontMetrics fontMet = toolkit.getFontMetrics(font);

        int strWidth = fontMet.stringWidth(label.getText());
        int windWidth = strWidth + 60 + inset.left + inset.right;
        if (width < windWidth) 
            width = windWidth;
        setSize(width, height);

        //now place the control objects
        int midpoint = (width-inset.left-inset.right)/2;
        label.setBounds(midpoint-strWidth/2,height/3,strWidth,20);

        okButton.setBounds(midpoint-25,100, 50, 20);
    }



//-----------------------------------------------
//    Private Methods:
//
//       void    initialize  (           )
//
//-----------------------------------------------
           
   /**
    * Initializes the components in this MessageBox. Layout manage is not used.
    * The position of components are computed dynamically in the adjustSize method. 
    */
    private void initialize()
    {
        font = new Font("Helvetica",Font.PLAIN, 12);
        
        setResizable(false);
        setForeground(Color.black);
        setBackground(Color.white);
        setLayout(null);

        label = new Label();
        label.setFont(font);
        add(label);

        okButton = new Button("OK");
        okButton.addActionListener(this);
        add(okButton);
 
        addWindowListener(this);
        okButton.addKeyListener(this);

    }

}