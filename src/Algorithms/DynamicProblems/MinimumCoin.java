package Algorithms.DynamicProblems;

import java.util.Arrays;

public class MinimumCoin {
	static int res = 0;

	public static int minimumCoinSolve(int coin[], int n, int sum) {
		if (sum == 0)
			return 0;
		int res = Integer.MAX_VALUE;

		// traverse all coin find solution for each coin
		// if a coin merges to solution will return 0;
		// then recursively send +1 up tree of recursion
		// and take all the min of those solution

		// if there is no solution then it will reply infinity value
		// ignore all infinite cases
		for (int i = 0; i < n; i++) {
			if (coin[i] <= sum) {
				int subRes = minimumCoinSolve(coin, n, sum - coin[i]);
				if (subRes != Integer.MAX_VALUE) {
					res = Math.min(res, subRes + 1);
				}
			}
		}
		return res;
	}

	// o(sum*n) time
	// o(sum) aux space
	/*
	 * If V == 0, then 0 coins required.
			If V > 0
			   minCoins(coins[0..m-1], V) = min {1 + minCoins(V-coin[i])} 
			                               where i varies from 0 to m-1 
			                               and coin[i] <= 
			                               */ 
	public static int minimumCoinSolveDP(int coins[], int n, int sum) {
		int dp[] = new int[sum + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		// for each sum i will check in coins if there are coins which are i-eachCoin>=0
		// then
		// i will take all the possible coin and find out min numbers of coin require to
		// get the target sum
		
		for(int coin:coins) {
			for(int i=1;i<=sum;i++) {
				
//				dp[i]=dp[i-1];
				if(i>=coin) {
					int res=dp[i-coin];
					if(res!=Integer.MAX_VALUE) {
						dp[i]=Math.min(1+res, dp[i]);
					}
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[sum];
	}

	public static void main(String[] args) {
		int coin[] = { 3, 1, 4 };
		int target = 5;
		System.out.println(minimumCoinSolveDP(coin, 3, target));
	}

}
