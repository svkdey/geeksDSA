package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode409 {
	public int longestPalindrome(String s) {
		char str[] = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		boolean oddPresent = false;
		int ans = 0;

		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if (m.getValue() % 2 == 1) {
				oddPresent=true;
			}
			ans+=m.getValue()/2;
		}
		return oddPresent?(2*ans+1) :(2*ans);

	}
}
