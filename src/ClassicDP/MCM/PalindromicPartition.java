package ClassicDP.MCM;

import java.util.Arrays;

public class PalindromicPartition {
	static int dp[][] = null;

	public static int solve(char arr[], int i, int j) {
		if (i >= j)
			return 0;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (palindrome(arr, i, j)) {
			return 0;
		}
		int val = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int tempAns = solve(arr, i, k) + solve(arr, k + 1, j) + 1;

			val = Math.min(val, tempAns);
		}
		return dp[i][j] = val;
	}

	public static int palindromicPartitionSolve(String s1) {
		char arr[] = s1.toCharArray();
		dp = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		char c[] = s1.toCharArray();
		int ans = solve(c, 0, c.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(ans);
		return ans;

	}

	private static boolean palindrome(char c[], int i, int j) {
		String s = new String(c);
		while (j > i) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			j--;
			i++;

		}
		return true;
	}

	public static void main(String[] args) {
		palindromicPartitionSolve("nitina");
	}
}
