package exercises;
import java.util.Scanner;
public class AdditionQuizWithObjects {
	private static AdditionQuestion[] questions;
	private static int[] userAnswers;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println();
	     System.out.println("Welcome to the addition quiz!");
	     System.out.println();
	     createQuiz();
	     administerQuiz();
	     gradeQuiz();
	}
	// storing quiz questions in an array of objects
	static void createQuiz() {
		questions = new AdditionQuestion[10];
		for(int i = 0 ; i < 10; i++) {
			questions[i] = new AdditionQuestion();
		}
	}
	// getting user's answers and storing it in a array
	static void administerQuiz() {
		userAnswers = new int[10];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int questionNum = i + 1;
			System.out.printf("Question %2d:  %s ",
            questionNum, questions[i].getQuestion());
			userAnswers[i] = in.nextInt();
		}
	}
	// grading the quiz
	
	static void gradeQuiz() {
		int noOfCorrectAnswers = 0;
		int grade;
		for (int i = 0; i < 10; i++) {
			int questionNum = i + 1;
			System.out.printf("   Question %2d:  %s  Correct answer is %d  ",
	                questionNum, questions[i].getQuestion(), questions[i].getCorrectAnswer());
		
		if(userAnswers[i] == questions[i].getCorrectAnswer()) {
			noOfCorrectAnswers ++;
			System.out.println("You were correct !");
		}
		else {
			System.out.println("You said "+userAnswers[i]+" which is incorrect");
		}
		}
		grade = noOfCorrectAnswers * 10;
		System.out.println();
        System.out.println("You got " + noOfCorrectAnswers + " questions correct.");
        System.out.println("Your grade on the quiz is " + grade);
        System.out.println();
	}

}
