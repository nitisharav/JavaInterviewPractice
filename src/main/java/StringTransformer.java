import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StringTransformer {

	
	public static String transformStringUsingStream(String input) {
		if(input ==null || input.isEmpty()) {
			return input;
		}
		String lowerCaseInput= input.toLowerCase();
		return Arrays.stream(lowerCaseInput.split(" ")).map(word-> removeDuplicateLetters(word)).map(reverseword-> new StringBuilder(reverseword).reverse().toString()).collect(Collectors.joining(" "));
		
	}
	public static String transformString(String input) {
		if (input== null || input.isEmpty()) {
			return input;
		}
		//convert to lowercase
		String lowerCaseInput= input.toLowerCase();
		//split the words on space
		String[] words = lowerCaseInput.split(" ");
		
		StringBuilder transformedString = new StringBuilder();
		
		for(String word: words) {
			
			//step 1 - remove duplicate
			String removedDuplicate= removeDuplicateLetters(word);
			//step 2- reverse the word
			String reversedWord = new StringBuilder(removedDuplicate).reverse().toString();
			
			//step 3- join to form string
			transformedString.append(reversedWord).append(" ");
			
		}
		//step 4- remove trailling spaces
		return transformedString.toString().trim();
		
		//return transformedString.toString().trim();)
	}



	private static String removeDuplicateLetters(String word) {
		//use linked hashset to remove duplicate and also maintain insertion order
		Set<Character> set= new LinkedHashSet();
		StringBuilder result= new StringBuilder();
		char[] letters= word.toCharArray();
		for(char c:letters) {
			if(set.add(c)) {// set.add(c) return true if char is added
				result.append(c);
			};
		}
		//
		return result.toString();
	}
	
	 public static void main(String[] args) {
	        String test1 = "Hello World";
	        System.out.println("Original: '" + test1 + "'");
	        System.out.println("Transformed: '" + transformStringUsingStream(test1) + "'"); // Expected: 'oleh dlorw'

	        String test2 = "Programming is Fun";
	        System.out.println("\nOriginal: '" + test2 + "'");
	        System.out.println("Transformed: '" + transformString(test2) + "'"); // Expected: 'gnimmrapo si nuf'

	        String test3 = "AaBbCcAABBCc";
	        System.out.println("\nOriginal: '" + test3 + "'");
	        System.out.println("Transformed: '" + transformString(test3) + "'"); // Expected: 'cbabccba' (due to lowercase)

	        String test4 = "";
	        System.out.println("\nOriginal: '" + test4 + "'");
	        System.out.println("Transformed: '" + transformString(test4) + "'"); // Expected: ''

	        String test5 = "SingleWord";
	        System.out.println("\nOriginal: '" + test5 + "'");
	        System.out.println("Transformed: '" + transformString(test5) + "'"); // Expected: 'drowelgnis'
	    }
}
