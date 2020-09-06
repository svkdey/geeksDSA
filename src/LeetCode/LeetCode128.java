package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode128 {

	public int longestConsecutive(int[] nums) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : nums) {
			set.add(n);
		}
		int ans = 0;
		for (int num : nums) {
			int i = num;
			int leftCount = 1;
			int rightCount = 1;
			while (set.contains(--i)) {
				leftCount++;
			}
			i = num;
			while (set.contains(++i)) {
				rightCount++;
			}
			ans=Math.max(Math.max(rightCount, leftCount),ans);

		}
		return ans;

	}

	public static void main(String[] args) {
		int arr[] = { 100, 4, 200, 1, 3, 2 };
		LeetCode128 s = new LeetCode128();
		System.out.println(s.longestConsecutive(arr));
	}
}
