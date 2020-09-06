package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode491 {
	private Set<List<Integer>> set = null;

	public List<List<Integer>> findSubsequences(int[] nums) {
		set = new HashSet<List<Integer>>();
		List<List<Integer>> list = new ArrayList<>();
		backTrack(nums, 0, new ArrayList<>(), list);
		return new ArrayList<List<Integer>>(set);
	}

	public void backTrack(int[] nums, int index, List<Integer> currList, List<List<Integer>> list) {
		if (currList.size() > 1) {
			set.add(new ArrayList<>(currList));
		}

		for (int i = index; i < nums.length; i++) {
			if (currList.size() == 0 || currList.get(currList.size() - 1) <= nums[i]) {
				currList.add(nums[i]);
				backTrack(nums, i + 1, currList, list);
				currList.remove(currList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 4, 6, 7, 7 };
		
	}
}
