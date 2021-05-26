package exercises;

import java.util.ArrayList;

public class SeveralRandomIntegers {

	public static ArrayList<Integer> makeRandomInts(int count, int max){
		
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		while(randomNumbers.size() < count) {
			int num = (int)(Math.random()*max) + 1;
			if(randomNumbers.indexOf(num) == -1) {
				randomNumbers.add(num);
			}
		}
		return randomNumbers;
	}
	
	
	
	public static void printArrayList(ArrayList<Integer> randomNumbers) {
		for (int i = 0; i < randomNumbers.size(); i++) {
			System.out.println(randomNumbers.get(i));
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArrayList(makeRandomInts(10,100));
	}

}
