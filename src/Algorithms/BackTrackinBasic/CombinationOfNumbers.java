package Algorithms.BackTrackinBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class CombinationOfNumbers {
	public static void CombinationOfNumbersImpl(int nums[]) {
		// TODO Auto-generated constructor stub
		Arrays.sort(nums);
		// result ll
		LinkedHashSet<ArrayList<Integer>> result = new LinkedHashSet<ArrayList<Integer>>();

		SubSetofArrayImpl(result,nums, nums.length, 0,new ArrayList<Integer>());
		System.out.println(result);
	}

	public static void SubSetofArrayImpl(LinkedHashSet<ArrayList<Integer>> result,int arr[], int n, int idx, ArrayList<Integer> l) {
		ArrayList<Integer> list = new ArrayList<Integer>(l);
		result.add(list);
		for (int i = idx; i < n; i++) {
			l.add(arr[i]);
			SubSetofArrayImpl(result,arr, n, i + 1, l);
			l.remove(l.size() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 2, 3};
		CombinationOfNumbersImpl(nums);

	}

}
