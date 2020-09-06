package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode417 {
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		if (n == 0 || m == 0)
			return Collections.EMPTY_LIST;
		boolean pacific[][] = new boolean[n][m];
		boolean atlantic[][] = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			dfs(matrix, pacific, i, 0, n, m, Integer.MIN_VALUE);
			dfs(matrix, atlantic, i, m - 1, n, m, Integer.MIN_VALUE);
		}
		for (int i = 0; i < m; i++) {
			dfs(matrix, pacific, 0, i, n, m, Integer.MIN_VALUE);
			dfs(matrix, atlantic, n - 1, i, n, m, Integer.MIN_VALUE);
		}
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(i);
					l.add(j);
					ans.add(l);

				}
			}
		}
		return ans;

	}

	public void dfs(int[][] matrix, boolean v[][], int i, int j, int n, int m, int waterLevel) {
		if (i < 0 || i >= n || j < 0 || j >= m || v[i][j] || waterLevel > matrix[i][j]) {
			return;
		}
		v[i][j] = true;
		dfs(matrix, v, i + 1, j, n, m, matrix[i][j]);
		dfs(matrix, v, i - 1, j, n, m, matrix[i][j]);
		dfs(matrix, v, i, j + 1, n, m, matrix[i][j]);
		dfs(matrix, v, i, j - 1, n, m, matrix[i][j]);
	}
}
