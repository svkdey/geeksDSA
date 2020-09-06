package LeetCode;

public class LeetCode1351 {
	public int countNegatives(int[][] grid) {
		int ans = 0;
		for (int arr[] : grid) {
			int idx = bs(arr);
			if (idx != -1) {
				ans += arr.length - idx;
			}
		}
		return ans;
	}

	public int bs(int[] arr) {
		int start = 0, end = arr.length - 1;
		int ans = -1;
		while (end >= start) {
			int mid = start + (end - start) / 2;
			if (arr[mid] < 0) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}
}
