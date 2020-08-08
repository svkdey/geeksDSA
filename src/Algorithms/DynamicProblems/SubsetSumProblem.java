package Algorithms.DynamicProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSumProblem {

	public static int solve(int arr[], int target, int n) {
		if (n == 0) {
			return target == 0 ? 1 : 0;
		}

		else
			return solve(arr, target - arr[n - 1], n - 1) + solve(arr, target, n - 1);
	}

	static int dp[][] = null;

	public static int topDown(int arr[], int target, ArrayList<Integer> l, int n) {
		if (n == 0) {
			if (target == 0) {
				System.out.println(l);
				l = new ArrayList<Integer>();
				return 1;
			} else {
				return 0;
			}
		}
		if (target < 0) {
			return 0;
		} else if (dp[n][target] != -1) {
			return dp[n][target];
		} else {
			l.add(arr[n - 1]);
			int include = topDown(arr, target - arr[n - 1], l, n - 1);
			l.remove(l.size() - 1);
			int exculde = topDown(arr, target, l, n - 1);
//			System.out.println(n + "--->"+target +"---"+ include + " -- " + exculde);
			return dp[n][target] = include + exculde;
		}
	}

	public static int bottomUp(int arr[], int target, int n) {
		dp = new int[n + 1][target + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= target; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int target = 14;
		int arr[] = { 7, 3, 2, 5, 8, 14 };
		dp = new int[arr.length + 1][target + 1];

		for (int i = 0; i <= arr.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		ArrayList<Integer> l = new ArrayList<Integer>();
		System.out.println(bottomUp(arr, target, arr.length));
		for (int i = 0; i <= arr.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}

	}
}
