package Algorithms.DynamicProblems;





//catalan sequence ===== >    1 1 2 5 14 42 132 429 1430 4862


//watch gfg for use of catalan number


public class CatalanNumber {
	public static long[] fillNumber(long dp[],int n) {
		for(int i=2;i<=n;i++) {
			dp[i]=i*dp[i-1];
		}
		return dp;
	}
	/**
	 *n>=0 
	 *catalan (n)= (2nCn)/(n+1)= 2n!/((n+1)n!n!);
	 *
	 *or 
	 *Co=1 ; Cn=Sumation of [ C(i)*C(n-i)] for 0<i<n 
	 *
	 *
	 *
	 **/
	public static void CatalanNumberDPbyFactorial(int n) {
		long dp[]=new long[2*n+1];
		dp[0]=1;
		dp[1]=1;

		fillNumber(dp,2*n);
//		System.out.println(Arrays.toString(dp));
		long ans= (dp[2*n]/((n+1)*dp[n]*dp[n]));
		System.out.println(ans);
	}
	public static int CatalanNumberRecusive(int n) {
		if(n<=1) return 1;
		int result=0;
		for(int i=0;i<n;i++) {
			result+=CatalanNumberRecusive(i)*CatalanNumberRecusive(n-i-1);
		}
		return result;
	}
	
	
	//	to find the dp soltion.. check count BST
	

	public static void main(String[] args) {
		System.out.println(CatalanNumberRecusive(5));
	}
}

