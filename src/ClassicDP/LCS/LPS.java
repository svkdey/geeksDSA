package ClassicDP.LCS;

import java.util.Arrays;

public class LPS {
	public static int bottomUP(String s1) {
		StringBuilder sb = new StringBuilder(s1);
		String s2 = sb.reverse().toString();
		int memo[][] = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];

				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		for (int i = 0; i <= s1.length(); i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
		System.out.println(printLCS(s1, s2, s1.length(), s2.length(), memo[s1.length()][s2.length()], memo));
		
		System.out.println(" number of deletion require to make string subsequence "
				+ (s1.length() - memo[s1.length()][s2.length()]));
		System.out.println(" number of insertion require to make string subsequence "
				+ (s1.length() - memo[s1.length()][s2.length()]));
		
		return memo[s1.length()][s2.length()];
	}

	public static String printLCS(String a, String b, int n, int m, int k, int dp[][]) {
		int i = n, j = m;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				sb.append(a.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {

					j--;
				} else {

					i--;
				}
			}
		}

		return sb.reverse().toString();
	}
}
