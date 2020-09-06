package ClassicDP.unboundKnapsac;

import java.util.Arrays;

public class MiniMumNumberOfCoins {
	public static int coinChange(int[] coins, int sum) {
		int t[][] = new int[coins.length + 1][sum + 1];
		for (int i = 0; i < coins.length + 1; i++) {
			t[i][0] = 0;
		}
		//to keep it max -1
		for (int i = 0; i < sum + 1; i++) {
			t[0][i] = Integer.MAX_VALUE - 1;
		}

	
		
		for (int i = 1; i < coins.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (j - coins[i - 1] >= 0) {
					t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i-1]]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		for (int i = 0; i < coins.length + 1; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		return t[coins.length][sum];

	}

    public int coinChange2ndway(int[] coins, int amount) {
        Arrays.sort(coins);
		  int dp[] =new int[amount+1];
		dp[0]=0;
		
		for(int i=1;i<=amount;i++) {
			dp[i]=Integer.MAX_VALUE;
			for (int coin:coins) {
				
				if (i >= coin&&dp[i-coin]!=Integer.MAX_VALUE) {
					dp[i]=Math.min(dp[i], dp[i-coin]+1);
				}
			}
		}
	
		return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];

    }
	public static void main(String[] args) {
		int coins[]= {2, 3, 9};
		System.out.println(coinChange(coins, 18));
	}
}
