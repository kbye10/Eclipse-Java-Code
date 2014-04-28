package javabook;

import java.awt.*;
import java.awt.event.*;


/**
 * This dialog is for accepting multiple input values. Input values are returned
 * as an array of String objects. You have to convert the String values to appropriate
 * data type in your code.
 *
 *<p> 
 * This class is provided as freeware. You are free to use as provided or modify to
 * your heart's content. But you use it at your own risk. No implied or explicit 
 * warranty is given.
 * 
 *<p>
 * @author C. Thomas Wu a.k.a Dr. Caffeine
 */
public class MultiInputBox extends JavaBookDialog implements ActionListener
{


//----------------------------------
//    Data Members:
//----------------------------------

    /**
     * The constant to represent the state of action pending
     */
    private final static int ACTION_PENDING = 0;
    
    /**
     * The constant to represent the state which the OK button is clicked
     */    
    private final static int ACTION_OK      = 1;
    
    /**
     * The constant to represent the state which the CANCEL button is clicked
     */    
    private final static int ACTION_CANCEL  = 2;
    
    /**
     * The state of this dialog
     */
    private int status;

    /**
     * The array of TextField objects for accepting user input
     */
    private TextField   inputLine[];
    
    /**
     * The array of labels for input lines
     */
    private Label       prompt[];
    
    /**
     * The OK button
     */
    private Button      okButton;
    
    /**
     * The CANCEL button
     */
    private Button      cancelButton;
    
    /**
     * The font used for labels
     */
    private Font        font;
    
    /**
     * The number of input liness in this dialog
     */
    private int         numOfRows;
    
    /**
     * The input line that is current, i.e. has input focus
     */
    private int         currentLine;



//-----------------------------------------
//
//    Constructors:
//
//-----------------------------------------

    /**
     * Constructs a MultiInputBox with the owner frame and
     * size input lines.
     *
     * @param owner the owning Frame object
     * @param size  the number of input lines
     */
    public MultiInputBox(Frame owner, int size)
    {
        super(owner,true);
        numOfRows = size;
        initialize();
    }

    /**
     * Constructs a MultiInputBox with the owner frame and
     * labels for input lines.
     *
     * @param owner  the owning Frame object
     * @param labels the array of String for input line labels
     */
    public MultiInputBox(Frame owner, String[] labels)
    {
        this(owner, labels.length);
        setLabels(labels);
    }


//-----------------------------------------------
//    Public Methods:
//
//            void     actionPerformed ( ActionEvent          ) Note: Do not call this method
//
//            void     windowClosing   (WindowEvent           ) Note: Do not call this method
//
//            String[] getInputs       (                      )
//            boolean  isCanceled      (                      )
//
//            void     setLabels       ( String[]             )
//            void     setValue        ( int,   String        )
//
//----------------------------------------------

    /**
     * Implements the required method of the ActionListener. Do not call this
     * method. The Java virtual machine handles the action event processing.
     * This method sets this dialog's state depending on whether the OK or
     * CANCEL button is pressed.
     *
     * @param e the ActionEvent object.
     *
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == okButton) {
           //close the dialog
            setVisible(false);
            status = ACTION_OK;
        }
        else if (e.getSource() == cancelButton) {
            setVisible(false);
            status = ACTION_CANCEL;
            clearInputLines();
        }
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
        dispose();
        status = ACTION_CANCEL;
    }

    /**
     * Returns the input values entered by the user.
     *
     * @return an array of String values entered by the user
     */
    public String[] getInputs()
    {
        showIt();
        boolean done = false;

        String[] answers = getInputLines();
        clearInputLines();

        return answers;
    }

    /**
     * Returns true if the state of this dialog is CANCEL.
     *
     * @return the state of this dialog; true if CANCEL; false otherwise
     */
    public boolean isCanceled()
    {
        if (status == ACTION_CANCEL) {
            return true;
        }
        else {
            return false;
        }
    }

    
    /**
     * Assigns the input line labels to the passed array
     *
     * @param label an array of String for input line labels
     */
    public void setLabels(String[] label)
    {
        for (int i = 0; i < label.length; i++) {
            prompt[i].setText(label[i]);
        }
    }

    /**
     * Sets the value to the input line at the index position. This
     * method is useful to set default input values so the user
     * gets an hint on the type of values expected in the input lines.
     *
     * @param index the position of the input line to set the value
     * @param value the value to assign to the input line
     */
    public void setValue(int index, String value)
    {
        inputLine[index].setText(value);
    }


//-----------------------------------------------
//    Protected Methods:
//
//            void    adjustSize      (           )
//
//-----------------------------------------------
    
    /**
     * Adjust the size of this dialog based on the components it contains.
     *
     */
    protected void adjustSize()
    {
        //NOTE: This is a long method and be shortened by using some form of
        //      form of layout manager. However, since layout managers are not
        //      explained in any details in the book, I used a long way of 
        //      computing the position and size of components.

        //dialog dimension is fixed
        int windowHeight = 230, windowWidth = 300,
            buttonWidth  = 60, buttonHeight = 25,
            centerGap    = 10,

            leftMargin, rightMargin,
            topMargin, bottomMargin,

            labelWidth, strWidth,
            labelHeight,
            inputLineWidth,
            inputOffset;


        leftMargin   = 10;
        rightMargin  = 10;
        topMargin    = 40;
        bottomMargin = 20;

        //find the width of the prompt with largest number of characters
        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        FontMetrics fontMet = toolkit.getFontMetrics(font);

        labelWidth = 0;
        for (int i = 0; i < numOfRows; i++) {
            strWidth = fontMet.stringWidth(prompt[i].getText());
            if (strWidth > labelWidth) {
                labelWidth = strWidth;
            }
        }

        labelHeight = 22;       //use a fixed value for height
        inputLineWidth = 100;   //use a fixed value input text field

        inputOffset = leftMargin + labelWidth+25 + centerGap; //add 25 to make it wider
        for (int i = 0; i < numOfRows; i++) {
            prompt[i].setBounds(leftMargin, topMargin+labelHeight*i,
                                labelWidth+25, labelHeight);

            inputLine[i].setBounds(inputOffset, topMargin+labelHeight*i,
                                   inputLineWidth, labelHeight);
        }

        //adjust the window size
        windowHeight = topMargin + bottomMargin + (numOfRows+1)*labelHeight
                        + buttonHeight+10;

        windowWidth = leftMargin + centerGap + rightMargin +
                        labelWidth+30 + inputLineWidth;

        setSize(windowWidth,windowHeight);

         //place buttons
        int midpoint = (leftMargin+rightMargin+centerGap+labelWidth+30+inputLineWidth)/2;

        okButton.setBounds(midpoint-(buttonWidth+10),topMargin+(numOfRows+1)*labelHeight,
                           buttonWidth,buttonHeight);
        cancelButton.setBounds(midpoint+10,topMargin+(numOfRows+1)*labelHeight,
                               buttonWidth,buttonHeight);

    }
  

//-----------------------------------------------
//    Private Methods:
//        
//        void         clearInputLines  (       )
//        String[]     getInputLines    (       )
//        int          getStatus        (       )
//        void         initialize       (       )
//        void         showIt           (       )
//
//-----------------------------------------------

    /**
     * Clears the input lines by assigning empty String
     */
    private void clearInputLines()
    {
        for (int i = 0; i < numOfRows; i++) {
            inputLine[i].setText("");
        }
        currentLine = 0;
    }
    

    /**
     * Returns the contents of the input lines
     *
     * return an array of String currently in the input lines
     */

    private String[] getInputLines()
    {
         String[] answer = new String[inputLine.length];
         if (status == ACTION_CANCEL) {
             answer = null;
         }
         else {
             for (int i = 0; i < inputLine.length; i++) {
                 answer[i] = inputLine[i].getText();
             }
         }

         return answer;
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
    * Initializes the components in this dialog. Layout manage is not used.
    * The position of components are computed dynamically in the adjustSize method. 
    */
    private void initialize()
    {
        status = ACTION_PENDING;
        font   = new Font("Helvetica",Font.PLAIN, 12);
        currentLine = 0;
        
        setResizable(false);
        setForeground(Color.black);
        setLayout(null);

        setTitle("MultiInputBox");
        prompt = new Label[numOfRows];
        inputLine = new TextField[numOfRows];

        for (int i = 0; i < numOfRows; i++) {
            prompt[i] = new Label();
            prompt[i].setFont(font);
            inputLine[i] = new TextField();
            inputLine[i].setFont(font);
            add(prompt[i]);
            add(inputLine[i]);
        }

        inputLine[0].requestFocus();

        okButton     = new Button("  OK  ");
        okButton.addActionListener(this);
        cancelButton = new Button("Cancel");
        cancelButton.addActionListener(this);
        add(okButton);
        add(cancelButton);

        addWindowListener(this);
    }


    /**
     * Makes this dialog visible again.
     */
    private void showIt()
    {

        adjustSize();
        moveToCenter();

        super.setVisible(true);
        inputLine[currentLine].requestFocus();

    }

}
