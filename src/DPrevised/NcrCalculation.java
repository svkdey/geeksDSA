package DPrevised;

public class NcrCalculation {
	/**
	 *  formulae:nCr f(n,r)=f(n-1,r-1)+f(n-1,r)
	 *  if( n==r||r==0) return 1;
	 *
	 *	nPr : r!(nCr)
	 *
	 **/
	static int dp[][]=new int[1000][1000];
	public static int nCr(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		} 
		if(dp[n][r]!=0) {
			return dp[n][r];
		}
		dp[n][r]= nCr(n - 1, r - 1) + nCr(n - 1, r);
		return dp[n][r];
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(nCr(8,6));
	}
}
