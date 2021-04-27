package exercises;
import java.util.Scanner;
public class RollingDice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int countRolls = 0;
		int a;
		int b;
		do {
			a = (int)(6*Math.random()) + 1;
			b = (int)(6*Math.random()) + 1; 
			countRolls ++;
		}while (a!=1 || b!=1);
		System.out.println("It took "+ countRolls + " times for computer to get snake eyes");
	}

}
