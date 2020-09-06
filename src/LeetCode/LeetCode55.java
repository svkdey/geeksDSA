package LeetCode;

import java.util.Arrays;

public class LeetCode55 {

	public boolean canJumpTopDown(int[] arr) {

		int n = arr.length;
		int dp[] = new int[n];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] + j >= i) {
					if (dp[j] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[j] + 1);
					}
				}
			}
		}
		return dp[n - 1] == Integer.MAX_VALUE ? false : true;

	}

	static int dp[] = null;

	public boolean canJump(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return false;
		if (n == 1)
			return true;
		dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		uitl(nums, n);
		System.out.println(Arrays.toString(dp));
		return dp[n] != Integer.MAX_VALUE - 1 ? true : false;
	}

	public int uitl(int[] arr, int n) {
		if (n == 1)
			return 0;
		if (dp[n] != Integer.MAX_VALUE - 1) {
			return dp[n];
		}
		int res = Integer.MAX_VALUE - 1;
		for (int i = 0; i <= n - 2; i++) {
			if (i + arr[i] >= n - 1) {
				int sub_res = 1 + uitl(arr, i + 1);
				if (sub_res != Integer.MAX_VALUE - 1) {
					res = Math.min(res, sub_res);
				}
			}
		}
		return dp[n] = res;
	}
}
