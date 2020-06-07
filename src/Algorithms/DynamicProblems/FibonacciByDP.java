package Algorithms.DynamicProblems;

import java.util.Arrays;

public class FibonacciByDP {
	static int dp[] = new int[1000];

	public static void setDPArray() {
		for (int i = 0; i < 1000; i++) {
			dp[i] = -1;
		}
	}

	public static void resetDPArray() {
		for (int i = 0; i < 1000; i++) {
			dp[i] = -1;
		}
	}

	public static int findFibonacchiTopDown(int n) {
		if (dp[n] == -1) {
			int res = 0;
			if (n == 0 || n == 1) {
				res = n;
			} else {
				res = findFibonacchiTopDown(n - 1) + findFibonacchiTopDown(n - 2);

			}
			dp[n] = res;
		}
		return dp[n];

	}

	static int dp2[] = new int[1000];

	public static int findFibonacchiBottomUp(int n) {

		dp2[1] = 1;
		if (n > 1) {
			for (int i = 2; i <= n; i++) {
				System.out.println(dp2[i - 1] + " " + dp2[i - 2]);
				dp2[i] = (dp2[i - 1] + dp2[i - 2]);

			}
		}
		return dp2[n];

	}

	public static void main(String[] args) {

	}
}
