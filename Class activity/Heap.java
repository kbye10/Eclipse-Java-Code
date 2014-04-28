public class Heap {

	//implements the heap
	public int[] heap;
	
	//Stores sorted list
	public int[] sortedList;
	
	private void construct(){
		int current, MaxChildIndex;
		boolean done;
		
		for(int i=(heap.length-2)/2;i>=0;i--){
			current = i;
			done = false;
			
			while (!done){
				if (2*current+1>heap.length-1){
					done=true;
				}
				else {
					MaxChildIndex = maxChild(current,heap.length-1);
					
					if (heap[current] < heap[MaxChildIndex]){
						swap(current, MaxChildIndex);
						current = MaxChildIndex;
					}
					else {
						done=true;
					}
				}
		}
	}
	}
	
	private void extract(){
		int current, MaxChildIndex;
		boolean done;
		
		for (int size = heap.length-1;size >=0;size--){
		//remove the root node data
			sortedList[size] = heap[0];
			
		//move the last node to the root
			heap[0] = heap[size];
		//rebuild the heap with one fewer element
			current = 0;
			done=false;
			
			while (!done) {
				if(2*current+1>size){
					//current node has no children, so stop
					done = true;
				}
				else {
					//current node has at least one child
					//get index of larger child
					MaxChildIndex = maxChild(current,size);
					
					if (heap[current] < heap[MaxChildIndex]){
						//a child is larger, so swap and continue
						swap(current,MaxChildIndex);
						current = MaxChildIndex;
					}
					else {
						done = true;
					}
				}
			}
		}
	}
	
	private int maxChild(int location, int end){
		int result, leftChildIndex, rightChildIndex;
		
		rightChildIndex = 2*location+2;
		leftChildIndex = 2*location+1;
		
		assert leftChildIndex <= end:
				"Error: node at position "+location+" has no children";
		
		if (rightChildIndex <= end && heap[leftChildIndex]< heap[rightChildIndex]){
			result = rightChildIndex;
		}
		else {
			result = leftChildIndex;
		}
		return result;
	}
	
	private void swap (int loc1,int loc2){
		int temp;
		temp = heap[loc1];
		heap[loc1] = heap[loc2];
		heap[loc2] = temp;
	}
	
	public void setData(int[] data, int n){
		heap = new int[n];
		sortedList = new int[n];
		
		for (int i=0;i<n;i++){
			heap[i] = data[i];
		}
	}
	
	public int[] sort(){
		construct();
		extract();
		
		return sortedList;
	}

}
