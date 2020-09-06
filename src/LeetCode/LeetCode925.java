package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LeetCode925 {
	public void applyMapping(String txt, HashMap<Character, Integer> map) {
		for (char c : txt.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
	}

	public boolean isLongPressedName(String name, String typed) {
		HashMap<Character, Integer> nameMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> typeMap = new HashMap<Character, Integer>();
		applyMapping(name, nameMap);
		applyMapping(typed, typeMap);

		for (char x : typeMap.keySet()) {
			if (nameMap.containsKey(x) && typeMap.get(x) >= nameMap.get(x)) {

			} else {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		LeetCode925 solve = new LeetCode925();
		System.out.println(solve.isLongPressedName("saeed", "ssaaedd"));
	}
}
