package exercises;
import java.util.Scanner;

public class stringCapitalized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a line of text.");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		System.out.println();
	    System.out.println("Capitalized version:");
		printCapitalized(line);

	}
	static void printCapitalized(String str) {
		char ch;
		char prevch = '.';// starrting loop with any non-character
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if(Character.isLetter(ch) && (!Character.isLetter(prevch))) {
				System.out.print(Character.toUpperCase(ch));
			}else {
				System.out.print(ch);
			}
			prevch = ch;
		}
		
	}

}
