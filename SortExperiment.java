package exercises;

import java.util.Arrays;


public class SortExperiment {

	final static int SIZE = 1000; // Length of the array to be sorted
	// Create a random string
	private static String randomString() {
		int length = 5 + (int)(21*Math.random());
		StringBuilder str = new StringBuilder();
		for (int i = 0 ; i < length; i++) {
			char ch = (char)('A' + (int)(26*Math.random()));
			str.append(ch);
			
		}
		return str.toString();
		
	}
	//Create random array of integers
	private static double[] randomNumbers(int count) {

		double[] numbers = new double[count];
		for(int i = 0; i < count; i++) {
			numbers[i] = Math.random();
		}
		return numbers;
	}
	
	//Create random array of strings
	private static String[] randomStrings(int count) {
		String[] strings = new String[count];
		for(int i = 0; i < count; i++) {
			strings[i] = randomString();
		}
		return strings;
	}
	
	//Selection sort algorithm
	  private static void selectionSort(double[] numbers) {
		  for(int i = 0; i < numbers.length-1; i++) {
			  
			  int min = i;
			  //find the minimum element in an array
			  for(int j = i+1; j < numbers.length; j++) 
				  if(numbers[j] < numbers[min]) 
					  min = j;
				  
				  // swap min element with first element in array
			  double temp = numbers[min];
			  numbers[min] = numbers[i];
			  numbers[i] = temp;
			  
		  }
	    }	
	
	// Selection sort algorithm for strings
	  private static void selectionSort(String[] numbers) {
		  for(int i = 0; i < numbers.length-1; i++) {
			  
			  int min = i;
			  //find the minimum element in an array
			  for(int j = i+1; j < numbers.length; j++) 
				  if(numbers[j].compareTo(numbers[min]) < 0)
					  min = j;
				  
				  // swap min element with first element in array
			  String temp = numbers[min];
			  numbers[min] = numbers[i];
			  numbers[i] = temp;
			  
		  }
	        
	    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime;  // time when a sort begin.
        long endTime;    // time when a sort ends.
        
		double [] numbersList1  = randomNumbers(SIZE); // array with random numbers
		String [] stringList1 = randomStrings(SIZE); // array with random strings
		// Sorting and printing out the output time
		startTime = System.nanoTime();
        selectionSort(numbersList1);
        endTime = System.nanoTime();
        System.out.printf("Seconds to sort %d numbers with selectionSort: %1.6g%n",
                                SIZE, (endTime - startTime) / 1e9);
        
        startTime = System.nanoTime();
        Arrays.sort(numbersList1);
        endTime = System.nanoTime();
        System.out.printf("Seconds to sort %d numbers with Arrays.sort(): %1.6g%n",
                                SIZE, (endTime - startTime) / 1e9);
        
        startTime = System.nanoTime();
        selectionSort(stringList1);
        endTime = System.nanoTime();
        System.out.printf("Seconds to sort %d strings with selectionSort: %1.6g%n",
                                SIZE, (endTime - startTime) / 1e9);
        
        startTime = System.nanoTime();
        Arrays.sort(stringList1);
        endTime = System.nanoTime();
        System.out.printf("Seconds to sort %d strings with Arrays.sort(): %1.6g%n",
                                SIZE, (endTime - startTime) / 1e9);
        System.out.println();
	
	}

}
