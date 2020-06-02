package Algorithms.DynamicProblems;

public class CatalanNumber {
	public static long[] fillNumber(long dp[],int n) {
		for(int i=2;i<=n;i++) {
			dp[i]=i*dp[i-1];
		}
		return dp;
	}
	
	public static void CatalanNumber(int n) {
		long dp[]=new long[2*n+1];
		dp[0]=1;
		dp[1]=1;

		fillNumber(dp,2*n);
//		System.out.println(Arrays.toString(dp));
		long ans= (dp[2*n]/((n+1)*dp[n]*dp[n]));
		System.out.println(ans);
	}
	public static void main(String[] args) {
		CatalanNumber(4);
	}
}

