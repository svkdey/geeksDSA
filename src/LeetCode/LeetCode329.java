package LeetCode;

public class LeetCode329 {
	public int longestIncreasingPath(int[][] matrix) {
		int ans = Integer.MIN_VALUE;
		int n = matrix.length;
		if (n == 0)
			return 0;
		int m = matrix[0].length;
		int v[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				int subAns = dfs(matrix, v, i, j, n, m, -1);
//				System.out.println("("+i+" "+j+") "+subAns);
				ans = Math.max(subAns, ans);
			}
		}
		return ans;

	}

	public int dfs(int[][] matrix, int v[][], int i, int j, int n, int m, int waterLevel) {
		if (i < 0 || i >= n || j < 0 || j >= m || waterLevel >= matrix[i][j]) {
			return 0;
		}
		if (v[i][j] != 0)
			return v[i][j];

		int a = 1;
		int up = dfs(matrix, v, i + 1, j, n, m, matrix[i][j]);
		a = Math.max(a, 1 + up);
		int down = dfs(matrix, v, i - 1, j, n, m, matrix[i][j]);
		a = Math.max(a, 1 + down);
		int right = dfs(matrix, v, i, j + 1, n, m, matrix[i][j]);
		a = Math.max(a, 1 + right);
		int left = dfs(matrix, v, i, j - 1, n, m, matrix[i][j]);
		a = Math.max(a, 1 + left);

		return v[i][j] = a;
	}

	public static void main(String[] args) {
		LeetCode329 s = new LeetCode329();
		int nums[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(s.longestIncreasingPath(nums));
	}
}
