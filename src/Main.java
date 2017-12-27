import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static String S = "abppplee";
	static String[] D = { "able", "ale", "apple", "bale", "kangaroo" };

	public static void main(String[] args) {
		MyComparator comp = new MyComparator();
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			if (checkWord(D[i]))
				words.add(D[i]);
		}
		Collections.sort(words, comp);
		System.out.println(words.get(words.size() - 1));

	}

	public static ArrayList<Character> StoQueue(String S) {
		ArrayList<Character> chars = new ArrayList<>();

		for (int i = 0; i < S.length(); i++) {
			chars.add(S.charAt(i));
		}

		return chars;
	}

	public static boolean checkWord(String w) {

		ArrayList<Character> c = StoQueue(S);

		for (int i = 0; i < w.length(); i++) {
			for (int j = 0; j < c.size(); j++) {
				if (!c.contains(w.charAt(i)))
					return false;
				else if (w.charAt(i) == c.get(j)) {
					for (int k = 0; k < j + 1; k++) {
						if (k >= c.size())
							break;
						c.remove(k);
					}
					j = c.size();
				}

			}
		}
		return true;
	}

}
