package javabook;

import java.awt.*;
import java.awt.event.*;


/**
 * This class is used as the top-level main window of an application. The MainWindow
 * window will be almost as big as the screen and positioned at the center
 * of the screen. When the user closes this window, the program is terminated.
 *
 *<p> 
 * This class is provided as freeware. You are free to use as provided or modify to
 * your heart's content. But you use it at your own risk. No implied or explicit 
 * warranty is given.
 * 
 * @author C. Thomas Wu a.k.a Dr. Caffeine
 */
public class MainWindow extends Frame implements WindowListener
{

//-----------------------------------------
//
//    Data Members:
//
//-----------------------------------------
    
    /**
     * The size of the screen
     */

    private Dimension screenSize;


//-----------------------------------------
//
//    Constructors:
//
//-----------------------------------------

    /**
     * Default constructor. The title is fixed to "Sample Java Application".
     */
    public MainWindow()
    {
        this("Sample Java Application");
    }

    /**
     * Creates a new MainWindow object with the designated title.
     *
     * @param title the title of the window
     */
    public MainWindow(String title)
    {
        super(title);
        initialize();
    }


//--------------------------------------
//    Public Methods:
//
//        public void windowOpened       ( WindowEvent  ) Note: Do not call this method
//        public void windowClosing      ( WindowEvent  ) Note: Do not call this method
//        public void windowClosed       ( WindowEvent  ) Note: Do not call this method
//        public void windowIconified    ( WindowEvent  ) Note: Do not call this method
//        public void windowDeiconified  ( WindowEvent  ) Note: Do not call this method
//        public void windowActivated    ( WindowEvent  ) Note: Do not call this method
//        public void windowDeactivated  ( WindowEvent  ) Note: Do not call this method
//
//--------------------------------------
    
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
        System.exit(0);
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

//----------------------------------------------
//    Protected Methods:
//
//       void moveToCenter (   )
//
//----------------------------------------------

    /**
     * Moves this dialog to the center of the screen.
     */
    protected void moveToCenter()
    {
         Dimension selfBounds = getSize();
         setLocation((screenSize.width - selfBounds.width) / 2,
                     (screenSize.height - selfBounds.height) / 2);
    }

//----------------------------------------------
//    Private Methods:
//
//           void initialize   (   )
//
//----------------------------------------------

    /**
     * Initializes this window by setting its size and position. 
     * The size is set to be almost as big as the screen and the 
     * position is set to the center of the screen.
     */
    private void initialize()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize      = toolkit.getScreenSize();

        setSize(screenSize.width-20,screenSize.height-50);
        setBackground(Color.white);
        moveToCenter();
        addWindowListener(this);
    }

}