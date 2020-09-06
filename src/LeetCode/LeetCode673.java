package LeetCode;

import java.util.Arrays;

public class LeetCode673 {
	public int findNumberOfLIS(int[] nums) {
		int n = nums.length, res = 0, max_len = 0;
		int[] len = new int[n], cnt = new int[n];
		for (int i = 0; i < n; i++) {
			len[i] = cnt[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (len[i] == len[j] + 1)// old LIS + take the j th element 
						cnt[i] += cnt[j];
					if (len[i] < len[j] + 1) {//new LIS
						len[i] = len[j] + 1;
						cnt[i] = cnt[j];//count will same as previous
					}
				}
			}

			if (max_len == len[i]) // else add all LIS of same length[i] 
				res += cnt[i];
			if (max_len < len[i]) { //new LIS . ans reset
				max_len = len[i];
				res = cnt[i];
			}
		}
		System.out.println(Arrays.toString(cnt));
		return res;
	}
}
