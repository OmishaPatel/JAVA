import javax.swing.JOptionPane;
public class Quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean is_true = false;
		//While loop will execute until is_true returns true 
		while (!is_true) {
		String question = "What country won the very first FIFA World Cup in 1930?\n";
		question += "A. Brazil\n";
		question += "B. Colombia\n";
		question += "C. Uruguay\n";
		question += "D. Peru\n";
		question += "E. Bolivia\n";
		String answer = JOptionPane.showInputDialog(question);
		answer = answer.toUpperCase();
		//While loop will execute until is_true returns true 
		if (answer.equals("C")) {
			 JOptionPane.showMessageDialog(null,"Correct!");
			 is_true = true;
			 break;
			}
		else if (answer.equals("A") || answer.equals("B") || answer.equals("D")|| answer.equals("E") ) {
			 JOptionPane.showMessageDialog(null,"Incorrect. Please try again.");
		}
		else {
			JOptionPane.showMessageDialog(null,"Invalid answer. Please enter A, B, C, D, or E.");
		}
	}
		
	}

}
