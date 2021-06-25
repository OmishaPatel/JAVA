import java.math.BigInteger;
import java.util.Scanner;
/* computes fibonacci and factorial numbers for a input n*/
public class FibonacciAndFactorial {
	 /*
	  * main routine calling fibonacci and factorial mathods
	  */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("Enter a positive number: ");
			int N = in.nextInt();
			if(N==0) {
				break;
			} else if (N < 0){
				System.out.println("Only positive numbers are allowed ");
				continue;
				
			}
			BigInteger BigIntegerN = BigInteger.valueOf(N);
			System.out.println(" Fatorial of "+ N + " is "+ factorial(BigIntegerN));
			if(N >= 40) {
				System.out.println("Number can't be greater than 40 for fibonacci ssequencce");
			}else {
				System.out.println("Fibonacci of "+ N + " is "+ fibonacci(N));
			}
			System.out.println("Fibonacci of "+ N + " non-recursively  is "+ nonRecursiveFibonacci(N));
		}
		
	}
	// method to compute fibonacci recursively
	static int fibonacci(int N) {
		assert N >= 0: "Only positive numbers are allowed for fibonacci sequence";
		assert N <=40: "n is to large to compute fibonnaci(N) recursively";
		if(N==0 || N==1) {
			// Base case answer is 1
			return 1;
		}else {
			return fibonacci(N-1) + fibonacci(N-2);
		}
		
	}
	
	// fibonacci non recursive using bigInteger and for loop
	static BigInteger nonRecursiveFibonacci(int N) {
		assert N >= 0: "Only positive numbers are allowed for fibonacci sequence";
		if(N==0 || N==1) {
			// Base case answer is 1
			return BigInteger.ONE;
		}else {
			BigInteger f0 = BigInteger.ONE; // fibonacci(i-2)
			BigInteger f1 = BigInteger.ONE; //fibonacci (i-1)
			for (int i = 2; i <=N; i++) {
				BigInteger fi = f0.add(f1);
				f0= f1;// updating variable to account for i++ in the loop
				f1=fi;
				
			}
			return f1; // variable holding the lst fibonacci number
		}
	}
	
	// method to compute factorial recursively
	static BigInteger factorial(BigInteger N) {
		assert N.signum()>= 0: 	"Only positive numbers are allowed for factorial sequence";
		if(N.equals(BigInteger.ZERO)) {
			// Base case
			return BigInteger.ONE;
		}else {
			// n = (n-1)*n
			BigInteger minusOneFactorial =  factorial(N.subtract(BigInteger.ONE));
			return N.multiply(minusOneFactorial);
					
		}
		}
}

/*
 * Output
 * Enter a positive number: 
60
 Fatorial of 60 is 8320987112741390144276341183223364380754172606361245952449277696409600000000000000
NUmber can't be greater than 40 for fibonacci ssequencce
 Fibonacci of 60 non-recursively  is 2504730781961
Enter a positive number: 
38
 Fatorial of 38 is 523022617466601111760007224100074291200000000
 Fibonacci of 38 is 63245986
 Fibonacci of 38 non-recursively  is 63245986
Enter a positive number: 
 */
