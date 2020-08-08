package LeetCode;

import java.util.Arrays;

public class LeetCode486 {
	  static int dp[][]=null;
	    public boolean PredictTheWinner(int[] piles) {
	         int n=piles.length;
		        dp=new int[n+1][n+1];
		        int sum=0;
		        for(int x:piles) {
		        	sum+=x;
		        }
		        for(int i=0;i<=n;i++) {
		        	Arrays.fill(dp[i],-1);
		        }
		        int alexGot=util(piles,0,n-1);
		        System.out.println(alexGot);
		        int leeGot=sum-alexGot;
		        return alexGot>leeGot;
		        
	    }
	    public int util(int piles[],int i,int j) {
	    	if(i>j) {
	    		return 0;
	    	}
			 if(i+1==j) {
				 return Math.max(piles[i], piles[j]);
			 }
//			 System.out.println(i +"  "+j);
			 if(dp[i][j]!=-1) {
				 return dp[i][j];
			 }
			 return dp[i][j]= Math.max(piles[i]+Math.min(util(piles, i+2, j), util(piles, i+1, j-1)),
					 piles[j]+Math.min(util(piles, i+1, j-1), util(piles, i, j-2)));
		 }
	    public static void main(String[] args) {
	    	LeetCode486 s=new LeetCode486();
	    	int piles[]= {1, 233, 7};
	    	System.out.println(s.PredictTheWinner(piles));
		}
}
