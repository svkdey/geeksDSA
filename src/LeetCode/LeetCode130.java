package LeetCode;

import java.util.Arrays;

public class LeetCode130 {
	public void solve(char[][] grid) {

		int n = grid.length;
		if (n == 0)
			return;
		int m = grid[0].length;
		if (m == 0)
			return;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
					if (grid[i][j] == 'O') {
					
						floodFill(grid, i, j, n, m);
					}
				}
			}
		}
		  
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'v') {
					grid[i][j] = 'O';
				} else {
					grid[i][j] = 'X';
				}
			}
		}

	}

	public void floodFill(char[][] grid, int i, int j, int n, int m) {
		if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 'X') {
			return;
		}
		grid[i][j] = 'v';
		floodFill(grid, i + 1, j, n, m);
		floodFill(grid, i - 1, j, n, m);
		floodFill(grid, i, j - 1, n, m);
		floodFill(grid, i, j + 1, n, m);
	}

}
