package Algorithms.DynamicProblems;

import java.util.Arrays;
import java.util.Comparator;

/*
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs.
Source: Amazon Interview | Set 2

For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }, then the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}*/
public class MaxLengthOfChain {
	static class Pair {
		int a;
		int b;

		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Pair [a=" + a + ", b=" + b + "]";
		}

	}
	/*
	 * This problem is a variation of standard Longest Increasing Subsequence
	 * problem. Following is a simple two step process. 1) Sort given pairs in
	 * increasing order of first (or smaller) element. Why do not need sorting?
	 * Consider the example {{6, 8}, {3, 4}} to understand the need of sorting.
	 * 
	 * If we proceed to second step without sorting, we get output as 1. But the
	 * correct output is 2. 2) Now run a modified LIS process where we compare the
	 * second element of already finalized LIS with the first element of new LIS
	 * being constructed.
	 * 
	 */

	public static int MaxLengthOfChainSolve(Pair numberSet[], int n) {
		System.out.println(Arrays.toString(numberSet));
		Comparator<Pair> c = (o1, o2) -> o1.a - o2.a;

		Arrays.sort(numberSet, c);
		System.out.println(Arrays.toString(numberSet));
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			int res = Integer.MIN_VALUE;

			for (int j = i - 1; j >= 0; j--) {
				if (numberSet[i].a > numberSet[j].b) {
					res = Math.max(res, dp[j]);
				}
			}
			if (res != Integer.MIN_VALUE) {
				dp[i] = res + 1;
			} else {
				dp[i] = 1;
			}
		}
		int res = dp[0];
		for (int i = 1; i < n; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		Pair arr[] = new Pair[] { new Pair(27, 40), new Pair(50, 60), new Pair(5, 24), new Pair(15, 25), };
		System.out.println(MaxLengthOfChainSolve(arr, arr.length));
	}
}
