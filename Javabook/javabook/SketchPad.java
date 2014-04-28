package javabook;

import java.awt.*;
import java.awt.event.*;



/**
 * This window supports a freehand drawing. You draw pictures by dragging the while
 * holding the left button down (the only button for a single-button mouse). 
 * You erase the drawing by clicking the right button (ctrl-click on a single-button
 * mouse). This window does not have a "memory" so if you minimize and restore this 
 * window, for example, the drawing will be gone.
 *
 *<p> 
 * This class is provided as freeware. You are free to use as provided or modify to
 * your heart's content. But you use it at your own risk. No implied or explicit 
 * warranty is given.
 * 
 *<p>
 * @author C. Thomas Wu a.k.a Dr. Caffeine
 */
public class SketchPad extends MainWindow implements MouseListener, MouseMotionListener
{
    
//----------------------------------
//    Data Members:
//----------------------------------
    

    /**
     * The X coordinate of the last position of the mouse
     */
    private int last_x;
    
    /**
     * The Y coordinate of the last position of the mouse
     */
    private int last_y;

    
//-----------------------------------------
//
//    Constructors:
//
//-----------------------------------------

    /**
     * Default Constructor. The default title is 
     * "SketchPad For Your Doodle Art"
     *
     */
    public SketchPad()
    {
        this("SketchPad For Your Doodle Art");
    }
    
    
    /**
     * Constructs a SketchPad object with the parameter title
     *
     * @param title the title of this window
     */
    public SketchPad(String title)
    {
        super(title);
        initialize();
    }

//-----------------------------------------------
//    Public Methods:
//
//        void     mouseDragged    (  MouseEvent     )
//        void     mouseMoved      (  MouseEvent     )
//        void     mouseClicked    (  MouseEvent     )
//        void     mousePressed    (  MouseEvent     )
//        void     mouseEntered    (  MouseEvent     )
//        void     mouseExited     (  MouseEvent     )
//
//----------------------------------------------
    
    /**
     * Implements the required method of the MouseMotionListener. This method
     * draws a line between the current point and the previously rememebered
     * point. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the MouseEvent object.
     *
     */
    public void mouseDragged(MouseEvent e)
    {
        if (!e.isMetaDown()) { //don't process right button drag

           int x = e.getX();
           int y = e.getY();

           Graphics g = getGraphics();
           g.drawLine(last_x, last_y, x, y);
           last_x = x;
           last_y = y;
           g.dispose();
        }
    }

    /**
     * Implements the required method of the MouseMotionListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the MouseEvent object.
     *
     */
    public void mouseMoved(MouseEvent e)
    {
    }

    /**
     * Implements the required method of the MouseListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the MouseEvent object.
     *
     */
    public void mouseClicked(MouseEvent e)
    {
    }

    
    /**
     * Implements the required method of the MouseListener. This method
     * process the mouse button click. If the right button is pressed,
     * then "erase" the current drawing by painting the contents with
     * the background color. If the left button is pressed, intialize
     * to start a new drawing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the MouseEvent object.
     *
     */
    public void mousePressed(MouseEvent e)
    {
        if (e.isMetaDown()) {
           //erase the content if it is a rightbutton
           Graphics g = getGraphics();
           Rectangle r = getBounds();
           g.clearRect(0, 0, r.width, r.height);
           g.dispose();
        }
        else {
           //reset for a new mouse drag
           last_x = e.getX();
           last_y = e.getY();
        }
    }

    
    /**
     * Implements the required method of the MouseListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the MouseEvent object.
     *
     */
    public void mouseReleased(MouseEvent e)
    {
    }

    
    /**
     * Implements the required method of the MouseListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the MouseEvent object.
     *
     */
    public void mouseEntered(MouseEvent e)
    {
    }
 
    
    /**
     * Implements the required method of the MouseListener. This method
     * does nothing. Do not call this
     * method. The Java virtual machine handles the window event processing.
     * 
     * @param e the MouseEvent object.
     *
     */
    public void mouseExited(MouseEvent e)
    {
    }

//-----------------------------------------------
//    Private Methods:
//        
//        void         initialize       (       )
//
//-----------------------------------------------
    
   /**
    * Initializes the components in this dialog. Layout manage is not used.
    * The position of components are computed dynamically in the adjustSize method. 
    */
    private void initialize()
    {
        last_x = 0;
        last_y = 0;
      
        setSize(400,300);
      
        moveToCenter();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
}
