package Algorithms.BackTrackinBasic;

import java.util.*;


public class PermutationOfArray {
	public static void PermutationOfArrayImpl(int nums[]) {
		// TODO Auto-generated constructor stub
		Arrays.sort(nums);
		// result ll
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		backTrack(result, new ArrayList<Integer>(), nums);
		System.out.println(result);
	}

	private static void backTrack(List<ArrayList<Integer>> result, ArrayList<Integer> tempList,
			int[] nums) {
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// if element is dont include
			if (!tempList.contains(nums[i])) {
				// adding the element;
				tempList.add(nums[i]);

				backTrack(result,tempList, nums);
				// backtracking
				tempList.remove(tempList.size() - 1);
			}

		}
	}
	public static void main(String[] args) {
		int nums[]= {1,2,3};
		PermutationOfArrayImpl(nums);
		
	}

}
