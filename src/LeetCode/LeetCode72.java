package LeetCode;

import java.util.Arrays;

public class LeetCode72 {
	static int dp[][] = null;

	public static int minDistance(String word1, String word2) {
		dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i < word1.length() + 1; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		return util(word1, word2, word1.length(), word2.length());
	}

	public static int util(String word1, String word2, int n, int m) {
		if (n == 0)
			return m;
		if (m == 0)
			return n;
		if (dp[n][m] != Integer.MAX_VALUE) {
			return dp[n][m];
		}
		if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
			dp[n][m] = 1 + util(word1, word2, n - 1, m - 1);
			return dp[n][m];
		}
		int insert = util(word1, word2, n, m - 1);
		int delete = util(word1, word2, n - 1, m);
		int replace = util(word1, word2, n - 1, m - 1);
		return dp[n][m] = Math.min(insert, Math.min(delete, replace));

	}

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "rose"));
	}
}
