package LeetCode;

import java.util.Stack;

public class LeetCode1021 {
	public static String removeOuterParentheses(String S) {
		Stack<Character> stack = new Stack<>();
		int openCount = 0;
		String ans = "";
		char[] carr = S.toCharArray();
		for (int i = 0; i < carr.length; i++) {
			if (carr[i] == '(') {
				openCount++;
			} else {
				openCount--;
			}
			if (openCount == 0) {
				stack.push(carr[i]);
				StringBuilder sb = new StringBuilder();
				for (Character c:stack) {
					sb.append(c);
				}
				stack=new Stack<Character>();
			
				int len = sb.toString().length();
				String subStr = len > 2 ? sb.toString().substring(1, len - 1) : "";
				

				ans += subStr;

			} else {
				stack.push(carr[i]);
			}
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		String s="()()";
		removeOuterParentheses(s);
	}
}
