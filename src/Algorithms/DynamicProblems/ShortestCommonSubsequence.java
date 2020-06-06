package Algorithms.DynamicProblems;

import java.util.Arrays;

public class ShortestCommonSubsequence {
	//find the length of shortestCommon subsequence
	public static int ShortestCommonSubsequenceImplLength(String s1,String s2) {
		//algorithm to be used
		/**
		1.find some lcs . 
		return s1.len+s2.len- lcs;
		**/
		int m=s1.length();
		int n=s2.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[0][0]=0;
		int lcs=LCSutil(m,n,s1,s2,dp);
//		System.out.println(lcs);
		return m+n-lcs;
		
	}
	//standard LCS code
	private static int LCSutil(int m,int n,String s1,String s2,int dp[][]) {
		if(dp[m][n]!=-1) {
			return dp[m][n];
		}
		if(m<=0||n<=0) {
			return dp[0][0];
		}
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			dp[m][n]=1+LCSutil(m-1, n-1, s1, s2, dp);
		}
		else {
			dp[m][n]=Math.max(LCSutil(m, n-1, s1, s2, dp),LCSutil(m-1, n, s1, s2, dp));
		}
		return dp[m][n];
		
	}
	public static int ShortestCommonSubsequenceImplPrint(String s1,String s2) {
		//algorithm to be used
		/**
		1.find some lcs . 
		return s1.len+s2.len- lcs;
		**/
		int m=s1.length();
		int n=s2.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[0][0]=0;
		int lcs=LCSutil(m,n,s1,s2,dp);
//		System.out.println(lcs);
		return m+n-lcs;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "geek",  str2 = "eke" ;
		String X = "AGGTAB"; 
	    String Y = "GXTXAYB";;
		System.out.println(ShortestCommonSubsequenceImplLength(X,Y));
	}

}
