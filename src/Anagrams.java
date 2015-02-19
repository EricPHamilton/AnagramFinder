import java.util.ArrayList;
import java.util.Arrays;

/**
*  This class contains the tools to find anagrams in a given list.
* @author Eric Hamilton
* @version 1.0
* @date 2/19/2015
*/

public class Anagrams {
	
	/**
	 * This method finds all anagrams in a given array of words by:
	 * 	- Taking in all words from the array and converting them into Word objects
	 *  	- While the Word objects are created, the Word is sorted alphabetically.
	 *  		- ex: "animal" --> "aailmn"
	 *  
	 * 	- Stores all words into an ArrayList of Words
	 * 
	 *  - Sorts the words in the list alphabetically
	 *  
	 *  - Using this method, all anagrams will be next to each other in the list in 
	 *    their alphabetical form. Therefore, in order to find all anagrams, traverse 
	 *    the list and look for adjacent, equal Strings in the list.
	 *    
	 *  - If an anagram is found, the alphabetical string is then paired with its real word,
	 *    and finally added to the list.
	 * 
	 * @param  words  A list(String array) of words to be tested for anagrams
	 * @return       An array list of Strings containing a pair of words found to be anagrams
	 */
	private static ArrayList<String> findAnagrams(String[] words) {

		ArrayList<String> anagrams = new ArrayList<String>();
		
		/**
		 * Converts String[] words into an ArrayList, with each
		 * Word object containing its word, and its alphabetical form.
		 */
		for (int i = 0 ; i < words.length ; i++) {
			char[] charArr = words[i].toCharArray();
			Arrays.sort(charArr);
			Word.wordsList.add(new Word(words[i], new String(charArr)));
		}

		Word.sortList();
		
		for (int i = 0 ; i < Word.wordsList.size() - 1 ; i++) {
			String s1 = Word.wordsList.get(i).sorted;
			String s2 = Word.wordsList.get(i+1).sorted;

			if (s1.equals(s2)) {
				anagrams.add("[" + Word.wordsList.get(i).word + ", " + Word.wordsList.get(i+1).word + "]");
				
				/**
				 * This portion handles the case in which there are multiple
				 * anagrams (> 2) in a row. If this is the case, this portion
				 * will correctly add all combinations to the list.
				 */
				int ctr = i;
				while (ctr+2 < Word.wordsList.size() && s1.equals(Word.wordsList.get(ctr+2).sorted)) {
					anagrams.add("[" + Word.wordsList.get(i).word + ", " + Word.wordsList.get(ctr+2).word + "]");
					ctr++;
				}
				
			}
		}
		
		return anagrams;
		
	}
}


