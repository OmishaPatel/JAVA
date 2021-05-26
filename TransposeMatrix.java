package exercises;

public class TransposeMatrix {

	public static int[][] computeTranspose(int[][] matrix){
		int[][] transpose;
		int R = matrix.length; // row of the matrix
		int C = matrix[0].length; // column of the matrix
		transpose = new int [C][R];
		for(int i = 0 ; i < C; i++) {
			for (int j = 0; j < R; j++) {
				transpose[i][j] = matrix[j][i];
			}
		}
		return transpose;
	}
	
	public static void printArray(int[][] array) {
		for(int[] row: array) {
			System.out.println("   ");
			for(int item : row) {
				System.out.printf(" %5d", item);
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] orig = {
                { 1, 2, 3, 4, 5, 6 },
                { 10, 20, 30, 40, 50, 60 },
                { 100, 200, 300, 400, 500, 600 }
        };
		System.out.println("Original Array: ");
		printArray(orig);
		System.out.println(" ");
		System.out.println("Transpose Array: ");
		printArray(computeTranspose(orig));
	}

}
