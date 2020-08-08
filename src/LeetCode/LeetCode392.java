package LeetCode;

import java.util.Arrays;

public class LeetCode392 {
	public boolean isSubsequence(String s, String t) {
		int lenS = s.length();
		int lenT = t.length();
		dp = new int[lenS + 1][lenT + 1];
		for(int i=0;i<=lenS;i++) {
			Arrays.fill(dp[i], -1);
		}
		boolean res = false;
		if (lenS > lenT) {
			res = (lenT == isSubsequenceImpl(s, t, lenS, lenT));
		} else {
			res = (lenS == isSubsequenceImpl(s, t, lenS, lenT));
		}
//		for(int i=0;i<=lenS;i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		return res;
	}

	static int dp[][] = null;

	public int isSubsequenceImpl(String s, String t, int n, int m) {
		if (n == 0) {
			return 0;
		}
		if (m == 0) {
			return 0;
		}
		if (dp[n][m] != -1) {
			return dp[n][m];
		}
		if (s.charAt(n - 1) == t.charAt(m - 1)) {
			dp[n][m] = 1 + isSubsequenceImpl(s, t, n - 1, m - 1);
		} else {
			dp[n][m] = Math.max(isSubsequenceImpl(s, t, n - 1, m), isSubsequenceImpl(s, t, n, m - 1));
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		String s = "bb", t = "ahbgdc";
		LeetCode392 sol = new LeetCode392();
		System.out.println(sol.isSubsequence(s, t));
	}
}
