package Algorithms.DynamicProblems;

import java.util.Arrays;

// it is part of  Subset Sum Problem 
public class PartionAarray {
	public static boolean partionAarray(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		if (sum % 2 != 0) {
			return false;
		}
		return isSubSetDP(arr, n, sum / 2);
	}

	public static boolean isSubSet(int arr[], int n, int sum) {
//		System.out.println("called");

		if (sum == 0)
			return true;
		if (sum != 0 && n == 0)
			return false;
		if (arr[n - 1] > sum) {
			return isSubSet(arr, n - 1, sum);
		}
		return isSubSet(arr, n - 1, sum) || isSubSet(arr, n - 1, sum - arr[n - 1]);

	}

	public static boolean isSubSetDP(int arr[], int n, int sum) {
//		System.out.println("called");
		boolean dp[][] = new boolean[sum + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[0][i] = true;
		}
		for (int i = 1; i <= sum; i++) {
			dp[i][0] = false;
		}
		for (int i = 1; i <= sum; i++) {

			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i >= arr[j - 1]) {
					dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
				}
			}
		}
		return dp[sum][n];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 5, 11, };
		System.out.println(partionAarray(arr, arr.length));
	}

}
