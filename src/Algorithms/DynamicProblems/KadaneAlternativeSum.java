package Algorithms.DynamicProblems;

import java.util.Arrays;

import Utility.Utils;

public class KadaneAlternativeSum {
	public static long maximumSum(int arr[], int sizeOfArray) {
		// Your code here
		long dp[] = new long[sizeOfArray];

		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for(int i=2;i<arr.length;i++) {
			dp[i]=Math.max(dp[i-1],
					Math.max(arr[i]+dp[i-2], arr[i]));
		}
		long mx=dp[0];
		Utils.p1Darray(dp);
		for(int i=1;i<arr.length;i++) {
			mx=Math.max(mx, dp[i]);
		}
		
		return mx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {902 ,-525, 353 ,23, 487, -717, -771, 660, 502, -840};
		System.out.println(maximumSum(arr,arr.length));
	}

}
