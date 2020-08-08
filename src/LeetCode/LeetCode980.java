package LeetCode;

import java.util.Arrays;

public class LeetCode980 {
	public int uniquePathsIII(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		
		v = new boolean[n ][m ];
		
		int i = -1;
		int j = -1;
		int zero = 0;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
			
				if (grid[x][y] == 0) {
					zero++;
				}
				else if (grid[x][y] == 1) {
					i = x;
					j = y;
					zero++;
				}
			}
		}

		dfs(grid, i, j, zero, v);
		for (int x = 0; x < n; x++) {
			System.out.println(Arrays.toString(v[i]));
		}
		
		return ans;
	}

	static int dp[][] = null;
	static boolean v[][] = null;
	static int ans = 0;

	public void dfs(int[][] grid, int i, int j, int n, boolean[][] vis) {
		if (grid[i][j] == 2) {
			if (n == 0)
				ans++;

			return;
		}

		vis[i][j] = true;

		if (isValid(i + 1, j, grid) && !vis[i + 1][j] && grid[i + 1][j] != -1)
			dfs(grid, i + 1, j, n - 1, vis);

		if (isValid(i - 1, j, grid) && !vis[i - 1][j] && grid[i - 1][j] != -1)
			dfs(grid, i - 1, j, n - 1, vis);

		if (isValid(i, j + 1, grid) && !vis[i][j + 1] && grid[i][j + 1] != -1)
			dfs(grid, i, j + 1, n - 1, vis);

		if (isValid(i, j - 1, grid) && !vis[i][j - 1] && grid[i][j - 1] != -1)
			dfs(grid, i, j - 1, n - 1, vis);

		vis[i][j] = false;
	}

	public boolean isValid(int i, int j, int[][] grid) {
		return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length);
	}

	

	public static void main(String[] args) {
		LeetCode980 solve = new LeetCode980();
		int grid[][] = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
		System.out.println(solve.uniquePathsIII(grid));
	}

}
