package ClassicDP.CatalanNumber;

import java.util.Arrays;

public class NumberOfUniqueBinaryTree {
	public static void solve(int n) {
		int dp[]=new int[n+1];
		
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<i;j++) {
				dp[i]+=dp[j]*dp[i-1-j];
			}
		}
		System.out.println(Arrays.toString(dp));
	}
	
	public static int solveRecusive(int n) {
		if(n<=1) return 1;
		int result=0;
		for(int i=0;i<n;i++) {
			result+=solveRecusive(i)*solveRecusive(n-i-1);
		}
		System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		solveRecusive(5);
	}
}
