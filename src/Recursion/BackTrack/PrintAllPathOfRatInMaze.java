package Recursion.BackTrack;

import java.util.Arrays;

public class PrintAllPathOfRatInMaze {
	static int count=0;
	public static void solve(int arr[][], int n, int m) {
		int result[][] = new int[n][m];
//		System.out.println(dfs(arr, result, n, m, 0, 0));
		dfsPrintAllPath(arr, result, n, m, 0, 0);
		System.out.println(count);
//		for (int k = 0; k < result.length; k++) {
//			System.out.println(Arrays.toString(result[k]));
//		}
	}

	private static boolean isSafe(int i, int j, int n, int m) {
		if (i >= 0 && i < n && j >= 0 && j <= m) {
			return true;
		} else
			return false;
	}

	private static boolean dfs(int arr[][], int result[][], int n, int m, int i, int j) {
		if (i == n - 1 && j == m - 1) {
			result[i][j] = 1;
			for (int k = 0; k < result.length; k++) {
				System.out.println(Arrays.toString(result[k]));
			}
			return true;
		}
		if (arr[i][j] == 1) {
			result[i][j] = 1;
			// right explore
			if (isSafe(i + 1, j, n, m) && dfs(arr, result, n, m, i + 1, j)) {
				return true;
			}
			// down explore
			if (isSafe(i, j + 1, n, m) && dfs(arr, result, n, m, i, j + 1)) {
				return true;
			}

			result[i][j] = 0;
		}
		return false;
	}

	private static void dfsPrintAllPath(int arr[][], int result[][], int n, int m, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m || arr[i][j] == 0) {
			return;
		}

		if (i == n - 1 && j == m - 1) {
			result[i][j] = 1;
			count++;
			for (int k = 0; k < result.length; k++) {
				System.out.println(Arrays.toString(result[k]));
			}
			System.out.println("------------------------------------------");
			return;
		}
		result[i][j] = 1;
		dfsPrintAllPath(arr, result, n, m, i + 1, j);

		// down explore
		dfsPrintAllPath(arr, result, n, m, i, j + 1);

		result[i][j] = 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 } };
		solve(maze, 4, 4);
	}

}
