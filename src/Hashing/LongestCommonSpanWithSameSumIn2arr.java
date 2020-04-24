package Hashing;

import Arrayproblems.ArrayPreoblems;

public class LongestCommonSpanWithSameSumIn2arr {
	static int longestCommonSpanWithSameSumIn2arrSol1(int arr1[], int arr2[], int n) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			int sum1 = 0, sum2 = 0;
			for (int j = i; j < n; j++) {
				sum1 += arr1[j];
				sum2 += arr2[j];
				if (sum1 == sum2) {
					res = Math.max(res, j - i + 1);
				}
			}
		}
		return res;
	}

	static int longestCommonSpanWithSameSumIn2arrSol2(int arr1[], int arr2[], int n) {
		int temp[]=new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = arr2[i] - arr1[i];
		}
		ArrayPreoblems.showArr(temp, temp.length);
		return LongestSubarrayWithEqualNumberZeroAndOne.longestSubarrayWithEqualNumberZeroAndOne(temp);

	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonSpanWithSameSumIn2arrSol2(new int[] { 0, 1, 0, 0, 0, 0 },
				new int[] { 1, 1, 0, 0, 0, 1 }, 6));
		System.out.println(longestCommonSpanWithSameSumIn2arrSol1(new int[] { 0, 1, 0, 0, 0, 0 },
				new int[] { 1, 1, 0, 0, 0, 1 }, 6));
	}

}
