package ClassicDP.LCS;

public class RegexMatching {
	//https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
	/*
	 *
	 * 
	 * 1, If p.charAt(j-1) == s.charAt(i-1) : dp[i][j] = dp[i-1][j-1]; 2, If
	 * p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]; 3, If p.charAt(j) == '*': here
	 * are two sub conditions: 1 if p.charAt(j-2) != s.charAt(i-1)
	 * &&p.charAt(i-2)!='.': dp[i][j] = dp[i][j-2] //in this case, a* only counts as
	 * empty 2 if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.': dp[i][j] =
	 * dp[i-1][j] //in this case, a* counts as multiple a or dp[i][j] = dp[i][j-1]
	 * // in this case, a* counts as single a or dp[i][j] = dp[i][j-2] // in this
	 * case, a* counts as empty
	 *
	 */
	public static void solve(String str, String pattern) {
		int n = str.length();
		int m = pattern.length();
		boolean dp[][] = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		for (int i = 2; i <= pattern.length(); i++) {
			 if (pattern.charAt(i - 1) == '*') {
	                if (dp[0][i - 1] || (i> 1 && dp[0][i - 2])) {
	                	dp[0][i] = true;
	                }
	            } 
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				char curS = str.charAt(i - 1);
				char curP = pattern.charAt(j - 1);
				if (curS == curP || curP == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (curP == '*') {
					char preCurP = pattern.charAt(j - 2);
					if (preCurP != curS && preCurP != '.') {
						dp[i][j] = dp[i][j - 2];
					} else {
						dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
					}
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
