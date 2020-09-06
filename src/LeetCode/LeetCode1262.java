package LeetCode;

import java.util.Arrays;

public class LeetCode1262 {
	public static int maxSumDivThree(int[] arr) {
		int[] dp = new int[] { 0, 0, 0 };
		for (int a : arr) {
			int[] dp2 = new int[3];
			System.out.println(a+"-->" +Arrays.toString(dp));
			for (int i = 0; i < 3; ++i) {
				int x = (i + a) % 3;
				dp2[x] = Math.max(dp[x], dp[i] + a);
			}
			dp = dp2;
		}
		return dp[0];
	}

	public static void main(String[] args) {
		int arr[] = { 3, 6, 5, 1, 8 };
		System.out.println(maxSumDivThree(arr));

	}
}
