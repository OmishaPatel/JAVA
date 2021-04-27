package exercises;

import java.util.Scanner;

public class HexValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long hexnum = 0;
		System.out.println("Enter a combination of any number from 0 to 9 and alphabet letter from A to F to get hex value: ");
		Scanner sc = new Scanner(System.in);
		String hex = sc.nextLine();
		for (int i = 0; i < hex.length(); i++) {
			int num = hexValue(hex.charAt(i));
			if (num == -1) {
				System.out.println("Sorry but you entered a non valid input");
				return;
			}else {
				hexnum = 16*hexnum + num;
			}
		}
		System.out.println("Hexadecimal number is: "+hexnum);
		
	}
	public static int hexValue(char ch) {
		switch(ch) {
		case '0':
            return 0;
         case '1':
            return 1;
         case '2':
            return 2;
         case '3':
            return 3;
         case '4':
            return 4;
         case '5':
            return 5;
         case '6':
            return 6;
         case '7':
            return 7;
         case '8':
            return 8;
         case '9':
            return 9;
         case 'a':   //considering both lower and upper cases
         case 'A':
            return 10;
         case 'b':
         case 'B':
            return 11;
         case 'c':
         case 'C':
            return 12;
         case 'd':
         case 'D':
            return 13;
         case 'e':
         case 'E':
            return 14;
         case 'f':
         case 'F':
            return 15;
         default:
            return -1;
		}
	}
}
