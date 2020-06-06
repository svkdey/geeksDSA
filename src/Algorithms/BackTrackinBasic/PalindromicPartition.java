package Algorithms.BackTrackinBasic;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {
	public static List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), s, 0);
		return list;
	}

	private static void backtrack(List<List<String>> list, ArrayList<String> tempString, String s, int start) {
		if (s.length() == start) {
			list.add(new ArrayList<>(tempString));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (palindrome(s, start, i)) {
				tempString.add(s.substring(start, i + 1));
				backtrack(list, tempString, s, i + 1);
				tempString.remove(tempString.size() - 1);

			}
		}
	}

	private static boolean palindrome(String s, int i, int j) {
		while (j > i) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			j--;i++;

		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partition("aab"));
	}

}
