package stringDSA;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class StringDSAMain {
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int[] count = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			count[(int) str1.charAt(i)]++;
		}
		for (int i = 0; i < str2.length(); i++) {
			count[(int) str2.charAt(i)]--;
		}

		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean leftRepeatingCharacter(String str1) {

		int[] count = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			if (count[(int) str1.charAt(i)] != 1) {
				count[(int) str1.charAt(i)]++;
			} else {
				System.out.println(str1.charAt(i));
				return true;
			}

		}

		return false;
	}

	public static boolean leftRepeatingCharacterThatDoesNotReapeat(String str1) {

		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			if (hm.containsKey(str1.charAt(i))) {
				hm.put(str1.charAt(i), hm.get(str1.charAt(i)) + 1);
			} else {
				hm.put(str1.charAt(i), 1);
			}
		}
		System.out.println(hm);
		for (Entry<Character, Integer> e : hm.entrySet()) {
			if (e.getValue() == 1) {
				System.out.println(e.getKey());
				return true;
			}
		}
		return false;
	}

	public static int leftRepeatingCharacterThatDoesNotReapeatSolTwo(String str1) {
		int[] count = new int[256];
		Arrays.fill(count, -1);
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < str1.length(); i++) {
			if (count[(int) str1.charAt(i)] == -1) {
				count[(int) str1.charAt(i)] = i;
			} else {
				count[(int) str1.charAt(i)] = -2;
			}
		}
		System.out.println(count);
		for (int i = 0; i < 256; i++) {
			if (count[i] >= 0) {
				result = Math.min(result, count[i]);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(isAnagram("geeks", "kegse"));
		System.out.println(leftRepeatingCharacterThatDoesNotReapeat("feggs"));
	}

}
