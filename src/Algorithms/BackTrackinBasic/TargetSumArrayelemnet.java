package Algorithms.BackTrackinBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/***
 * Combination Sum Given an array of integers A and a sum B, find all unique
 * combinations in A where the sum is equal to B. The same repeated number may
 * be chosen from A unlimited number of times.
 * 
 * Note: 1. All numbers will be positive integers. 2. Elements in a combination
 * (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak). 3.
 * The combinations themselves must be sorted in ascending order.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * there will be three lines of input, first of which contains N, size of array.
 * Next line contains N space seperated integers, and the last line contains B.
 * 
 * Output: For each testcase, print the sets enclosing a backet "(" and ")". No
 * space between two sets. If no set can be formed with the given set, then
 * print "Empty" (without quotes).
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 30 1 <= A[i] <= 20 1 <= B <= 100
 * 
 * Example: Input: 3 4 7 2 6 5 16 11 6 5 7 1 8 2 9 9 7 7 9 6 4 2 4 6 8 8
 * 
 * Output: (2 2 2 2 2 2 2 2)(2 2 2 2 2 6)(2 2 2 5 5)(2 2 5 7)(2 2 6 6)(2 7 7)(5
 * 5 6) (1 1 1 1 1 1)(1 1 1 1 2)(1 1 2 2)(1 5)(2 2 2)(6) (2, 2, 2, 2)(2, 2,
 * 4)(2, 6)(4, 4)(8)
 * 
 * Explanation: Testcase 3: Required sets with sum equal to B (8) are as
 * follows: [2, 2, 2, 2] [2, 2, 4] [2, 6] [4, 4] [8]
 ***/
public class TargetSumArrayelemnet {
	static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		LinkedHashSet<ArrayList<Integer>> result = new LinkedHashSet<ArrayList<Integer>>();
		combinationSumImplIfDuplicateNotAllowed(result, new ArrayList<Integer>(), A, B, 0);
		System.out.println(result);
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>(result);
		return res;
	}

	static void combinationSumImpl(LinkedHashSet<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> A,
			int B, int idx) {
		if (B < 0)
			return;
		if (B == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		} else {
			for (int i = idx; i < A.size(); i++) {
				temp.add(A.get(i));
				//taking last element and trying again
				combinationSumImpl(result, temp, A, B - A.get(i), i);
				temp.remove(temp.size() - 1);

			}
		}
	}

	static void combinationSumImplIfDuplicateNotAllowed(LinkedHashSet<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> A,
			int B, int idx) {
		if (B < 0)
			return;
		if (B == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		} else {
			for (int i = idx; i < A.size(); i++) {
				//not taking the duplicate again
				if(i>idx&&A.get(i)==A.get(i-1)) continue;
				temp.add(A.get(i));
				//not taking the element again
				combinationSumImpl(result, temp, A, B - A.get(i), i+1);
				temp.remove(temp.size() - 1);

			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,5,2,1,2};
		Arrays.sort(arr);
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i : arr) {
			l.add(i);
		}
		System.out.println(l);
		combinationSum(l, 5);
	}

}
