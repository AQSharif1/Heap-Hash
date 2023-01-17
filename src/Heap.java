import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Heap {   
	private static int[] heaps;   
	private static int heapSize;   
	private static ArrayList<Integer> heapList = new ArrayList<Integer>();
	private static  int maxSize;   
	//public static Main m;

	public Heap()  {   
		Heap.maxSize = 22;   
		Heap.heapSize = 0;   
		Heap.heaps = new int[Heap.maxSize];   
	}   
	/**
	 * Method to get the parent 
	 * @param pos
	 * @return
	 */
	private int getParent(int pos)  {   
		return pos / 2;   
	}   
	/**
	 * Swaps the places of two points
	 * @param l
	 * @param r
	 */
	private static void swap(int l, int r)  {   
		int temp;   
		temp = heaps[l];   
		heaps[l] = heaps[r];   
		heaps[r] = temp;   
	}   

	/**
	 * inserts data and places it in correct location
	 * prints after each insertion
	 * @param data
	 */
	public void insert(int data)  {   
		heaps[++heapSize] = data;   
		int current = heapSize;   

		while (heaps[current] <heaps[getParent(current)]) {    
			swap(current, getParent(current));   
			current = getParent(current);   
		} 
		if (heapSize>= maxSize) {   
			return;   
		}  
		print();
	}   

	/**
	 * adds heap array into Arraylist
	 */
	public void addToList() {
		for(int i = 0; i< maxSize; i++) {
			if(heaps[i] != 0 ) {	
				heapList.add( heaps[i]);
			}
		}
	}

	/**
	 * prints heapSort 
	 */
	public void printArray() {
		DecimalFormat df = new DecimalFormat("#,###,###,000");

		for(int j=0; j<=heapList.size()-1 ; j++)   
		{   
			System.out.print(df.format(heapList.get(j)) + " " );   
		}   

	}


	/**
	 * HeapSort sorts the heap List from highest to lowest
	 */
	public void heapSort() {
		int temp;
		for(int i = 0; i < heapList.size(); i++) {
			for(int k = 0; k<i ; k++ ) {
				if(heapList.get(i) >= heapList.get(k)) {
					temp = heapList.get(i);
					heapList.remove(heapList.get(i));
					heapList.add(i, heapList.get(k));

					heapList.remove(heapList.get(k));
					heapList.add(k, temp);
				}
			}
			printArray();
			System.out.println("\n");
		}
	}

	/**
	 * prints minHeap
	 */
	public static void print()  {   
 		DecimalFormat df = new DecimalFormat("#,###,###,000");
		
		
		for(int j=1; j<=heapSize ; j++) {
			System.out.print(df.format(heaps[j]) + " "  );   
		}   
		System.out.println();

	}   
} 