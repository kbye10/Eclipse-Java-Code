
import java.util.*;

public class Project {

	/**
	 * @param args
	 */
	public static void main(String[]Args){
	    int []A = new int [100000];
		int []B = new int [100000];
		Heap heap = new Heap();
		Date starttime, endtime;
		long elapsedtime;
		
		Sorting.LoadArray(A);
		Sorting.ResetArrays(A,B);

		System.out.println("Dummy Sort/Reset");
		starttime = new Date();
		for(int i=0; i<90000;i++){
			Sorting.DummySort(B,100000);
			Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 90,000");
		System.out.println("Time for calling sort method/resetting: "+elapsedtime+"\n");
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
//------------------------------------------------------------------------
//		Sorts of 100 numbers
//------------------------------------------------------------------------		
		
		System.out.println("Bubble Sort of 100 numbers: ");
		starttime = new Date();
		for(int i=0;i<120000;i++){
		Sorting.BubbleSort(B,100);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 120,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Selection Sort of 100 numbers: ");
		starttime = new Date();
		for(int i=0;i<120000;i++){
		Sorting.SelectionSort(B,100);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 120,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Insertion Sort of 100 numbers: ");
		starttime = new Date();
		for(int i=0;i<120000;i++){
		Sorting.InsertionSort(B,100);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 120,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Shell Sort of 100 numbers: ");
		starttime = new Date();
		for(int i=0;i<120000;i++){
		Sorting.ShellSort(B,100);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 120,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Heap Sort of 100 numbers: ");
		starttime = new Date();
		heap.setData(B,100000);
		for(int i=0;i<120000;i++){
			B = heap.sort(B,100);
			Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 120,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Merge Sort of 100 numbers: ");
		starttime = new Date();
		for(int i=0;i<120000;i++){
			Sorting.MergeSort(B,0,100-1);
			Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 120,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");	
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
	
//------------------------------------------------------------------------
//		Sorts of 1,000 numbers
//------------------------------------------------------------------------		
				
		System.out.println("Bubble Sort of 1,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<7000;i++){
		Sorting.BubbleSort(B,1000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 7,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Selection Sort of 1,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<7000;i++){
		Sorting.SelectionSort(B,1000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 7,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Insertion Sort of 1,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<20000;i++){
		Sorting.InsertionSort(B,1000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 20,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Shell Sort of 1,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<40000;i++){
		Sorting.ShellSort(B,1000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 40,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Heap Sort of 1,000 numbers: ");
		starttime = new Date();
		heap.setData(B,100000);
		for(int i=0;i<80000;i++){
			B = heap.sort(B,1000);
			Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 80,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Merge Sort of 1,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<20000;i++){
			Sorting.MergeSort(B,0,1000-1);
			Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 20,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
	
//------------------------------------------------------------------------
//		Sorts of 10,000 numbers
//------------------------------------------------------------------------
	
		System.out.println("Bubble Sort of 10,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<50;i++){
		Sorting.BubbleSort(B,10000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 50");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Selection Sort of 10,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<50;i++){
		Sorting.SelectionSort(B,10000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 50");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Insertion Sort of 10,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<350;i++){
		Sorting.InsertionSort(B,10000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 350");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Shell Sort of 10,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<5000;i++){
		Sorting.ShellSort(B,10000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 5,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Heap Sort of 10,000 numbers: ");
		starttime = new Date();
		heap.setData(B,100000);
		for(int i=0;i<60000;i++){
			B = heap.sort(B,10000);
			Sorting.ResetArrays(A,B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 60,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Merge Sort of 10,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<500;i++){
			Sorting.MergeSort(B,0,10000-1);
			Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 500");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
	
//------------------------------------------------------------------------
//		Sorts of 100,000 numbers
//------------------------------------------------------------------------
		
		System.out.println("Bubble Sort of 100,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<1;i++){
		Sorting.BubbleSort(B,100000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 1");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Selection Sort of 100,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<1;i++){
		Sorting.SelectionSort(B,100000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 1");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Insertion Sort of 100,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<3;i++){
		Sorting.InsertionSort(B,100000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 3");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Shell Sort of 100,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<400;i++){
		Sorting.ShellSort(B,100000);
		Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 400");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Heap Sort of 100,000 numbers: ");
		starttime = new Date();
		heap.setData(B,100000);
		for(int i=0;i<8000;i++){
			B = heap.sort(B,100000);
			Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 8,000");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");
		
		
		System.out.println("Merge Sort of 100,000 numbers: ");
		starttime = new Date();
		for(int i=0;i<3;i++){
			Sorting.MergeSort(B,0,100000-1);
			Sorting.ResetArrays(A, B);
		}
		endtime = new Date();
		elapsedtime = endtime.getTime()-starttime.getTime();
		System.out.println("Cycles: 3");
		System.out.println("Time in milliseconds: "+elapsedtime+"\n");

	} 
}
