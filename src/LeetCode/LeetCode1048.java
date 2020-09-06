package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LeetCode1048 {
	public static int longestStrChain(String[] words) {
		Comparator<String> rule = (a, b) -> {
			if (a.length() == b.length()) {
				return a.compareTo(b);
			} else {
				return a.length() - b.length();
			}
		};
		Arrays.sort(words, rule);
		int ans = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, 1);

			for (int i = 0; i < word.length(); i++) {
				StringBuilder sb = new StringBuilder(word);
				String subString = sb.deleteCharAt(i).toString();
				if (map.containsKey(subString)) {
					int subVal = map.get(subString);
					int wordVal = map.get(word);
					map.put(word, Math.max(subVal + 1, wordVal));
				}
			}
			ans = Math.max(ans, map.get(word));
		}
		return ans;
	}

	public static void main(String[] args) {
		String words[] = { "a","b","ba","bca","bda","bdca" };
		System.out.println(longestStrChain(words));
	}
}
