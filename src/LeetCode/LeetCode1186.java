package LeetCode;

import java.util.Arrays;

public class LeetCode1186 {
	static int sum(int arr[], int s, int e) {
		int ans = 0;
		int dp[] = new int[arr.length];
		dp[s] = arr[s];
		ans = dp[s];
		for (int i = s + 1; i < e; i++) {
			dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}

	public static void solve(int nums[]) {
		int f = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				if (f > nums[i]) {
					f = nums[i];
					idx = i;
				}
			}
		}
		int i = 0;
		int temp[] = null;
		if (idx != -1) {
			temp = new int[nums.length - 1];

			for (int j = 0; j < nums.length; j++) {
				if (j != idx) {
					temp[i] = nums[j];
					i++;
				}
			}
		} else {
			temp = nums;
		}

		System.out.println(Arrays.toString(temp));
		int ans = 0;
		int dp[] = new int[temp.length];
		dp[0] = temp[0];
		ans = dp[0];
		for (i = 1; i < temp.length; i++) {

			dp[i] = Math.max(temp[i], temp[i] + dp[i - 1]);
			ans = Math.max(ans, dp[i]);

		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -1, -1, -1, -1 };
		solve(arr);
	}

}
