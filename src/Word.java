import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
*  Representation of a word, containing its original form, and its scrambled form.
* @author Eric Hamilton
* @version 1.0
* @date 2/19/2015
*/
public class Word {
	public static ArrayList<Word> wordsList = new ArrayList<Word>();
	public String word;
	public String sorted;
	
	public Word (String word, String sorted) {
		this.word = word;
		this.sorted = sorted;
	}
	
	public String toString() {
		return "(" + word + ", " + sorted + ")";
	}
	
	/**
	 * Sorts the list in alphabetical order (according to the scrambled form)
	 */
	public static void sortList() {
		Collections.sort(wordsList, new Comparator<Word>() {
			@Override
			public int compare(Word w1, Word w2) {
				return w1.sorted.compareTo(w2.sorted);
			}
		});
	}
}
