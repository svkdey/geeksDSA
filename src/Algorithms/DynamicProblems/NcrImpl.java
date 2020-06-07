package Algorithms.DynamicProblems;

import java.util.Arrays;

/**
 * 1.A binomial coefficient C(n, k) can be defined as the coefficient of X^k in
 * the expansion of (1 + X)^n. 2.A binomial coefficient C(n, k) also gives the
 * number of ways, disregarding order, that k objects can be chosen from among n
 * objects; more formally, the number of k-element subsets (or k-combinations)
 * of an n-element set.
 * 
 * c(n,k)=c(n-1,k-1)+c(n-1,k);
 * c(n,0)=c(n,n)=1;
 **/
public class NcrImpl {

	public static int nCrModp(int n, int r) {
		if (r == n || r == 0) {
			return 1;
		} else {
			return nCrModp(n - 1, r - 1) + nCrModp(n - 1, r);
		}

	}

	public static void showTable(long dp[][]) {
		System.out.println("--------------------------------------");
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}

	public static long coEfficient(int n, int r) {
		long dp[][] = new long[n + 1][r + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= r; j++) {
				if (j == 0 || j == i) {
					dp[i][j] = 1;
				}
			}
		}
//		showTable(dp);
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= r; j++) {
				if (j != 0 || j != i) {
					if (i >= 1 && j >= 1) {
						dp[i][j] = (dp[i - 1][j - 1]) + (dp[i - 1][j]);
						dp[i][j] = dp[i][j] % 1000000007;
					}
				}
			}
		}

//	-	showTable(dp);
		return dp[n][r];

	}

	public static void main(String[] args) {
		System.out.println(coEfficient(5, 2));
	}

}
