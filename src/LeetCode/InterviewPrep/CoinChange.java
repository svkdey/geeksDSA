package LeetCode.InterviewPrep;

public class CoinChange {
	 public int coinChange(int[] coins, int amount) {
	        int dp[][]=new int[coins.length+1][amount+1];
	        
	       
	        for(int i=0;i<=amount;i++) {
	        	dp[0][i]=1;
	        }
	        
	        for(int i=0;i<coins.length;i++) {
	        	for(int j=1;j<amount;j++) {
	        		if(j-coins[i]>=0) {
	        			dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j-1] ) ;
	        		}else {
	        			dp[i][j]=dp[i-1][j-1];
	        		}
	        	}
	        }
	        return dp[coins.length][amount];
	    }
}
