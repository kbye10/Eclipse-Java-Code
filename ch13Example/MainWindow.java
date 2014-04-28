/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 13 Sample Development: MainWindow helper class

    File: MainWindow.java

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is a helper class for Ch 13 sample development. This class has the same
 * functionality as the MainWindow class from the javabook package.
 */
public class MainWindow extends JFrame {

//-----------------------------------------
//
//    Data Members:
//
//-----------------------------------------

    /**
     * Default title for this dialog
     */
    private static final String  DEFAULT_TITLE = "Sample Java Application";

    /**
     * The left and right margins between the screen and
     * this window's left and right boundaries
     */
    private static final int HORIZONTAL_MARGIN = 40;

    /**
     * The top and bottom margins between the screen and
     * this window's top and bottom boundaries
     */
    private static final int VERTICAL_MARGIN   = 80;

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
    public MainWindow() {
        this( DEFAULT_TITLE );
    }

    /**
     * Creates a new MainWindow object with the designated title.
     *
     * @param title the title of the window
     */
    public MainWindow(String title) {
        super(title);
        initialize( );
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
    protected void moveToCenter()  {
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
     * Initializes this window.
     */
    private void initialize(  ) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize      = toolkit.getScreenSize();

        setSize(screenSize.width-HORIZONTAL_MARGIN,screenSize.height-VERTICAL_MARGIN);

        Container contentPane = getContentPane();
        contentPane.setBackground( Color.white );

        moveToCenter();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}