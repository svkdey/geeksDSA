package LeetCode;

import java.util.Arrays;

public class LeetCode712 {
	 public int minimumDeleteSum(String s1, String s2) {
	     int n=s1.length();
	     int m=s2.length();
	     dp=new int[n+1][m+1];
	     for(int i=0;i<=n;i++) {
	    	 Arrays.fill(dp[i], -1);
	     }
	     lis(s1,s2,n,m);
	     String c=getLisStr(s1,s2);
	     return cal(s1)+cal(s2)-2*cal(c);
		 
		 
	   }
	 static int dp[][]=null;
	 public int cal(String s) {
		 int sum=0;
		 char c[]=s.toCharArray();
		 for(char x:c) {
			 sum+=(int)x;
		 }
		 return sum;
	 }
	 
	 public int lis(String s1,String s2,int n,int m) {
		if(n==0||m==0) {
			return 0;
		}
		
		if(dp[n][m]!=-1) {
			return dp[n][m];
		}
		
		if(s1.charAt(n-1)==s2.charAt(m-1)) {
			dp[n][m]=1+lis(s1, s2, n-1, m-1);
		}
		else {
			dp[n][m]=Math.min(lis(s1, s2, n-1, m),lis(s1, s2, n, m-1));
		}
		return dp[n][m];
	 }
	 public String getLisStr(String s1, String s2) {
		 StringBuilder sb=new StringBuilder();
		 int i=dp.length,j=dp[0].length;
		 
		 while(i>0&&j>0) {
			 if(s1.charAt(i)==s2.charAt(j)) {
				 sb.append(s1.charAt(i));i--;j--;
			 }
			 else {
				 if(dp[i-1][j]>dp[i][j-1]) {
					 i--;
				 }else {
					 j--;
				 }
			 }
		 }
		 return sb.toString();
		 
	 }
	 
}
