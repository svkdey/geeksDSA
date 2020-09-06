package LeetCode;

public class LeetCode643 {
	public double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		double ans = sum / k;
		for (int i = 1; i < n - k + 1; i++) {
			sum = sum - nums[i];
			sum += nums[k + i];
			
			ans = Math.max(ans, sum / k);
		}
		return ans;
	}

}
