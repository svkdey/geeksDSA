package Algorithms.DynamicProblems;

import java.util.Arrays;

import Utility.Utils;

/**
 * Stickler Thief Stickler the thief wants to loot money from a society having n
 * houses in a single line. He is a weird person and follows a certain rule when
 * looting the houses. According to the rule, he will never loot two consecutive
 * houses. At the same time, he wants to maximize the amount he loots. The thief
 * knows which house has what amount of money but is unable to come up with an
 * optimal looting strategy. He asks for your help to find the maximum money he
 * can get if he strictly follows the rule. Each house has a[i] amount of money
 * present in it.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. T testcases follow. Each test case contains an integer n which
 * denotes the number of houses. Next line contains space separated numbers
 * denoting the amount of money in each house.
 * 
 * Output: For each testcase, in a newline, print an integer which denotes the
 * maximum amount he can take home.
 * 
 * Expected Time Complexity: O(N). Expected Space Complexity: O(N).
 * 
 * Constraints: 1 <= T <= 200 1 <= n <= 104 1 <= a[i] <= 104
 * 
 * Example: Input: 2 6 5 5 10 100 10 5 3 1 2 3 Output: 110 4
 * 
 * Explanation: Testcase1: 5+100+5=110 Testcase2: 1+3=4
 **/
public class KadaneAlternativeSum {

	public static long maximumSum(int arr[], int sizeOfArray) {
		// Your code here
		long dp[] = new long[sizeOfArray];

		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			// this line is important
			dp[i] = Math.max(dp[i - 1], Math.max(arr[i] + dp[i - 2], arr[i]));
		}
		long mx = dp[0];
//		Utils.p1Darray(dp);
		for (int i = 1; i < arr.length; i++) {
			mx = Math.max(mx, dp[i]);
		}

		return mx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 902, -525, 353, 23, 487, -717, -771, 660, 502, -840 };
		System.out.println(maximumSum(arr, arr.length));
	}

}
