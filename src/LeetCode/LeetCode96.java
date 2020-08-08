package LeetCode;

import java.util.Arrays;

public class LeetCode96 {
	static Long dp[]=null;
	public static long makeFactorialTable(int num) {
		if(dp[num]!=-1) {
			return dp[num];
		}
		return dp[num]=num*makeFactorialTable(num-1);
		
	}
	 public int numTrees(int n) {
	        dp=new Long[2*n+1];
	        Arrays.fill(dp,-1);
	        dp[0]=(long) 1;
	        dp[1]=(long) 1;
	        makeFactorialTable(2*n);
	        System.out.println(Arrays.toString(dp));
	        return (int)(dp[2*n]/(dp[n]*dp[n])*(n+1));
	    }
	 public static void main(String[] args) {
		
	}
}
