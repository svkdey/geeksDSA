package stringDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class PatternSearch {
//	naive approach (O(n-m+1)*(o(m))
	public static void patternSearch(String txt, String ptr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < txt.length() - ptr.length() + 1; i++) {
			for (int j = 0; j < ptr.length(); j++) {
				if (txt.charAt(i + j) != ptr.charAt(j)) {
					break;
				}
				if (j == ptr.length() - 1) {
					System.out.println(i);
				}
			}

		}
	}
//	o(n) modified naive

	// if its said pattern is distinct and txt also
	public static void patternSearchIfNoCharacterIsRepeated(String txt, String ptr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < txt.length() - ptr.length() + 1;) {
			int j;
			for (j = 0; j < ptr.length(); j++) {

				if (txt.charAt(i + j) != ptr.charAt(j)) {
					break;
				}
			}
			if (j == ptr.length()) {
				System.out.println(i);
				i = i + ptr.length();

			} else if (j == 0) {
				i++;
			} else {
				i = i + j;
			}

		}
	}

	public static int countBinarySubstringinGivenString(int a, String str) {
		// Your code here
		int c = 0;
		for (int i = 0; i < a; i++) {
			if (str.charAt(i) == '1') {
				c++;
			}
		}
		return (c * (c - 1)) / 2;
	}

	public static void solution(String s1, String s2) {
		// Your code here

		int found = 0;
		for (int i = 0; i < s1.length(); i++) {
			String c = Character.toString(s1.charAt(i));
			if (s2.contains(c)) {
				found = 1;
				System.out.println(c);
				break;
			}
		}
		if (found == 0) {
			System.out.println("No character present");
		}

	}

	public static boolean checkPanagram(String s) {
		// your code here
		String str = s.toUpperCase();
		int count[] = new int[256];
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1) != " " || str.substring(i, i + 1) != ",") {
				count[(int) str.charAt(i)]++;
			}
		}
		for (int i = 65; i <= 90; i++) {
			if (count[i] == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean areIsomorphic(String s1, String s2) {
		// Your code here
		if (s1.length() != s2.length()) {
			return false;
		}
		int arr1[] = new int[256];
		int arr2[] = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			if (arr1[s1.charAt(i)] == 0 && arr2[s2.charAt(i)] == 0) {
				arr1[s1.charAt(i)] = s2.charAt(i);
				arr2[s2.charAt(i)] = s1.charAt(i);
			} else if (arr1[s1.charAt(i)] != s2.charAt(i) && arr2[s2.charAt(i)] != s1.charAt(i)) {
				return false;
			}

		}
		return true;

	}

	public static String concatenatedString(String s1, String s2) {
		boolean flag1[] = new boolean[26];

		// store all characters of s1 in map
		for (int i = 0; i < s1.length(); i++)
			flag1[s1.charAt(i) - 97] = true;

		// store all characters of s2 in map
		boolean flag2[] = new boolean[26];
		for (int i = 0; i < s2.length(); i++)
			flag2[s2.charAt(i) - 97] = true;

		// Find characters of s1 that are not
		// present in s2 and append to result
		String s = "";
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if (flag1[ch - 97] && !flag2[ch - 97])
				s = s + ch;
		}

		// Find characters of s2 that are not
		// present in s1.
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			if (flag2[ch - 97] && !flag1[ch - 97])
				s = s + ch;
		}

		if (s.length() == 0)
			return "-1";
		return s;
	}/*
		 * The Modified String Ishaan is playing with strings these days. He has found a
		 * new string. He wants to modify it as per the following rules :
		 * 
		 * The string should not have three consecutive same characters (Refer example
		 * for explanation). He can add any number of characters anywhere in the string.
		 * Find the minimum number of characters which Ishaan must insert in the string.
		 * Input: First line of input contains a single integer T denoting the number of
		 * test cases.The only line of each test case contains a string S consisting of
		 * lowercase English Alphabets.
		 * 
		 * Output: For each test case, in a new line, print the required answer in a new
		 * line.
		 * 
		 * Your Task: This is a function problem. You only need to complete the function
		 * modified that returns the answer.
		 * 
		 * Constraints : 1 <= T <= 100 1 <= Length of S <= 105
		 * 
		 * Example : Input : 3 aabbbcc aaaaa abcddee Output : 1 2 0
		 * 
		 * E
		 */

	public static long modified(String s) {

		long num = 0;
		for (int i = 0; i < s.length() - 2; i++) {
			char c = s.charAt(i);
			if ((c == s.charAt(i + 1)) && (c == s.charAt(i + 2))) {
				i++;
				num++;

			}
		}
		return num;
	}

	public static long findSum(String s) {
		String number = "";
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = (int) s.charAt(i);
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
				if (number != "") {
					sum += Integer.parseInt(number);
				}
				number = "";
			} else {
				number += s.charAt(i);

			}
		}
		if (number != "") {
			sum += Integer.parseInt(number);
		}
		System.out.println(sum);
		return sum;
		// your code here

	}

	/*
	 * Given a string S and text P. Output the smallest window in the string S
	 * having all characters of the text P. Both the string S and text P contains
	 * lowercase english alphabets.
	 * 
	 * Input: First line of the input contains an integer T, denoting the number of
	 * test cases. Then T test case follows. Each test contains 2 lines having a
	 * string S and next line contains text P.
	 * 
	 * Output: Output the smallest window of the string containing all the
	 * characters of the text. If such window doesn`t exist or this task can not be
	 * done then print -1.
	 * 
	 * Your Task: You only need to complete the function smallestWindow that returns
	 * smallest window of the string containing all the characters of the text. Else
	 * return "-1".
	 * 
	 * Constraints: 1 <= T <= 100 1 <= S.length, P.length <= 1000
	 * 
	 * Example: Input: 2 timetopractice toc zoomlazapzo oza Output: toprac apzo
	 * 
	 * Explanation: Testcase 1: toprac is the smallest subset in which toc can be
	 * found. Testcase 2: To find oza in the zoomlazapzo the smallest subset is
	 * apzo.
	 */
	
//	public static String smallestWindow(String s, String t){
//        // Your code here
//		if(t.length()>s.length()) return null;
//		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
//		
//		
//		
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		patternSearch("ABCEABCDABCEABCD", "ABCD");
//		System.out.println(areIsomorphic("rfkqyuqf", "jkxyqvnr"));
//		System.out.println(smallestWindow("timetopractice", "toc"));
//		System.out.println(smallestWindow("zoomlazapzo", "oza"));
	}

}
