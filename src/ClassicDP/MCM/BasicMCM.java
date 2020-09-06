package ClassicDP.MCM;

import java.util.Arrays;

public class BasicMCM {
	static int dp[][]=null;
	public static int solve(int arr[], int i, int j) {
		if (i >= j)
			return 0;
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int val = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int tempAns = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);

			val = Math.min(val, tempAns);
		}
		return dp[i][j]=val;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30 ,40,70,36,12};
		dp=new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(solve(arr, 1, arr.length-1));
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}
}
