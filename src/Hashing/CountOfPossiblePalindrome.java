package Hashing;

import java.util.Hashtable;

public class CountOfPossiblePalindrome {

	public static String palindromeKN(String[] strs) {
		// Hashtable storing all possible palindrome endings
		Hashtable<String, String> possibleValues = new Hashtable<String, String>();

		for (int i = 0; i < strs.length; i++) {
			String candidate = strs[i];
			

			// Is our String one of the possible Endings?
			if (possibleValues.containsKey(candidate)) {
				return (possibleValues.get(candidate) + candidate);
			}
			
			
			// Create all possible endings that will lead to a palindrome
			// abcb => bcba, cba, a (go through reverse, cut off a letter and check for palindrome)
			String reverse = new StringBuilder(strs[i]).reverse().toString();
			for (int j = 0; j < reverse.length(); j++) {
				String subString = reverse.substring(j); // cut off first j letters
				if (possibleValues.containsKey(subString)) { // check if this substring is part of the possibilities
					String center = reverse.substring(0, j);
					if (isPalindrome(center)) { // if substring is a possibility, is the rest (what we cut off) also a palindrome?
						return (possibleValues.get(subString) + candidate);
					}
				}
				
				// if the substring is a possible suffix for our candidate add it to hash table
				if (isPalindrome(candidate + subString)) {
					possibleValues.put(subString, candidate);
				}
			}
		}
		return "";
	}
	
	public static boolean isPalindrome(String a) {
		int length = a.length();
		if (length <= 1)
			return true;
		
		for (int i = 0; i < length / 2; i++) {
			if (a.charAt(i) != a.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String s[]= {"abcd","dcba","ll","s","ssll"};
		System.out.println(palindromeKN(s));
	}

}
