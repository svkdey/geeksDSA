package ClassicDP.CatalanNumber;

import java.util.Arrays;

public class NCr {
	static int dp[][]=null;
	public static int solve(int n,int r) {
		if (r == n || r == 0) {
			return 1;
		}
		else if(dp[n][r]!=-1) {
			return dp[n][r];
		}
		else {
			return dp[n][r]= (solve(n-1, r-1)+solve(n-1, r));
		}
	}
	public static int NCr(int n,int r) {
		dp=new int[n+1][r+1];
		for(int i=0;i<=n;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int ans=solve(n, r);
		for(int i=0;i<=n;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return ans;
		
	}
	public static void main(String[] args) {
		System.out.println(NCr(66, 12));
	}
}
