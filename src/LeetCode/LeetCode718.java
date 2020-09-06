package LeetCode;

import java.util.Arrays;

public class LeetCode718 {
	public static int findLength(int[] A, int[] B) {
		int dp[][] = new int[A.length + 1][B.length + 1];
		int ans = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					ans = Math.max(ans, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}

			}
		}

		for (int i = 0; i <= A.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return ans;
	}

	public static void main(String[] args) {
		int A[] = { 1, 0, 0, 0, 1 };
		int B[] = { 1, 0, 0, 1, 1 };
		System.out.println(findLength(A, B));
	}
}
