import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

/**
 * This class works as spell-checker, uses words.txt file to check whether a word is correctley spelled
 *
 */
public class SpellChecker {

	public static void main(String[] args) throws FileNotFoundException{
		try {
			// reading words.txt file
			Scanner filein = new Scanner(new File("C:\\Users\\omish\\Downloads\\words.txt"));
			// hash set data structure to store words
			HashSet<String> hash = new HashSet<String>();
			
			while (filein.hasNext()) {
				String tk = filein.next();
				hash.add(tk.toLowerCase());
			}
			
			
			// getting name of word file from user
			Scanner userFileIn = new Scanner(getInputFileNameFromUser());
			// eliminating any characters that are not letters
			userFileIn.useDelimiter("[^a-zA-Z]+");
			
			
			while (userFileIn.hasNext()) {
				String userWord = userFileIn.next();
				
				userWord = userWord.toLowerCase();
				if(!hash.contains(userWord)) {
					// calling method corrections on words that doesn't exist in hash dictionary
					System.out.println(userWord + ":" + corrections(userWord, hash));
				}
				
			}
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
	

	}
	/* Method to store variations in TreeSet and returns possible variations on misspelled words
	 */
	static TreeSet corrections(String badWord, HashSet<String> dictionary) {
		TreeSet<String> tree = new TreeSet<String>();
		// delete any letters of misspelled words and then check if the word exists in dictionary
		for(int i = 0; i <badWord.length(); i++) {
			String str = badWord.substring(0,i) + badWord.substring(i+1);
			if(dictionary.contains(str)) {
				tree.add(str);
			}
		}
		// change any letter from misspelled word to different letter and check if it exists in dictionary
		for(int i = 0; i <badWord.length(); i++) {
			for(char ch = 'a'; ch <= 'z'; ch++) {
				String str =  badWord.substring(0,i) + ch + badWord.substring(i+1);
				if(dictionary.contains(str)) {
					tree.add(str);
				}
			}
		}
		//insert any letter at any point in misspelled word and check if it exists in dictionary
		for(int i = 0; i <=badWord.length(); i++) {
			for(char ch = 'a'; ch <= 'z'; ch++) {
				String str =  badWord.substring(0,i) + ch + badWord.substring(i);
				if(dictionary.contains(str)) {
					tree.add(str);
				}
			}
		}
		//swap any two neighboring letters in misspelled word then check if it exits in dictionary
		for(int i = 1; i < badWord.length(); i++) {
			String str =  badWord.substring(0,i)+badWord.substring(i+1, i+2) + badWord.substring(i, i+1) + badWord.substring(i+2);
			if(dictionary.contains(str)) {
				tree.add(str);
			}
		}
		//Insert a space at any point in the misspelled word (and check that both of the words that are produced are in the dictionary)
		for(int i = 0; i <badWord.length();i++) {
			String input =  badWord.substring(0,i) + " "+ badWord.substring(i);
			
			String temp = "";
			// break input string into tokens and add to tempwords by using Java's string tokenizer class
			StringTokenizer tempWords =  new StringTokenizer(input);
			while (tempWords.hasMoreTokens()) {
				// store each word in temp string
				String temp1 = tempWords.nextToken();
				String temp2 = tempWords.nextToken();
				// check if both temp1 and temp2 exists in dictionary if yes then add to tree otherwise break
				if(dictionary.contains(temp1) && dictionary.contains(temp2)) {
					temp = temp1 + " " + temp2;
				}
				else {
					break;
				}
				tree.add(temp);
			}
		}
		if(tree.isEmpty()) {
			tree.add("no suggestons");
		}
		return tree;
	}
	/**
     * Lets the user select an input file using a standard file
     * selection dialog box.  If the user cancels the dialog
     * without selecting a file, the return value is null.
     */
    static File getInputFileNameFromUser() {
       JFileChooser fileDialog = new JFileChooser();
       fileDialog.setDialogTitle("Select File for Input");
       int option = fileDialog.showOpenDialog(null);
       if (option != JFileChooser.APPROVE_OPTION)
          return null;
       else
          return fileDialog.getSelectedFile();
	
	

}
}
