package ClassicDP.LCS;

public class WildCardMatching {
	/*
	 * str 0 to i is equal pattern 0 to j
	 * 
	 * */
	public static void solve(String str,String pattern) {
		int n=str.length();
		int m=pattern.length();
		boolean dp[][]=new boolean[n+1][m+1];
		dp[0][0]=true;

		for (int i = 1; i <= pattern.length(); i++) {
		  if (pattern.charAt(i - 1) == '*') {
			dp[0][i] = dp[0][i - 1];
		  }
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(str.charAt(i-1)==pattern.charAt(j-1) ||pattern.charAt(j-1)=='?') {
					dp[i][j]=dp[i-1][j-1];
				}else if(pattern.charAt(j-1)=='*') {
					dp[i][j]=dp[i-1][j]||dp[i][j-1]||dp[i-1][j-1];
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
