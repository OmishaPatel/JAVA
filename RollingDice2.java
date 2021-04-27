package exercises;
import java.util.Scanner;

public class RollingDice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalCountRolls = rollingDice(2);
		System.out.println("It took "+ totalCountRolls + " times for computer to get snake eyes.");
		
	}
	public static int rollingDice(int num) {
		if(num <2 || num > 12) 
			throw new IllegalArgumentException("Impossible total for a pair of dice.");
		int a;
		int b;
		int total;
		int countRolls = 0;
		do {
			a = (int)(6*Math.random()) + 1;
			b = (int)(6*Math.random()) + 1; 
			total =  a + b;
			countRolls ++;
		}while (total != num);
		return countRolls;
	}

}
