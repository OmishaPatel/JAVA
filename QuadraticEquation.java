import java.util.Scanner;

public class QuadraticEquation {
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double A, B, C; // coefficients for equation
		double solution; // solution for the equation
		boolean playAgain = true; // set to true if user wants to
		String next; // stores answer from user whether to continue or not
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hi in order to get root of a quadratic equation, please enter values for A, B and C. ");
		
		do {
			
			System.out.print("A: ");
			A = scan.nextDouble();
			System.out.print("B: ");
			B = scan.nextDouble();
			System.out.print("C: ");
			C = scan.nextDouble();
			
			try {
				
				solution = root(A,B,C);
				System.out.println("Solution is, "+ solution);
					
			} catch (IllegalArgumentException e){
			
				System.out.println(e.getMessage());
				
				System.out.println("Do you want solution to another equation? Please enter [y/n]" );
				next = scan.next().toLowerCase();
				if(next.equals("n")) { 
					playAgain = false;
					break;
				}
				else if (next.equals("y")) {
					playAgain = true;
				}
				else {
					System.out.println("Wrong input. Please only enter either y or n.");
				}

			}
		}while(playAgain);
		
			
	}
	
	/**
	 * Returns the larger of the two roots of the quadratic equation
	 * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
	 * if the discriminant, B*B - 4*A*C, is negative, then an exception
	 * of type IllegalArgumentException is thrown.
	 */
	static public double root( double A, double B, double C )
        throws IllegalArgumentException {
		if (A == 0) {
			throw new IllegalArgumentException("A can't be zero.");
		}
		else {
			double disc = B*B - 4*A*C;
			if (disc < 0)
				throw new IllegalArgumentException("Discriminant < zero.");
			return  (-B + Math.sqrt(disc)) / (2*A);
		}
}

}
