package LeetCode.InterviewPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	static String[] pad = { "", "", "abc", "def", "ghi", "jkl", "mno", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {

		List<String> ans = new ArrayList<String>();
		util(digits, 0, digits.length(), ans, new ArrayList<Character>());
		return ans;

	}

	public void util(String digits, int i, int n, List<String> s, ArrayList<Character> l) {
		if (n == i) {
			  StringBuilder sb=new StringBuilder();
	            for(char x:l){
	                sb.append(x);
	            }
	            s.add(sb.toString());
	            return;
		}

		int digit = digits.charAt(i) - '0';
		if (digit == 0 || digit == 1) {
			util(digits, i + 1, n, s, l);
		}
		char arr[]=pad[digit].toCharArray();
		for (int j=0;j<arr.length;j++) {
			l.add(arr[j]);
			util(digits, i + 1, n, s, l);
			l.remove(l.size() - 1);
		}

	}
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber phone=new LetterCombinationsofaPhoneNumber();
		phone.letterCombinations("23");
	}
}
