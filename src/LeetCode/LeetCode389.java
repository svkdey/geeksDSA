package LeetCode;

import java.util.HashMap;

public class LeetCode389 {
	public char findTheDifference(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> set = new HashMap<>();
		for (char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		for (char x : s.toCharArray()) {
			set.put(x, set.getOrDefault(x, 0) + 1);
		}
		for(char x : t.toCharArray()) {
			if(map.containsKey(x)) {
				if(set.get(x)>map.get(x)) {
					return x;
				}
			}else {
				return x;
			}
		}
		return 'a'-'a';
		
	}
}
