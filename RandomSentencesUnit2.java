
public class RandomSentencesUnit2 {

	static final String[] conjunction = {"and", "or", "but", "because"};
	static final String[] proper_noun = {"Fred", "Jane","Richard Nixon", "Miss America"};
	static final String[] common_noun = {"man", "woman", "fish", "elephant","unicorn"};
	static final String[] determiner = {"a", "the", "every","some"};
	static final String[] adjective = {"big", "tiny", "pretty","bald"};
	static final String[] intrasitive_verb = {"runs","jumps","talks","sleeps"};
	static final String[] transitive_verb = {"loves", "hates","sees","knows","looks for","finds"};
	
	// main method that continously generates sentences
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			randomSentence();
			System.out.println(".\n");
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				
			}
		}
	}
	
	// method to generate random sentence that follows rule of grammer
	static void randomSentence() {
		randomNounPhrase();
		randomVerbPhrase();
		
		if(Math.random() > 0.75) {
			System.out.print(" "+ randomItem(conjunction));
			randomSentence();
		}
	}
	
	// method that generates noun_phrase 
	
	static void randomNounPhrase() {
		if(Math.random() > 0.75) {// 25%  chance of having propernoun
			System.out.print(" "+ randomItem(proper_noun));
		}else { 
			System.out.print(" "+ randomItem(determiner));
			
			if(Math.random() > 0.5) { // 50% chance of having adjective and common noun
				System.out.print(" "+ randomItem(adjective)+".");
				System.out.print(" "+ randomItem(common_noun));
				if(Math.random() > 0.5 ) {
					System.out.print(" who ");
					randomVerbPhrase();
				}
			}
		} 
	}
	
	// method that generates verb_phrase
	static void randomVerbPhrase() {
		if(Math.random() > 0.75) {
			System.out.print(" " + randomItem(intrasitive_verb));
			
		}else if (Math.random() > 0.5 ){
			System.out.print(" " + randomItem(transitive_verb));
			randomNounPhrase();
		}else if (Math.random() > 0.25 ){
			System.out.print(" " + randomItem(adjective));
		}else {
			System.out.print(" believes that ");
			randomNounPhrase();
			randomVerbPhrase();
		}
	}
	//method to randomly pick one string from the list of strings
	static String randomItem(String[] listOfStrings) {
		return listOfStrings[(int)(Math.random()*listOfStrings.length)];
	}

}

/*
 * the big or every bald. woman who  tiny jumps.

 Jane sees Miss America.

 Miss America finds Richard Nixon.

 Miss America sleeps.

 some tiny. elephant who  pretty bald.

 the knows some.

 a bald.

 some pretty.

 Richard Nixon big.

 */
