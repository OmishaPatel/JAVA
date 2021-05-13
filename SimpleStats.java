package exercises;
import java.util.Scanner;
public class SimpleStats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		StatCalc calc = new StatCalc();
		double item;
		
		System.out.println("Enter a number to get simple stats.  Enter 0 if you want program to end");
		
		do {
			System.out.println("?");
			item = in.nextDouble();
			if(item!=0) {
				calc.enter(item);
			}
		}while(item != 0);
		
		
		  System.out.println("\nStatistics about your data:\n");
          System.out.println("   Count:              " + calc.getCount());
          System.out.println("   Sum:                " + calc.getSum());
          System.out.println("   Minimum:            " + calc.getminNum());
          System.out.println("   Maximum:            " + calc.getmaxNum());
          System.out.println("   Average:            " + calc.getMean());
          System.out.println("   Standard Deviation: "
                 + calc.getStandardDeviation());
		
	}

}
