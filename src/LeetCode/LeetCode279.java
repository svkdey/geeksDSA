package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode279 {
	public static int numSquares(int n) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		int i=1;
		
		int dp[]=new int[n+1];
		dp[0]=0;
		for( i=1;i<=n;i++) {
			dp[i]=Integer.MAX_VALUE;
			for(int k=1;k*k<=n;k++) {
				if(i>=k*k &&dp[i-k*k]!=Integer.MAX_VALUE) {
					dp[i]=Math.min(dp[i], 1+dp[i-k*k]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
    }
	
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
}
