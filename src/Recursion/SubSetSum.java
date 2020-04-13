package Recursion;

import java.util.ArrayList;
import java.util.*;

public class SubSetSum {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		subsetsHelper(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void subsetsHelper(List<List<Integer>> list, List<Integer> resultList, int[] nums, int start) {
		list.add(new ArrayList<>(resultList));
		for (int i = start; i < nums.length; i++) {
			// add element
			resultList.add(nums[i]);
			// Explore
			subsetsHelper(list, resultList, nums, i + 1);
			// remove
			resultList.remove(resultList.size() - 1);
		}
	}

	public static int sum(List<Integer> a) {
		int s = 0;
		for (Integer i : a) {
			s += i;
		}
		return s;
	}

	public static void subSetSum(int[] arr, int targetSum) {

		List<List<Integer>> list = subsets(arr);
		int result = 0;
		for (List<Integer> item : list) {
			if (sum(item) == targetSum) {
				result++;
			}
		}
		System.out.println(result);

	}
//better approach
	public static int subsetSumAlternative(List<Integer> arr, int n, int sum) {
		if (n == 0)
			return sum == 0 ? 1 : 0;
		else
			return subsetSumAlternative(arr, n - 1, sum) + subsetSumAlternative(arr, n - 1, sum - arr.get(n - 1));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4 ,5};
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			arr.add(a[i]);
		}
		System.out.println(subsetSumAlternative(arr, 5,10));
	}
}
