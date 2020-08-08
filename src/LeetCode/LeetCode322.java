package LeetCode;

import java.util.Arrays;

public class LeetCode322 {
	static int dp[] = null;
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		dp=new int[amount+1];
		dp[0]=0;
		
		for(int i=1;i<=amount;i++) {
			dp[i]=Integer.MAX_VALUE;
			for (int coin:coins) {
				
				if (i >= coin&&dp[i-coin]!=Integer.MAX_VALUE) {
					dp[i]=Math.min(dp[i], dp[i-coin]+1);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];

	}

	

	

	public static void main(String[] args) {
		int coins[] = { 186, 419, 83, 408 };
		int amont = 6249;
		System.out.println(coinChange(coins, amont));
	}
}
