package Algorithms.DynamicProblems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

	/**
	 * idea of dynamic programming find Longest Increasing Subsequence for each
	 * element
	 * 
	 * 3 4 2 9 10 1 2 1 3 4 --->//max all these 4
	 **/
	// time:o(n^2) ,space: o(n)
	public static int LIS(int arr[], int n) {
		int dp[] = new int[n];
		// how to fill the dp array.
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			// for i_th location we need to find subsequence value
			int resOfi = Integer.MIN_VALUE;
				for (int j = i - 1; j >= 0; j--) {
					if (arr[i] > arr[j]) {
						resOfi = Math.max(resOfi, dp[j]);
					}
				}
			if (resOfi != Integer.MIN_VALUE) {
				dp[i] = resOfi + 1;
			} else {
				dp[i] = 1;
			}
		}
		System.out.println(Arrays.toString(dp));
		// finding out max in dp array
		int res = dp[0];
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;

	}

	/**
	 * Solution: Longest increasing Subsequence in O(nln(n)) time and o(n) space
	 * 
	 * idea : tail[i] -> stores the minimum possible tail value for LIS of length
	 * (i+1)
	 **/

	public static int LISBybinarysearch(int arr[], int n) {
		int tail[] = new int[n];
		int len = 1;
		tail[0] = arr[0];

		for (int i = 0; i < n; i++) {
			if (arr[i] > tail[len - 1]) {
				tail[len] = arr[i];
				len++;
			} else {
				int ceilElementThatwillReplace = ceilIdx(tail, 0, len - 1, arr[i]);
				tail[ceilElementThatwillReplace] = arr[i];
			}
		}
		return len;
	}

	public static int ceilIdx(int arr[], int l, int r, int x) {
		while (r > l) {
			int m = l + (r - l) / 2;
			if (arr[m] >= x) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return r;
	}
	// other problem
	
	public static int sumOfIncrasingSubArray(int arr[], int n) {
		int dp[] = new int[n];
		// how to fill the dp array.
//        dp[0]=1;
		for (int i = 0; i < n; i++) {
			// for i_th location we need to find subsequence value
			dp[i] = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], arr[i] + dp[j]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		// finding out max in dp array
		int res = dp[0];
		for (int i = 1; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
	
	public static int minDeleteToMakeArrSorted(int arr[], int n) {
		//find LIS.
		int lis=LIS(arr, n);
		
		return n-lis;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 2, 8, 10, 5, 1 };
		System.out.println(minDeleteToMakeArrSorted(arr, arr.length));
	}
}
