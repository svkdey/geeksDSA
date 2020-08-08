package LeetCode;

import java.util.Arrays;

public class LeetCode1252 {
	public static int oddCells(int n, int m, int[][] indices) {
		int arr[][] = new int[n][m];

		for (int index[] : indices) {
			for (int i = 0; i < m; i++) {
				arr[index[0]][i]++;
			}
			for (int i = 0; i < n; i++) {
				arr[i][index[1]]++;
			}
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] % 2 != 0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int indices[][] = { { 0, 0 }, { 1, 1 } };
		oddCells(2, 2, indices);
	}

}
