package Algorithms.DynamicProblems;

import java.util.Arrays;

import Utility.Utils;

/**
 * Given an array arr[0 … n-1] containing n positive integers, a subsequence of
 * arr[] is called Bitonic if it is first increasing, then decreasing. Write a
 * function that takes an array as argument and returns the length of the
 * longest bitonic subsequence. A sequence, sorted in increasing order is
 * considered Bitonic with the decreasing part as empty. Similarly, decreasing
 * order sequence is considered Bitonic with the increasing part as empty.
 * 
 * Examples:
 * 
 * Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1}; Output: 6 (A Longest Bitonic
 * Subsequence of length 6 is 1, 2, 10, 4, 2, 1)
 * 
 * Input arr[] = {12, 11, 40, 5, 3, 1} Output: 5 (A Longest Bitonic Subsequence
 * of length 5 is 12, 11, 5, 3, 1)
 * 
 * Input arr[] = {80, 60, 30, 40, 20, 10} Output: 5 (A Longest Bitonic
 * Subsequence of length 5 is 80, 60, 30, 20, 10)
 **/
public class LongestBiotonicSubsequence {
	public static int longestBiotonicSubsequenceImpl(int arr[], int n) {
		int lis[] = new int[n];
		int lds[] = new int[n];
		Arrays.fill(lis, -1);
		Arrays.fill(lds, -1);
		lis[0]=1;
		lds[n-1]=1;
		//we search subsequence for i on left side
		for(int i=1;i<n;i++) {
			int res=Integer.MIN_VALUE;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]<arr[i]) {
					res=Math.max(res,lis[j]);
				}
			}
			if(res!=Integer.MIN_VALUE) {
				lis[i]=res+1;
			}else {
				lis[i]=1;
			}
		}
		//find decresing subsequence from i=n-2 ....0 while j runs from n-1 to j>i
		
		//we search subsequence for i on right side
		for(int i=n-2;i>=0;i--) {
			int res=Integer.MIN_VALUE;
			for(int j=n-1;j>i;j--) {
				if(arr[j]<arr[i]) {
					res=Math.max(res,lds[j]);
				}
			}
			if(res!=Integer.MIN_VALUE) {
				lds[i]=res+1;
			}else {
				lds[i]=1;
			}
		}
		Utils.p1Darray(lis);
		Utils.p1Darray(lds);
		
		int max=lis[0]+lds[0]-1;
		
		for(int i=1;i<n;i++) {
			int tempMax=lis[i]+lds[i]-1;
			max=Math.max(max,tempMax );
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] ={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 
                13, 3, 11, 7, 15};
		System.out.println(longestBiotonicSubsequenceImpl(arr, arr.length));

	}
}
