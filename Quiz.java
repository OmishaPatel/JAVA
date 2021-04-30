public class Quiz {

	public static void main(String[] args) {
		MultipleChoiceQuestion question = new MultipleChoiceQuestion(
				"What is the name of German Airline?",
				 "Delta",
				 "United",
				 "Luftansa",
				 "Kingfisher",
				 "Avianca",
				 "c");
		question.check();
		 //resetting the reference value of question variable by creating new object
		question = new MultipleChoiceQuestion(
				"What is the capital city of Chile?",
				 "Santiago",
				 "Santa Marta",
				 "San Andres",
				 "Buenos Aires",
				 "Bogota",
				 "a");
		question.check();
		
		question = new MultipleChoiceQuestion(
				"What country has the most islands in the world?",
				 "Norway",
				 "Sweden",
				 "USA",
				 "Poland",
				 "Spain",
				 "b");
		question.check();
		
		question = new MultipleChoiceQuestion(
				"How many teeth does a adult human have?",
				 "30",
				 "34",
				 "28",
				 "32",
				 "31",
				 "d");
		question.check();
		
		question = new MultipleChoiceQuestion(
				"Which is the biggest state in USA?",
				 "Texas",
				 "New York",
				 "California",
				 "Arizona",
				 "Alaska",
				 "e");
		question.check();
		
		MultipleChoiceQuestion.showResults();
		
			}
	
}
