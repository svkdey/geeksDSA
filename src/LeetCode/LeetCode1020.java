package LeetCode;

public class LeetCode1020 {
	

	public int numEnclaves(int[][] A) {
		int ans = 0;
		int n = A.length;
		int m = A[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i * j == 0 || i == n - 1 || j == m - 1) {
					dfs(A, n, m, i, j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1) {
					ans++;
				}
			}
		}
		return ans;
	}

	private void dfs(int grid[][], int n, int m, int i, int j) {

		if (i < 0 || i >= n || j < 0 || j >= m) {
			return;
		}
		if (grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		dfs(grid, n, m, i - 1, j);
		dfs(grid, n, m, i + 1, j);
		dfs(grid, n, m, i, j + 1);
		dfs(grid, n, m, i, j - 1);

	}
}
