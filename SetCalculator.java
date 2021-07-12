import textio.TextIO;
import java.util.TreeSet;


/**
 * A simple setcalculator program that computes set operations such as union, intersection and difference.

 */


public class SetCalculator {

   public static void main(String[] args) {

      System.out.println("Please enter integers to compute set calculations for union, intersection and difference:");
      System.out.println("Make sure to include " + "'[' to begin a set" +" and"+ " ']' to end set"+" for set when entering integers. (press return to end)"  );
      while (true) {
         char ch;
         System.out.print("\n? ");
         TextIO.skipBlanks();// omit any blankspaces
         if (TextIO.peek() == '\n') {
               //if input is empty exit the loop
            break;
         }
         try {
            calculator(); 
         }
         catch (IllegalArgumentException e) {
            System.out.println("Error in input: " + e.getMessage());
         }
         TextIO.getln();  
      }

   } 


   /**
    * outputs the set calculations
    */
   private static void calculator() {

      TreeSet<Integer> A, B;  // The two sets of integers.
      char op;                // The operator, +, *, or -.

      A = readInput(); // Read the first set.

      TextIO.skipBlanks();
      if (TextIO.peek() != '*' && TextIO.peek() != '+' 
                                         && TextIO.peek() != '-')
         throw new IllegalArgumentException(
         "Please only enter *, +, or  - for second set.");
      op = TextIO.getAnyChar(); 

      B = readInput(); 

      TextIO.skipBlanks();
      if (TextIO.peek() != '\n')
         throw new IllegalArgumentException("Extra unexpected input.");

      //performing operations

      if (op == '+')
         A.addAll(B);     // union
      else if (op == '*')
         A.retainAll(B);  // intersection
      else
         A.removeAll(B);  // difference
      
      System.out.print("Value:  " + A);

   } 


   /**
    * method to read integers from input and storing it into TreeSet.
    */
   private static TreeSet<Integer> readInput() {

      TreeSet<Integer> set = new TreeSet<Integer>();

      TextIO.skipBlanks();
      if (TextIO.peek() != '[')
         throw new IllegalArgumentException("Expected '[' at start of set.");
      TextIO.getAnyChar(); 

      TextIO.skipBlanks();
      if (TextIO.peek() == ']') {
            // set has no values so return the set
         TextIO.getAnyChar(); 
         return set;
      }

      while (true) {
            
         TextIO.skipBlanks();
         if (! Character.isDigit(TextIO.peek()))
            throw new IllegalArgumentException("Please only positive integer are allowed.");
         int n = TextIO.getInt(); 
         set.add(n);  
         TextIO.skipBlanks();
         if (TextIO.peek() == ']')
            break;  // ']' marks the end of the set.
         else if (TextIO.peek() == ',')
            TextIO.getAnyChar(); // continue.
         else
            throw new IllegalArgumentException("Expected ',' or ']'.");
      }

      TextIO.getAnyChar(); // Read the ']' that ended the set.

      return set;

   } 


} 
/* Please enter integers to compute set calculations for union, intersection and difference:
Make sure to include '[' to begin a set and ']' to end set for set when entering integers. (press return to end)

? [1,2,3] * [2,3,4]
Value:  [2, 3]
? {1,2}
Error in input: Expected '[' at start of set.

? [-1,0,4] + [1,2,3]
Error in input: Please only positive integer are allowed.

? */