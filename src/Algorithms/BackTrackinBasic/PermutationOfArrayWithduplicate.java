package Algorithms.BackTrackinBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class PermutationOfArrayWithduplicate {

	public static void PermutationOfArrayWithduplicateImpl(int nums[]) {
		// TODO Auto-generated constructor stub
		Arrays.sort(nums);
		// result ll
		LinkedHashSet<ArrayList<Integer>> result = new LinkedHashSet<ArrayList<Integer>>();
		boolean used[] = new boolean[nums.length];
		backTrack(result, new ArrayList<Integer>(),used, nums);
		System.out.println(result);
	}

	private static void backTrack(LinkedHashSet<ArrayList<Integer>> result, ArrayList<Integer> tempList, boolean used[],
			int[] nums) {
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// if element is dont include
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue;
			// adding the element;
			used[i] = true;
			tempList.add(nums[i]);

			backTrack(result, tempList, used, nums);
			// backtracking
			used[i] = false;
			tempList.remove(tempList.size() - 1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 1, 2 };
		PermutationOfArrayWithduplicateImpl(nums);
	}

}
