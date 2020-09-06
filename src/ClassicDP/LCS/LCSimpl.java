package ClassicDP.LCS;

import java.util.Arrays;

public class LCSimpl {
	static int memo[][] = null;

	public static int lcsimpl(String s1, String s2) {
		memo = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		util(s1, s2, s1.length(), s2.length());
		return memo[s1.length()][s2.length()];
	}

	public static int util(String a, String b, int m, int n) {

		if (m == 0 || n == 0)
			return 0;
		if (memo[m][n] != -1) {
			return memo[m][n];
		}

		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			memo[m][n] = 1 + util(a, b, m - 1, n - 1);
			return memo[m][n];
		}

		memo[m][n] = Math.max(util(a, b, m - 1, n), util(a, b, m, n - 1));
		return memo[m][n];

	}

	public static int bottomUP(String s1, String s2) {

		memo = new int[s1.length() + 1][s2.length() + 1];

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

	public static void main(String[] args) {
		String s1 = "12321";
		String s2 = "32147";

		System.out.println(lcsimpl(s1, s2));

	}
}
