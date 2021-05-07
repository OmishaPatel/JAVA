import javax.swing.JOptionPane;

public class MultipleChoiceQuestion extends Question {
	
	MultipleChoiceQuestion(String query, String a, String b, String
			c, String d, String e, String answer) {
		// initialize instance of question variable
		question = query+"\n";
		question += "A. "+a+"\n";
		question += "B. "+b+"\n";
		question += "C. "+c+"\n";
		question += "D. "+d+"\n";
		question += "E. "+e+"\n";
		
		// initialize instance of correctAnswer variable
		correctAnswer = answer.toUpperCase();
	}
	
		String ask() {
		while(true) {
		String answer = JOptionPane.showInputDialog(question);
		answer = answer.toUpperCase();
		boolean isValid = (answer.equals("A") || answer.equals("B") ||
				answer.equals("C") || answer.equals("D") ||answer.equals("E"));
		if(isValid) {
			return answer;
		}
		else {
			JOptionPane.showMessageDialog(null,"Invalid answer. Please enter A, B, C, D, or E.");
		}
		}
	}
		 
		
}
	
	


