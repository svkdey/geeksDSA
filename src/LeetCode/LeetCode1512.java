package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1512 {
	public static int solve(int nums[]) {
		int count[] = new int[101];

		for (int i : nums) {
			count[i]++;
		}

		int ans = 0;

		for (int i = 0; i < 101; i++) {
			if (count[i] > 0) {
				ans += (count[i] * (count[i] - 1)) / 2;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 1, 1, 3 };
		System.out.println(solve(nums));
	}
}
