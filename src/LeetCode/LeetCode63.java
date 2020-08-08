package LeetCode;

import java.util.Arrays;

public class LeetCode63 {
	public int uniquePathsWithObstacles(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return dfs(grid, n, m, 0, 0);
	}

	static int dp[][] = null;

	public int dfs(int grid[][],int n, int m, int i, int j) {
			if (i < 0 || i >= n || j < 0 || j >= m||grid[i][j]==1) {
				return 0;
			}
			if (i == n - 1 && j == m - 1) {
				return 1;
			}
			if (dp[i][j] != -1) {
				return dp[i][j];
			}
			return dp[i][j] = dfs(grid,n, m, i + 1, j) + dfs(grid,n, m, i, j + 1);

		}
}
