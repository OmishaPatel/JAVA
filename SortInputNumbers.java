package exercises;
import java.util.ArrayList;
import java.util.Scanner;

public class SortInputNumbers {

	private static void printOut(ArrayList<Integer> numbers) {
		for (int i = 0; i < numbers.size() -1 ; i++) {
			System.out.println(numbers.get(i) + ", ");
		}
		// Show last number in an array with period
		System.out.println(numbers.get(numbers.size() -1) + ". ");
		System.out.println();
	}
	
	
	private static void selectionSort(ArrayList<Integer> numbers){
		for(int i = 0; i < numbers.size() - 1; i++) {
			//variable to keep a track of min element in array
			int min = i;
			for(int j = i+1; j < numbers.size(); j++) {
				if(numbers.get(j) < numbers.get(min)) {
					min = j;
				}
				
			}
			// swap smallest element to front of the array
			int temp = numbers.get(min);
			numbers.set(min, numbers.get(i));
			numbers.set(i, temp);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter any single or double digit number from 1 to 20 to get a sorted array. ");
		while(true) {
			try {
				
			         int num = sc.nextInt();
			
			          if(num <= 0) 
				      break;
			         
			          numbers.add(num);
			}
			catch (IndexOutOfBoundsException e)  {
			 System.out.println("\nThere is an out of bounds error in the ArrayList.");
		    }
			
		}
		//print unsorted array
		printOut(numbers);
		
		
		// Sorting the array
		selectionSort(numbers);
		
		
		// printing sorted array
		
		printOut(numbers);
	}// End of main

}
