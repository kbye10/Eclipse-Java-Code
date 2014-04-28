/*
     Introduction to OOP with Java (Comprehensive Version 1st Ed), McGraw-Hill
    
     Wu/Otani
    
     Chapter 20 Sample Program: The Queue ADT
    
     File: edu/nps/util/NPSQueue.java
*/

package edu.nps.util;

public interface NPSQueue<E> {
    
    public void add(E item);

    public void clear( );
    
    public boolean isEmpty( );
    
    public E  peek( ) throws NPSQueueEmptyException;
    
    public E  remove( )  throws NPSQueueEmptyException;

    public int size(  );
    
    public E[] toArray();
}
