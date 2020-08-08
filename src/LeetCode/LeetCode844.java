package LeetCode;

import java.util.Stack;

public class LeetCode844 {
	public boolean backspaceCompare(String S, String T) {
		String s1 = getString(S);
		String s2 = getString(T);
		System.out.println(s1+ "   "+s2);
		return s1.equals(s2);
	}

	public String getString(String s) {
		String ans = "";
		char c[] = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char x : c) {
			if (x == '#') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(x);
			}
		}
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		LeetCode844 s = new LeetCode844();
		String S = "a#c";
		String T = "b";
		System.out.println(s.backspaceCompare(S, T));
	}
}