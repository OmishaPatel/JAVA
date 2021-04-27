import java.util.Scanner;
public class SimpleCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method study
		double firstNum;// first num in the expression
		double secondNum;// second num in the expression
		char operator;// the operator in the expression
		double value;// value in the expression
		
		System.out.println("Enter expressions such as  2 + 2  or  2.2 * 14.34");
	    System.out.println("using any of the operators +, -, *, /.");
	    System.out.println("To end, enter a 0.");
	    System.out.println();
	    
	    
	    while (true) {
	    	System.out.print("? ");
	    	Scanner sc = new Scanner(System.in);
	    	firstNum = sc.nextInt();
	    	if(firstNum == 0) 
	    		break;
	    	operator = sc.next().charAt(0);
	    	secondNum = sc.nextDouble();
	    	
	    	
	    	// adding the values of expression
	    	switch(operator) {
	    	case '+':
	    		value = firstNum + secondNum;
	    		break;
	    	case '-':
	    		value = firstNum - secondNum;
	    		break;
	    	case '*':
	    		value = firstNum * secondNum;
	    		break;
	    	case '/':
	    		value = firstNum / secondNum;
	    		break;
	    	default:
	    		System.out.println("Unknown operator "+ operator);
	    		continue;
	    	
	    	}
	    	System.out.println("Value is: "+value);
	    	
	}
	    System.out.println("Bye!");

	}
}
