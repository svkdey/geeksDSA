package LeetCode;

import java.util.Arrays;

public class LeetCode213 {
	public static  int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		return Math.max(robHouse(nums, 0, n - 2), robHouse(nums, 1, n - 1));
	}

	private static int robHouse(int[] nums, int start, int end) {
		int[] numsNew = Arrays.copyOfRange(nums, start, end + 1);
		System.out.println(Arrays.toString(numsNew));
		int[] dp = new int[numsNew.length];
		if (numsNew.length == 0)
			return 0;
		if (numsNew.length == 1)
			return numsNew[0];
		dp[0] = numsNew[0];
		dp[1] = Math.max(numsNew[0], numsNew[1]);
		for (int i = 2; i < numsNew.length; i++) {
			dp[i] = Math.max(dp[i - 2] + numsNew[i], dp[i - 1]);
		}
		return dp[numsNew.length - 1];

	}

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 1 };
		System.out.println(rob(nums));
	}

}
