package exercises;

public class DiceRollStats2 {
	
	static final int NUMBER_OF_EXPERIMENTS = 1000;
	//creating pairofdice object
	static PairOfDice dice = new PairOfDice();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int total = 2; total <= 12; total++) {
			//initiate calc object to calculate stats
			StatCalc calc = new StatCalc();
			
			// loop to calculate how long it took to reach total number
			for(int i =  0; i  < NUMBER_OF_EXPERIMENTS; i++) {
				calc.enter(rollfor(total));
			}
			
			 System.out.printf("%6d", total);
	         System.out.printf("%18.3f", calc.getMean());
	         System.out.printf("%19.3f", calc.getStandardDeviation());
	         System.out.printf("%14.3f", calc.getmaxNum());
	         System.out.println();
		}
		
		

	}
	static int rollfor(int n) {
		int rollCount = 0;
		do {
			
			dice.roll();
			rollCount++;
		}while(dice.getTotal()!= n);
		return rollCount;
		
	}

}
