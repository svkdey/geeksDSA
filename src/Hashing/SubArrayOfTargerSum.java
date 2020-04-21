package Hashing;

import java.util.HashSet;

public class SubArrayOfTargerSum {
	// logic calculate prefix sum for each element 1 2 3 -4 -1 5 => 1 3 6 2 1 6
	// if any element which is repeating prefix sum array then sum is zero as the
	// affect of previous sum to next sum is nullified
	// i.e 1 3 6 2 1 6 effect of 1+(2+3-4-1) =>1

	public static boolean targetSumZero(int arr[]) {
		HashSet<Integer> s = new HashSet<Integer>();

		int prefixSum = arr[0];
		s.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			prefixSum += arr[i];
			if (prefixSum == 0) {
				return true;
			}
			if (s.contains(prefixSum)) {
				return true;
			} else {
				s.add(prefixSum);
			}
		}
		return false;
	}

	public static boolean targetSum(int arr[],int target) {
		HashSet<Integer> s = new HashSet<Integer>();

		int prefixSum = 0;
	
		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];
			if (prefixSum-target == 0) {
				return true;
			}
			if (s.contains(prefixSum-target)) {
				return true;
			} else {
				s.add(prefixSum);
			}
		}
		return false;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(targetSumZero(new int[] { 11,5,-6}));
		
		System.out.println(targetSum(new int[] {5,8,6,13,3,-1},22));
		

	}

}
