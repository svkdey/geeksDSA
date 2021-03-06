package LeetCode;

import java.util.Arrays;

public class LeetCode1092 {
	static int dp[][] = null;

	public static String shortestCommonSupersequence(String str1, String str2) {

		int n = str1.length();
		int m = str2.length();
		dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		int lis = util(str1, str2, n, m);

		int sseqLen = n + m - lis;
		for (int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
//		String ans=printLCS(str1, str2, n, m);
		String ans = printSCS(str1, str2, n, m, sseqLen);
		System.out.println(ans);
		return ans;

	}

	public static int util(String a, String b, int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (dp[n][m] != -1) {
			return dp[n][m];
		}
		if (a.charAt(n - 1) == b.charAt(m - 1)) {
			dp[n][m] = 1 + util(a, b, n - 1, m - 1);
		} else
			dp[n][m] = Math.max(util(a, b, n - 1, m), util(a, b, n, m - 1));
		return dp[n][m];
	}

	public static String printLCS(String a, String b, int n, int m) {
		int i = n, j = m;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				sb.append(a.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j] ) {
					j--;
				} else {
					
					i--;
				}
			}
		}
		return sb.reverse().toString();
	}

	public static String printSCS(String a, String b, int n, int m, int k) {
		int i = n, j = m;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				sb.append(a.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j] ) {
					sb.append(b.charAt(j - 1));
					j--;
				} else {
					sb.append(a.charAt(i - 1));
					i--;
				}
			}
		}
		while (i > 0) {
			sb.append(a.charAt(i - 1));
			i--;
		}
		while (j > 0) {
			sb.append(b.charAt(j - 1));
			j--;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(shortestCommonSupersequence("abac", "cab"));
	}
}
/*
 * abcd bcd
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
