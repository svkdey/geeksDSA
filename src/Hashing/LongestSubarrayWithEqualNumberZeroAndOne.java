package Hashing;

import java.util.HashMap;

public class LongestSubarrayWithEqualNumberZeroAndOne {
	static int longestSubarrayWithEqualNumberZeroAndOne(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int prefixSum = 0;
		int maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				prefixSum += -1;
			} else {
				prefixSum += 1;
			}
			if (prefixSum == 0) {
				maxLength = Math.max(i + 1, maxLength);
			}
			if (map.containsKey(prefixSum)) {
				int idx = map.get(prefixSum);
				maxLength = Math.max(i - idx, maxLength);
			} else {
				map.put(prefixSum, i);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSubarrayWithEqualNumberZeroAndOne(new int[] {1,0,1,1,1,0,0}));
	}

}
