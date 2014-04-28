package javabook;

import java.awt.*;
import java.awt.event.*;

/**
 * This is an abstract superclass of other JavaBook dialogs. 
 * An InputBox dialog is modeless
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
public abstract class JavaBookDialog extends Dialog implements WindowListener
{

//----------------------------------
//    Data Members:
//----------------------------------

    /**
     * The font used for this dialog.
	 */
    protected Font   font;
   
    /**
     * Tells whether this dialog has moved or not from the center of the screen. Initially,
     * any javabook dialog is displayed at the center of the screen. But once this dialog
     * is moved and shown again, it will be shown at the position it was last moved to. 
     */  
    protected boolean wasMoved;

//-----------------------------------
//    Constructors
//-----------------------------------

    /**
     * Creates a modal dialog. This constructor is called from a constructor of one
     * of the subclasses. You cannot call this constructor directly as this class is
     * an abstract class.
     *
     * @param owner any Frame object, but most commonly expected is a MainWindow object
     *
     */
    public JavaBookDialog(Frame owner)
    {
        this( owner, true );
    }

    /**
     * Creates a modal or modeless dialog. The second parameter determines this dialog's
     * modality: <code>true</code> for modal and <code>false</code> for modeless.
     * This constructor is called from a constructor of one
     * of the subclasses. You cannot call this constructor directly as this class is
     * an abstract class.
     *
     * @param owner any Frame object, but most commonly expected is a MainWindow object
     * @param modal <code>true</code> for modal and <code>false</code> for modeless dialog
     *
     */
    public JavaBookDialog(Frame owner, boolean modal)
    {
        super(owner,modal);
        
        font     = new Font("Helvetica",Font.PLAIN, 12);
   		wasMoved = false;
   			
        addWindowListener(this);
    }

//-----------------------------------------------
//    Public Methods:
//
//        void setVisible           ( boolean     )
//
//		  void windowOpened			( WindowEvent ) 
//        void windowClosing		( WindowEvent )
//        void windowClosed			( WindowEvent )
//        void windowIconified		( WindowEvent )
//        void windowDeiconified	( WindowEvent )
//        void windowActivated		( WindowEvent )
//        void windowDeactivated	( WindowEvent )
//
//-----------------------------------------------

    /**
     * Changes the visibility of this dialog. When the boolean parameter <code>view</code>
     * is <code>true</code>, then this dialog becomes visible. Otherwise, this dialog is hidden (not visible)
     * from the screen.
     * 
     * @param view <code>true</code> for visible and <code>false</code> for not visible
     *
     */
    public void setVisible(boolean view)
    {
        if (view) {
          adjustSize();
          if (!wasMoved) {
          	moveToCenter();
          	wasMoved = false;
          }
        }

        super.setVisible(view);
    }

    /**
     * Implements the required method of the WindowListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the WindowEvent object.
     *
     */
    public void windowOpened(WindowEvent e) 
    {
    }

    /**
     * Implements the required method of the WindowListener. Disposes native
     * window resources allocated to this dialog. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the WindowEvent object.
     *
     */
    public void windowClosing(WindowEvent e)
    {
        dispose();
    }

    /**
     * Implements the required method of the WindowListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the WindowEvent object.
     *
     */
    public void windowClosed(WindowEvent e)
    {
    }

    /**
     * Implements the required method of the WindowListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the WindowEvent object.
     *
     */
    public void windowIconified(WindowEvent e)
    {
    }

    /**
     * Implements the required method of the WindowListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the WindowEvent object.
     *
     */
    public void windowDeiconified(WindowEvent e)
    {
    }

    /**
     * Implements the required method of the WindowListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the WindowEvent object.
     *
     */
    public void windowActivated(WindowEvent e)
    {
    }

    /**
     * Implements the required method of the WindowListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the WindowEvent object.
     *
     */
    public void windowDeactivated(WindowEvent e)
    {
    }

//-----------------------------------------------
//    Protected Methods:
//
//            void    adjustSize  (   )
//            void    moveToCenter(   )
//
//-----------------------------------------------

    /**
     * Adjusts the dimension of this dialog based on the components
     * it contains. Implementation of this method will provided by
     * the individual subclasses.
     */
   abstract protected void adjustSize();

    /**
     * Moves this dialog to the center of the screen.
     */
   protected void moveToCenter()
   {
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       Rectangle selfBounds = getBounds();

       setLocation((screenSize.width - selfBounds.width) / 2,
                   (screenSize.height - selfBounds.height) / 2);
   }

}