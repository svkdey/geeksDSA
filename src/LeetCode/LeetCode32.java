package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode32 {

	public int longestValidParentheses(String str) {
		char arr[] = str.toCharArray();
		Stack<Integer> s = new Stack<>();
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				s.push(i);
			} else {
				if (!s.isEmpty() && arr[s.peek()] == '(') {
					s.pop();
					int len = s.isEmpty() ? i + 1 : i - s.peek();
					ans = Math.max(ans, len);
				} else {
					s.push(i);
				}
			}
		}
		return ans;
	}
	//()(()) => [0,2,0,0,2,6]
	public int longestValidParentheses2(String s) {
		int[] dp = new int[s.length()];
		int result = 0;
		int leftCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftCount++;
			} else if (leftCount > 0) {
				dp[i] = dp[i - 1] + 2;
				dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
				result = Math.max(result, dp[i]);
				leftCount--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode32 s = new LeetCode32();
		System.out.println(s.longestValidParentheses(")()())()"));
	}

}
