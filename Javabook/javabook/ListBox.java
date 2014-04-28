package javabook;

import java.awt.*;
import java.awt.event.*;

/**
 * This class provides a list of items from which the user can select. Only a single
 * selection is allowed. Appropriate status is returned when the selection is
 * not made.
 *
 *<p> 
 * This class is provided as freeware. You are free to use as provided or modify to
 * your heart's content. But you use it at your own risk. No implied or explicit 
 * warranty is given.
 * 
 * @author C. Thomas Wu a.k.a Dr. Caffeine
 */
public class ListBox extends JavaBookDialog implements ActionListener
{

//----------------------------------
//    Data Members:
//----------------------------------

    /**
     * Nothing is selected
     */
    public static final  int     NO_SELECTION  = -1;
    
    /**
     * The Cancel button is pressed
     */
    public static final  int     CANCEL        = -2;
    
    /**
     * Nothing is selected
     */
    public static final  String  NO_ITEM       = null;
    
    /**
     * OK button is pressed
     */ 
    private static final int 	 ACTION_OK     =  0;
    
    /**
     * Cancel button is pressed
     */
    private static final int 	 ACTION_CANCEL = -1;
    
    /**
     * The actual object that contains the list of items
     */
    private List    list;
    
    /**
     * The OK buton
     */
    private Button  okButton;
      
    /**
     * The Cancel button
     */
    private Button  cancelButton;
    
    /**
     * Tells which of the two buttons is clicked
     */
    private int     status;


//-----------------------------------
//    Constructors
//-----------------------------------

    /**
     * Creates a modal dialog with a default title.
     *
     * @param owner any Frame object, but most commonly expected is a MainWindow object
     *
     */
    public ListBox(Frame owner)
    {
        this(owner,"Select One:",true);
    }

    /**
     * Creates a modal dialog with its title set to the second parameter.
     *
     * @param owner any Frame object, but most commonly expected is a MainWindow object
     * @param text  the title of this dialog
     *
     */
    public ListBox(Frame owner, String text)
    {
        this(owner,text,true);
    }

    /**
     * Creates a modal or modeless dialog with a default title.
     *
     * @param owner any Frame object, but most commonly expected is a MainWindow object
     * @param modal <code>true</code> for modal and <code>false</code> for modeless dialog
     *     
     */
    public ListBox(Frame owner, boolean modal)
    {
        this(owner,"Select One:",modal);
    }

    /**
     * Creates a modal or modeless dialog with its title set to the second parameter.
     *
     * @param owner any Frame object, but most commonly expected is a MainWindow object
     * @param text  the title of this dialog
     * @param modal <code>true</code> for modal and <code>false</code> for modeless dialog
     *     
     */
    public ListBox(Frame owner, String text, boolean modal)
    {
        super(owner,modal);
        setTitle(text);
        initialize();
    }


//-----------------------------------------------
//    Public Methods:
//
//        void    actionPerformed     ( ActionEvent   ) Note: Do not call this method
//        void    addItem             ( String        )
//        void    deleteItem          ( int           )
//        void    deleteItem          ( String        )
//
//        int     getSelectedIndex    (               )
//        String  getItemFromIndex    ( int           )
//        String  getSelectedItem     (		          )
//
//        boolean isCanceled          (               )
//
//        void    windowClosing	      ( WindowEvent   ) Note: Do not call this method
//
//-----------------------------------------------

    /**
     * Implements the required method of the ActionListener. Do not call this
     * method. The Java virtual machine handles the action event processing.
     * This method sets the status to ACTION_OK or ACTION_CANCEL depending on
     * which button is clicked.
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
        }
    }

    /**
     * Adds a new item to the list.
     *
     * @param item a String value to be added to the list
     */
    public void addItem(String item)
    {
        list.add(item);
    }

    /**
     * Deletes an item from the list. The item to remove is identified
     * by its position index in the list.
     *
     * @param index the position of an item to be removed
     */
    public void deleteItem(int index)
    {
        list.remove(index);
    }

    /**
     * Deletes an item from the list. The item (String) to remove is identified
     * by its value.
     *
     * @param item an item to be removed
     */
    public void deleteItem(String item)
    {
        //search for an item in the list
        int i       = 0;
        int length  = list.getItemCount();

        while (i < length && list.getItem(i) != item) {
            i++;
        }

        if (i < length) {
            //found, so delete it
            list.remove(i);
        }

        //if not found, do nothing
    }

    /**
     * Returns the position of the item selected. If the OK button was
     * clicked, then the method returns the index of the selected item. If the
     * Cancel button was clicked, then this method returns NO_SELECTION.
     *
     * @return status of the user selection
     */
    public int getSelectedIndex()
    {
        showIt();
        if (status == ACTION_OK)  {
            return list.getSelectedIndex();
            //returns NO_SELECTION if nothing is selected
        }
        else if (status == ACTION_CANCEL) {
            return CANCEL; // user closed with Cancel button
            //NOTE: returns CANCEL if canceled
        }
        else {
            return NO_SELECTION;
            //NOTE: returns NO_SELECTION if closed without selecting an item.
        }
    }
    
    
    /**
     * Returns an item at the specified location in the list. This method
     * returns an item at the designated position whether the item is selected
     * or not.
     *
     * @param index position of an item in the list
     *
     * @return the specified item in the list 
     */
    public String getItemFromIndex(int index) 
    {
       return list.getItem(index);
    }
    
    /**
     * Returns the selected item if any. Appropriate status is returned
     * if no item is selected.
     *
     * return the item selected by the user
     */
    public String getSelectedItem()
    {
        showIt();
        if (status == ACTION_OK) {
            return list.getSelectedItem();
            //returns NO_ITEM if nothing is selected
        }
        else {
            return NO_ITEM;
            //NOTE: returns NO_ITEM if canceled, closed,
            //      or okayed without selecting an item.
        }
    }

    /**
     * Returns true if this dialog is canceled by the user
     *
     * @return true if this dialog is canceled
     */
    public boolean isCanceled( )
    {
        if (status == ACTION_CANCEL) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * The standard event handler for window closing event. This dialog
     * is closed when the window closing event occurs.
     */
    public void windowClosing(WindowEvent e)
    {
        dispose();
        status = ACTION_CANCEL;
    }


//-----------------------------------------------
//    Protected Methods:
//
//            void    adjustSize      (           )
//
//-----------------------------------------------
    
    /**
     * Adjusts the dialog. Nothing is in this method because the Panel object
     * is used for layout.
     */
    protected void adjustSize()
    {
    }


//-----------------------------------------------
//    Private Methods:
//
//       void    initialize      (           )
//       void    showIt          (           )
//
//-----------------------------------------------

   /**
    * Initializes the components in this ListBox. Uses a Panel to put
    * the components, instead of absolute positioning.
    */
   private void initialize()
   {
       setResizable(false);
       setSize(170,200);

       list = new List();
       list.setFont(font);
       add("Center",list);

       Panel p = new Panel();

       okButton     = new Button("  OK  ");
       okButton.addActionListener(this);
       cancelButton = new Button("Cancel");
       cancelButton.addActionListener(this);
       p.add(okButton);
       p.add(cancelButton);
       add("South",p);

       addWindowListener(this);
       moveToCenter();
   }

   /**
    * Shows this ListBox on the screen. Before showing, this method
    * removes the previous selection if there is one.
    */
   private void showIt()
   {
       //deselect any previously selected item
       int index = list.getSelectedIndex();
       if (index >=0) {
           list.deselect(index);
       }

       super.setVisible(true);
   }

}