package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode286 {
	static class Coordinate {
		int x, y;

		@Override
		public String toString() {
			return "Coordinate [x=" + x + ", y=" + y + "]";
		}

		public Coordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static boolean check(int x, int y, int n, int m) {
		if (x >= 0 && x < n && y >= 0 && y < m) {
			return true;
		} else {
			return false;
		}
	}

	public static void solve(int grid[][]) {
		int n = grid.length;
		int m = grid[0].length;
		Queue<Coordinate> q = new LinkedList<Coordinate>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0) {
					q.add(new Coordinate(i, j));
					break;
				}
			}
		}
		int time = 0;
		while (!q.isEmpty()) {
	
			int size = q.size();
			time++;
			for (int i = 0; i < size; i++) {
				Coordinate pos = q.remove();
				int pos_x = pos.x;
				int pos_y = pos.y;
				if (check(pos_x + 1, pos_y, n, m) && grid[pos_x + 1][pos_y] == -2) {
					grid[pos_x + 1][pos_y] = time;

					q.add(new Coordinate(pos_x + 1, pos_y));
				}

				if (check(pos_x - 1, pos_y, n, m) && grid[pos_x - 1][pos_y] == -2) {
					grid[pos_x - 1][pos_y] = time;
					q.add(new Coordinate(pos_x - 1, pos_y));
				}

				if (check(pos_x, pos_y + 1, n, m) && grid[pos_x][pos_y + 1] == -2) {
					grid[pos_x][pos_y + 1] = time;
					q.add(new Coordinate(pos_x, pos_y + 1));
				}

				if (check(pos_x, pos_y - 1, n, m) && grid[pos_x][pos_y - 1] == -2) {
					grid[pos_x][pos_y - 1] = time;
					q.add(new Coordinate(pos_x, pos_y - 1));
				}
			}
		}
		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { { -2, -1, 0, -2 }, { -2, -2, -2, -1 }, { -2, -1, -2, -1 }, { 0, -1, -2, -2 } };
		solve(grid);
	}

}
