package edu.nps.util;


public class mytest {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		// Make an array queue
		NPSQueue<Integer> myQueue = new NPSLinkedQueue<Integer>();
		
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(1);
		myQueue.add(6);
		myQueue.add(90);
		myQueue.add(67);
	
		Integer[] array = myQueue.toArray();

		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		
		}
		}


		
		