package javabook;

import java.awt.*;
import java.awt.event.*;

/**
 * This class is used for getting an input from the user. An InputBox dialog is modal
 * and capable of accepting integers, real numbers, and strings. An InputBox dialog
 * will remain on the screen until a valid input is entered.
 *
 *<p> 
 * This class is provided as freeware. You are free to use as provided or modify to
 * your heart's content. But you use it at your own risk. No implied or explicit 
 * warranty is given.
 * 
 * @author C. Thomas Wu a.k.a Dr. Caffeine
 */
 
public class InputBox extends JavaBookDialog implements ActionListener, KeyListener
{

//----------------------------------
//    Data Members:
//----------------------------------

    /**
     * Default title for this dialog when not specified by the programmer
     */
    private static String   DEFAULT_TITLE   = "InputBox";
    
    /**
     * Default error message when the user enters invalid input
     */
    private static String   DEFAULT_ERR_MSG = "Invalid entry. Try again...";
    
    /**
     * Set width for the input textfield
     */
    private static int      FIELD_WIDTH     = 15;    
    
    /**
     * TextField for user input
     */
    private TextField   inputLine;
    
    /**
     * Prompt text
     */
    private Label       prompt;
    
    /**
     * Error message text
     */
    private Label       errorMessage;
    
    /**
     * The OK button
     */
    private Button      okButton;
    
    /**
     * Font used for the labels
     */
    private Font        font;
    
    /**
     * Text for error message
     */
    private String      errorMsgText;
    
    /**
     * true if error message needs to be shown 
     */
    private boolean     showErrorMsg;


//-----------------------------------
//    Constructors
//-----------------------------------

    /**
     * Creates an instance of InputBox with a default title and error message.
     *
     * @param owner any Frame object, but most commonly expected is a MainWindow object
     *
     */
    public InputBox  (Frame owner)
    {
       this( owner, DEFAULT_TITLE );
    }

    /**
     * Creates an instance of InputBox with the title
     * set to the second parameter and the error message set to a default message.
     *
     * @param owner any Frame object, but most commonly expected is a MainWindow object
     * @param title the InputBox title
     *
     */
    public InputBox (Frame owner, String title)
    {
       this( owner, title, DEFAULT_ERR_MSG );
    }
    
    /**
     * Creates an instance of InputBox with the title
     * set to the second parameter and the error message set to the 
     * third parameter.
     *
     * @param owner    any Frame object, but most commonly expected is a MainWindow object
     * @param title    the InputBox title
     * @param errorMsg the error message to be displayed for an invalid input
     *
     */    
    public InputBox (Frame owner, String title, String errorMsg)
    {
       super(owner,true);
       initialize( title, errorMsg );
    }


//-----------------------------------------------
//    Public Methods:
//
//        void      actionPerformed ( ActionEvent       ) Note: Do not call this method
//
//        int       getInteger      (                   )
//        int       getInteger      ( String            )
//
//        double    getDouble       (                   )
//        double    getDouble       ( String            )
//
//        int       getInteger      (                   )
//        int       getInteger      ( String            )
//
//        float     getFloat        (                   )
//        float     getFloat        ( String            )
//
//        String    getString       (                   )
//        String    getString       ( String            )
//
//        void      keyTyped        ( KeyEvent          ) Note: Do not call this method
//        void      keyPressed      ( KeyEvent          ) Note: Do not call this method
//        void      keyReleased     ( KeyEvent          ) Note: Do not call this method
//
//-------------------------------------------------

    /**
     * Implements the required method of the ActionListener. Do not call this
     * method. The Java virtual machine handles the action event processing.
     * 
     * @param e the ActionEvent object.
     *
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == okButton) {
            //close the dialog
            dispose();
        }
    }

    /**
     * Returns a <code>double</code> value entered the user.
     * Prompts the user for a <code>double</code> value, and the 
     * dialog will not close until the user enters a valid
     * <code>double</code> vale.
     * 
     * @return an input <code>double</code> value
     *
     */
    public double getDouble()
    {
        return getDouble("Enter a double:");
    }

    /**
     * Returns a <code>double</code> value entered the user.
     * Prompts the user for a <code>double</code> value using
     * the second parameter as the prompt text. The 
     * dialog will not close until the user enters a valid
     * <code>double</code> vale.
     * 
     * @param text the text for prompting the user
     *
     * @return an input <code>double</code> value
     *
     */
    public double getDouble(String text)
    {
        setPrompt(text);
        showIt(false);

        boolean done = false;
        double value = 0.0;
        Double doubleObject;

        do {
            try {
                doubleObject = Double.valueOf(getInputLine());
                value = doubleObject.doubleValue();
                done = true;
            }

            catch (NumberFormatException e) {
               showIt(true);
            }
        } while (!done);

        return value;
    }

    /**
     * Returns a <code>float</code> value entered the user.
     * Prompts the user for a <code>float</code> value, and the 
     * dialog will not close until the user enters a valid
     * <code>float</code> vale.
     * 
     * @return an input <code>float</code> value
     *
     */
    public float getFloat()
    {
        return getFloat("Enter a float:");
    }

    /**
     * Returns a <code>float</code> value entered the user.
     * Prompts the user for a <code>float</code> value using
     * the second parameter as the prompt text. The 
     * dialog will not close until the user enters a valid
     * <code>float</code> vale.
     * 
     * @param text the text for prompting the user
     *
     * @return an input <code>float</code> value
     *
     */
    public float getFloat(String text)
    {
        setPrompt(text);
        showIt(false);

        boolean done = false;
        float value = 0f;
        Float floatObject;

        do {
            try {
                floatObject = Float.valueOf(getInputLine());
                value = floatObject.floatValue();
                done = true;
            }

            catch (NumberFormatException e) {
               showIt(true);
            }
        } while (!done);

        return value;
    }
    
    /**
     * Returns an <code>int</code> value entered the user.
     * Prompts the user for an <code>int</code> value, and the 
     * dialog will not close until the user enters a valid
     * <code>int</code> vale.
     * 
     * @return an input <code>int</code> value
     *
     */
    public int getInteger()
    {
        return getInteger("Enter an integer:");
    }

    /**
     * Returns an <code>int</code> value entered the user.
     * Prompts the user for an <code>int</code> value using
     * the second parameter as the prompt text. The 
     * dialog will not close until the user enters a valid
     * <code>int</code> vale.
     * 
     * @param text the text for prompting the user
     *
     * @return an input <code>int</code> value
     *
     */
    public int getInteger(String text)
    {
        setPrompt(text);
        showIt(false);

        boolean done = false;
        int value = 0;

        do {
            try {
                value = Integer.parseInt(getInputLine());
                done = true;
            }

            catch (NumberFormatException e) {
                showIt(true);
            }
        } while (!done);

        return value;
    }

    /**
     * Returns a <code>String</code> value entered the user.
     * Prompts the user for a <code>String</code> value using a 
     * generic prompt text.
     * 
     * @return an input <code>String</code> value
     *
     */
    public String getString()
    {
        return getString("Enter a string:");
    }

    /**
     * Returns a <code>String</code> value entered the user.
     * Prompts the user for a <code>String</code> value using
     * the second parameter as the prompt text.
     * 
     * @param text the text for prompting the user
     *
     * @return an input <code>String</code> value
     *
     */
    public String getString(String text)
    {
        setPrompt(text);
        showIt(false);

        boolean done = false;

        return (getInputLine());
    }

    /**
     * Implements the required method of the KeyListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the key event processing.
     * 
     * @param e the KeyEvent object.
     *
     */
    public void keyTyped(KeyEvent e) {
    }
    
    /**
     * Implements the required method of the KeyListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the key event processing.
     * 
     * @param e the KeyEvent object.
     *
     */
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Implements the required method of the KeyListener. Do not call this
     * method. The Java virtual machine handles the key event processing. This
     * method is called by the system when the key is (pressed and) released. 
     * If the key released was the Enter (Return) key, this dialog is closed.
     * 
     * @param e the KeyEvent object.
     *
     */    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
           dispose();
        }
    }

//-----------------------------------------------
//    Protected Methods:
//
//          void    adjustSize   (           )
//
//-----------------------------------------------

    /**
     * Implements the abstract method of the superclass JavaBookDialog. This method
     * places the required GUI components and adjusts the dialog's dimension
     * accordingly.
     */
    protected  void adjustSize()
    {
        //dialog dimension is fixed
        int height = 150;
        int width  = 200;

        addNotify();
        Insets inset = getInsets();
 
        //get the label string length in pixels
        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        FontMetrics fontMet = toolkit.getFontMetrics(font);

        int strWidth          = fontMet.stringWidth(prompt.getText());
        int lineWidth         = inputLine.getPreferredSize().width;
        int errorMsgTextWidth = fontMet.stringWidth(errorMsgText);
        int maxStrLen         = Math.max(strWidth, lineWidth);

        if (showErrorMsg) {
           maxStrLen = Math.max(errorMsgTextWidth, maxStrLen);
        }

        int windWidth = maxStrLen + 60 + inset.left + inset.right;

        if (width < windWidth) {
            width = windWidth;
        }
        setSize(width, height);

        //now place the component objects
        int midpoint = (width-inset.left-inset.right)/2;
        if (strWidth < lineWidth) {
            //align prompt with inputLine if its smaller than inputLine
            prompt.setBounds(midpoint-lineWidth/2,inset.top+35,strWidth,20);
        }
        else {
            prompt.setBounds(midpoint-strWidth/2,inset.top+35,strWidth,20);
        }

        inputLine.setBounds(midpoint-lineWidth/2,inset.top+60,lineWidth,20);
        okButton.setBounds(midpoint-25,height-inset.bottom-25, 50, 20);
        
        errorMessage.setBounds(midpoint-errorMsgTextWidth/2,inset.top+10,errorMsgTextWidth,20);

        //pack(); 

    }

//--------------------------------------
//    Private Methods:
//
//          void    clearInputLine  (           )
//          String  getInputLine    (           )
//          void    initialize      ( String    )
//          void    setPrompt       ( String    )
//          void    showIt          ( boolean   )
//
//---------------------------------------
		
    /**
     * Erases the content of the input edit box (TextField). Effect of erasing
     * is achieved by writing an empty string to the edit box.
	 */
    private void clearInputLine()
    {
        inputLine.setText("");
    }


    /**
     * Reads the content of the input edit box (TextField).
     */
    private String getInputLine()
    {
        return inputLine.getText();
    }
    

    /**
     * Creates the GUI components and initializes them. This method only creates
     * the GUI components. The actual placement of these components takes place
     * in the adjustSize method.
     *
     * @param title    the dialog title
     * @param errorMsg an error message to display when an invalid input is entered
     */
    private void initialize( String title, String errorMsg)
    {
        setResizable(false);
        setForeground(Color.black); //need this to change the background to white
        setBackground(Color.white);
        setLayout(null);
        setTitle( title );      
        
        font         = new Font("Helvetica",Font.PLAIN, 12);
        errorMsgText = errorMsg;

        inputLine    = new TextField( FIELD_WIDTH ); 
        inputLine.setFont(font);
        add(inputLine);

        prompt       = new Label("Enter Data:");
        prompt.setFont(font);
        add(prompt);

        showErrorMsg = false;
        errorMessage = new Label(errorMsgText);
        errorMessage.setFont(font);
        add(errorMessage);

        okButton     = new Button("OK");
        okButton.addActionListener(this);
        add(okButton);

        addWindowListener(this);
        inputLine.addKeyListener(this);
    }
    

    /**
     * Sets the prompt text to the passed parameter.
     * 
     * @param text the prompt text
     */
    private void setPrompt(String text)
    {
        prompt.setText(text);
    }

    /**
     * Resets and makes the dialog visible again on the screen. The 
     * boolean parameter specifies whether to show the error message
     * or not.
     *
     * @param showError <code>true<\code> to show the error message, false otherwise
     */
    private void showIt(boolean showError)
    {
        /*
        Hiding components and showing them back
        has the effect of erasing previous content.
        This is necessary when the sizes of component
        change and get smaller than previous.
        Sequence of invalidate and validate did not work.
        */

        errorMessage.setVisible(false);
        inputLine.setVisible(false);
        prompt.setVisible(false);
        okButton.setVisible(false);
        
        showErrorMsg = showError;
        if (showErrorMsg) {
           errorMessage.setVisible(true);
        }
        else { //only clear the input line if no error
           clearInputLine();
        }
        
        inputLine.setVisible(true);
        prompt.setVisible(true);
        okButton.setVisible(true);

        inputLine.requestFocus();

        setVisible(true);
    }

}