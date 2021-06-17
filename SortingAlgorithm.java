import java.util.Arrays;


public class SortingAlgorithm {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int maxArraySize = 1000; // Array Size
		long startTimeArray1; // computing start time for array1
		long runTimeArray1;// total time for selection sort for array 1
		long startTimeArray2; // computing start time for array2
		long runTimeArray2;// total time for selection sort for array2
		int[] sortingArray1 = new int[maxArraySize]; // first array
		int[] sortingArray2 = new int[maxArraySize];// second array
		
		//arrays with random integer
		randomNumbers(sortingArray1);
		// assigning same values to array 2
		sortingArray2 = sortingArray1;
		
		// computing
		startTimeArray1 = System.currentTimeMillis();
		selectionSort(sortingArray1);
		runTimeArray1 = System.currentTimeMillis() - startTimeArray1;
		
		startTimeArray2 = System.currentTimeMillis();
		Arrays.sort(sortingArray2);
		runTimeArray2 =  System.currentTimeMillis() - startTimeArray2;
		
		// results
		
		System.out.println("SelectionSort time(sec): " +runTimeArray1/1000.0);
		System.out.println("ArraySort time(sec): " +runTimeArray2/1000.0);
		
		
	
	}

	//Create array with random integers
	static void randomNumbers(int[]A) {

		for(int i = 0; i <A.length; i++ ) {
			A[i] = (int)(Integer.MAX_VALUE * Math.random());
		}
	}
	
	// selection sort
	static void selectionSort(int[] A) {
		// Sort A into increasing order, using selection sort
		for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
		// Find the largest item among A[0], A[1], ...,
		
		int maxLoc = 0; // Location of largest item seen so far.
		for (int j = 1; j <= lastPlace; j++) {
		if (A[j] > A[maxLoc]) {
		// Since A[j] is bigger than the maximum we’ve seen
		// so far, j is the new location of the maximum value
		// we’ve seen so far.
		maxLoc = j;
		}
	    }
		int temp = A[maxLoc]; // Swap largest item with A[lastPlace].
		A[maxLoc] = A[lastPlace];
		A[lastPlace] = temp;
	} // end of for loop
}	

}// end of sorting algorithm class
