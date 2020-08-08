package LeetCode;

import java.util.ArrayList;

public class LeetCode1498 {
	public static int numSubseq(int[] nums, int target) {
		ans = 0;
		util(nums, target, new ArrayList<Integer>());
		System.out.println(ans);
		return ans;
	}

	static int ans = 0;

	public static int util(int[] nums, int target, ArrayList<Integer> l) {
		if (target < 0) {
		
			return 0;
		}
		System.out.println(l);
		int count = 0;
		for (int num : nums) {
			if (target - num >= 0) {
				l.add(num);
				util(nums, target - num, l);
				l.remove(l.size() - 1);
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int nums[] = { 3,3,6,8}, target = 12;
		numSubseq(nums, target);
	}
}
