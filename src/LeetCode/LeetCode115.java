package LeetCode;

public class LeetCode115 {
	public static int numDistinct(String s, String t) {
		int n=s.length();
		int m=t.length();
		int dp[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			dp[i][0]=1;
		}
		/*	for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println();
		*/
		for(int j=1;j<=m;j++) {
			for(int i=1;i<=n;i++) {
		
				if(s.charAt(i-1)==t.charAt(j-1)) {
					dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		/*
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}*/
		return dp[n][m];
	}
	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}
}
