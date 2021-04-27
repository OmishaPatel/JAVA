package exercises;

public class DiceRollStats {
	public static final int NUMBER_OF_EXPERIMENTS = 10000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double average;
		System.out.println("Total On Dice     Average Number of Rolls");
	    System.out.println("-------------     -----------------------");
		for (int dice =  2; dice <=12; dice++) {
			average = averageRollCount(dice);
			System.out.printf("%10d%22.4f\n", dice, average);
		}

	}
	
	public static double averageRollCount(int total) {
		int totalRollCountThisExperiment;
		int rollTotal = 0;
		double averageCountRoll;
		for(int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
			totalRollCountThisExperiment = rollingDice(total);
			rollTotal += totalRollCountThisExperiment;
		}
		averageCountRoll = ((double)rollTotal) / NUMBER_OF_EXPERIMENTS;
		return averageCountRoll;
		
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
