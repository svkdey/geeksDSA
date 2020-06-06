package Algorithms.DynamicProblems;

public class WaystoWriteN {
	public static int NumbeOfwaysToCountDP(int target) {
		int dp[]=new int[target+1];
		
		dp[0]=1;
		for(int i=1;i<target;i++) {//possible numbers
			for(int j=i;j<=target;j++) {//coint maney coins needed to maked i
				dp[j]=((dp[j]%1000000007)+(dp[j-i]%1000000007))%1000000007;
			}
		}
		return dp[target];
	}
    int countWays(int n){
    
         // your code here
         return NumbeOfwaysToCountDP(n);
         
    } 
}
