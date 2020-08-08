package LeetCode;

import java.util.HashMap;

public class LeetCode560 {
	public static int subarraySum(int[] nums, int k) {

		int prefixSum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;

		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];

			if (prefixSum == k) {
				res++;
			}
			if (map.containsKey(prefixSum - k)) {
				res += map.get(prefixSum - k);
			}
			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
			System.out.println(map);
		}
		return res;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1,1 };
		int k = 4;
		System.out.println(subarraySum(nums, k));
	}
}
