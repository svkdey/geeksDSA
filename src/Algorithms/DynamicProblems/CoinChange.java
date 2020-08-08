package Algorithms.DynamicProblems;

import java.lang.reflect.Array;
import java.util.Arrays;

import Utility.Utils;

/**
 * To count the total number of solutions, we can divide all set solutions into
 * two sets. 1) Solutions that do not contain Sm. 2) Solutions that contain at
 * least one Sm. Let count(S[], m, n) be the function to count the number of
 * solutions, then it can be written as sum of count(S[], m-1, n) and count(S[],
 * m, n-Sm).
 **/

public class CoinChange {

	public static int coinCount(int S[], int m, int n) {
		// Returns the count of ways we can
		// sum S[0...m-1] coins to get sum n

		// If n is 0 then there is 1 solution
		// (do not include any coin)

		// If n is less than 0 then no
		// solution exists
		if (n == 0)
			return 1;

		// If there are no coins and n
		// is greater than 0, then no
		// solution exist
		if (m <= 0 || n < 0)
			return 0;
		// count is sum of solutions (i)
		// including S[m-1] (ii) excluding S[m-1]
		return coinCount(S, m - 1, n) + coinCount(S, m, n - S[m - 1]);

	}

	static long countWays(int S[], int m, int n) {
		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++) {
			System.out.println("for coin " + S[i]);
			for (int j = S[i]; j <= n; j++) {

				// idea is j th position number of coins for s[2]=
				// (j th position number of coins for just pervious coin say s[i]
				// +[sum-s[2]] position data
				table[j] = table[j] + table[j - S[i]];
				System.out.println(Arrays.toString(table));
			}
		}
		return table[n];
	}
	public static int change(int amount, int[] coins) {
		int dp[][] = new int[amount + 1][coins.length + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 1; i < coins.length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[0][i] = 1;
		}
		return changeUtil(amount, coins, coins.length, dp);
	}

	public static int changeUtil(int amount, int[] coins, int n, int dp[][]) {

		if (amount == 0)
			return 1;

		if (amount < 0 || n <= 0) {
			return 0;
		}
		if (dp[amount][n] != -1) {
			return dp[amount][n];
		} else
			dp[amount][n] = changeUtil(amount, coins, n - 1, dp) + changeUtil(amount - coins[n - 1], coins, n, dp);
//        Utils.p2Darray(dp);
		return dp[amount][n];
	}

	public static void main(String[] args) {
		int coins[] = { 1, 7, 10 };
		int n = coins.length;
		int targetSum = 15;
//		System.out.println(countWays(coins,targetSum,n));
//        System.out.println(coinCount(coins, n-1, targetSum));

	}
}
