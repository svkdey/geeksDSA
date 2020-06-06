package Algorithms.DynamicProblems;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
	
	public static void longestRepeatingSubsequence(String str) {
		// the problem is same as LCS but slight modification
		int n=str.length();
		int dp[][]=new int[n+1][n+1];
		for(int i=0;i<=n;i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(LCShelper(str, str.length(),str.length(), dp));
	}

	public static int LCShelper(String str, int n, int m, int dp[][]) {
		// the problem is same as LCS but slight modification
		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		if (m == 0 || n == 0) {
			return 0;
		}
		if (str.charAt(m-1) == str.charAt(n-1) && m != n) {//we check only if the matching is happeing in diffindex
			dp[m][n] = 1 + LCShelper(str, n - 1, m - 1, dp);
		} else {
			dp[m][n] = Math.max(LCShelper(str, n - 1, m, dp), LCShelper(str, n, m - 1, dp));
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestRepeatingSubsequence("aabbcccD");
	}

}
