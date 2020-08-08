package LeetCode;

import java.util.Arrays;

public class LeetCode62 {
	public int uniquePaths(int m, int n) {

		dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return dfs(n, m, 0, 0);
	}

	static int dp[][] = null;

	public int dfs(int n, int m, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m) {
			return 0;
		}
		if (i == n - 1 && j == m - 1) {
			return 1;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		return dp[i][j] = dfs(n, m, i + 1, j) + dfs(n, m, i, j + 1);

	}
}
