import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

// create MinHeapJavaImplementation class to create heap in Java  
public class Main{  
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<Integer> heaps = new ArrayList<Integer>();
	public static ArrayList<Integer> hashs = new ArrayList<Integer>();
	public static void main(String[] args) {
		Heap minHeap = new Heap();
		Hash hash = new Hash();
		try {
			String line = null;
			String fileName = "";
			System.out.println("Enter file name");
			fileName = scanner.nextLine();
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while((line = reader.readLine()) != null){
				heaps.add(Integer.parseInt(line));
				hashs.add(Integer.parseInt(line));

			}
			for(int i=0; i<heaps.size(); i++) { 
				minHeap.insert(heaps.get(i)); 
			}
			
			reader.close();
		}		catch(Exception e) {
			e.printStackTrace();
		}



		System.out.println("\nHeap Sort\n");
		minHeap.addToList();
		minHeap.heapSort();
		hash.size(hashs.size());
		for(int i =0; i < hashs.size(); i++) {
			hash.addHash(hashs.get(i));
		}
		hash.running();
	
		//hash.print();
		


	}   

}