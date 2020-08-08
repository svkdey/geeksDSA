package LeetCode;

import java.util.*;

public class LeetCode542 {
	private int bfs(int i, int j) {
		Queue<Integer> q_x = new LinkedList<Integer>();
		Queue<Integer> q_y = new LinkedList<Integer>();
		q_x.add(i);
		q_y.add(j);
		int dist = 0;
		boolean isFound = false;
		int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!q_x.isEmpty() && !q_y.isEmpty()) {
			int s = q_x.size();
			for (int x = 0; x < s; x++) {
				int dx = q_x.remove();
				int dy = q_y.remove();
				if (grid[dx][dy] == 0) {
					isFound = true;
					break;
				}

				for (int k = 0; k < dir.length; k++) {
					int dr = dx + dir[k][0];
					int dc = dy + dir[k][1];

					if (dr >= 0 && dr < grid.length && dc >= 0 && dc < grid[0].length) {
						q_x.add(dr);
						q_y.add(dc);
					}
				}

			}
			if (isFound) {
				break;
			}
			dist++;
		}
		return dist;
	}

	int grid[][] = null;

	public int[][] updateMatrix(int[][] matrix) {
		grid = matrix;
		int m = matrix.length, n = matrix[0].length;
		int result[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					result[i][j] = bfs(i, j);
				}
			}
		}
		return result;
	}

}
