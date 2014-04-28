package javabook;

import java.awt.*;
import java.awt.event.*;


/**
 * This dialog is for accepting YES/NO response from the user. 
 * By default this dialog has two buttons labeled YES and NO. This dialog
 * can be set to have either one, two, or three buttons. You also have
 * an option of setting the button labels. 
 *
 *<p> 
 * This class is provided as freeware. You are free to use as provided or modify to
 * your heart's content. But you use it at your own risk. No implied or explicit 
 * warranty is given.
 *
 *<p>
 * @author C. Thomas Wu a.k.a Dr. Caffeine
 */
public class ResponseBox extends JavaBookDialog implements ActionListener
{

//----------------------------------
//    Data Members:
//----------------------------------

    /**
     * The constant to represent the leftmost button
     */
    static public final int BUTTON1 =  1;
    
    /**
     * The constant to represent the middle button
     */
    static public final int BUTTON2 =  2;
    
    /** 
     * The constant to represent the rightmost button
     */
    static public final int BUTTON3 =  3;
    
    /**
     * The constant to represent the YES button, which is the
     * same as the leftmost button
     */
    static public final int YES = BUTTON1;
    
    /**
     * The constant to represent the NO button, which is the 
     * same as the middle button
     */
    static public final int NO  = BUTTON2;
    
    /**
     * The constant to represent the Cancel action
     */
    static public final int CANCEL = -1;

    /**
     * The constant to represent the state of action is pending
     */
    private final static int ACTION_PENDING = 0;
    
    /**
     * The state of this dialog box
     */
    private int status;

    /**
     * Keeps the number of buttons assigned to this dialog
     */
    private int     numberOfButtons;
    
    /**
     * The prompt text of this dialog
     */
    private Label   prompt;
    
    /**
     * The array of buttons attached to this dialog
     */
    private Button  button[];
    
    /**
     * The font used in displaying the prompt
     */
    private Font    font;



//-----------------------------------------
//
//    Constructors:
//
//-----------------------------------------

    /**
     * Constructs a ResponseBox with the owner frame and
     * two buttons.
     *
     * @param owner the owning Frame object
     */
    public ResponseBox(Frame owner)
    {
        this(owner, 2);
    }
    
    /**
     * Constructs a RepsonseBox with the owner frame and
     * size input lines.
     *
     * @param owner        the owning Frame object
     * @param buttonCount  the number of buttons attached to this dialog
     */
    public ResponseBox(Frame owner, int buttonCount)
    {
        super(owner, true);

        if (buttonCount < 1 || buttonCount > 3) {
            numberOfButtons = 1;
        }
        else {
            numberOfButtons = buttonCount;
        }

        initialize();
    }


//-----------------------------------------------
//    Public Methods:
//
//            void    actionPerformed ( ActionEvent          ) Note: Do not call this method
//
//            void    windowClosing   (WindowEvent           ) Note: Do not call this method
//
//            int     prompt          ( String               )
//            void    setLabel        ( int,   String        )
//
//----------------------------------------------

    /**
     * Implements the required method of the ActionListener. Do not call this
     * method. The Java virtual machine handles the action event processing.
     * This method sets the status to indicate which button is pressed.
     *
     * @param e the ActionEvent object.
     *
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button[0]) {
            //close the dialog
            setVisible(false);
            status = BUTTON1;
        }
        else if (e.getSource() == button[1]) {
            //close the dialog
            setVisible(false);
            status = BUTTON2;
        }
        else if (e.getSource() == button[2]) {
            //close the dialog
            setVisible(false);
            status = BUTTON3;
        }
    }

    /**
     * Makes this dialog visible and prompts the user. Returns
     * the status after this dialog is closed.
     */
    public int prompt(String text)
    {
        setPrompt(text);
        showIt();   //this dialog is modal so this method won't finish
                    //until the dialog is closed

        return getStatus();
    }

    /**
     * Sets the label of id's button to the passed text.
     *
     * @param id   the id of the button
     * @param text the new label of the designated button
     */
    public void setLabel(int id, String text)
    {
        if (id <= numberOfButtons && id > 0) {
            button[id-1].setLabel(text);
        }

        //do nothing for invalid button#
    }

    /**
     * Overrides the inherited method. Sets the state of this dialog
     * to CANCEL.
     * The Java virtual machine handles the window event processing.
     * 
     * @param e the WindowEvent object.
     *
     */
    public void windowClosing(WindowEvent e)
    {
        setVisible(false);
        status = CANCEL;
    }
    
    
//-----------------------------------------------
//    Protected Methods:
//
//            void    adjustSize      (           )
//            int     getStatus       (           )
//            void    initialize      (           )
//            void    setPrompt       ( String    )
//            void    showIt          (           )
//-----------------------------------------------
    
    /**
     * Place the components and adjust the size.
     *
     */
    protected void adjustSize()
    {
        //height will not vary
        int height = 110;
        
        int width  = 200; //this is a minimum

//      addNotify();
        Insets inset = getInsets();

        //get the label string length in pixels
        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        FontMetrics fontMet = toolkit.getFontMetrics(font);

        int strWidth = fontMet.stringWidth(prompt.getText());

        int buttonsWidth = button[0].getPreferredSize().width + 5 + //hgap
                           button[1].getPreferredSize().width + 5 +
                           button[2].getPreferredSize().width;
        //worked with "preferredSize", but didn't with "bounds"

         int windWidth = Math.max(strWidth,buttonsWidth)
                         + 60 + inset.left + inset.right;

        if (width < windWidth)  {
            width = windWidth;
        }
        
        setSize(width, height);
    }


    /**
     * Returns the state of this dialog
     *
     * @return the state of this dialog
     */
    private int getStatus()
    {
        return status;
    }

    
   /**
    * Initializes the components in this dialog. Three Panel objects are used
    * to place the components. Default layout manager is used here. 
    */
    private void initialize()
    {
        
        button   = new Button[3];
        font     = new Font("Helvetica",Font.PLAIN, 12);
        
        status   = ACTION_PENDING;
        
        //setResizable(false);
        setForeground(Color.black);

        Panel emptyPanel = new Panel();
        add("North",emptyPanel); //this will position the prompt
                                 //at the middle of dialog

        Panel promptPanel = new Panel();

        prompt = new Label();
        prompt.setFont(font);
        prompt.setText("   ");

        promptPanel.add(prompt);
        add("Center",promptPanel);

        Panel buttonPanel = new Panel();

        button[0]   = new Button(" Yes  ");
        button[0].addActionListener(this);
        button[1]   = new Button("  No  ");
        button[1].addActionListener(this);
        button[2]   = new Button("Cancel");
        button[2].addActionListener(this);

        switch (numberOfButtons) {
            case 1:
                button[0].setLabel("  OK  ");
                button[1].setVisible(false);
            case 2:
                button[2].setVisible(false);
        }

        buttonPanel.add(button[0]);
        buttonPanel.add(button[1]);
        buttonPanel.add(button[2]);
        add("South",buttonPanel);

        addWindowListener(this);
    }
  
    /**
     * Sets the prompt label to the passed text.
     *
     * @param text the prompt text
     */

    private void setPrompt(String text)
    {
        prompt.setText(text);
    }
    
    /**
     * Makes this dialog visible again.
     */
    private void showIt()
    {
        adjustSize();
        moveToCenter();
        super.setVisible(true);
    }

}
