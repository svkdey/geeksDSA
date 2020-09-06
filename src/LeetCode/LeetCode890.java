package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode890 {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		ArrayList<String> ans=new ArrayList<String>();
		for(String word:words) {
	
			if(isPatternMatchs(word, pattern)) {
				ans.add(word);
			}
		}
		return ans;
	}

	public boolean isPatternMatchs(String word, String pattern) {
		if (word.length() != pattern.length())
			return false;
		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for (int i = 0; i < word.length(); i++) {
			if (map.containsKey(word.charAt(i))) {
				if (map.get(word.charAt(i)) != pattern.charAt(i)) {
					return false;
				}
			} else if (map.containsValue(pattern.charAt(i))) {
				return false;
			} else {
				map.put(map.get(word.charAt(i)), pattern.charAt(i));
			}
		}

		return true;
	}
}
