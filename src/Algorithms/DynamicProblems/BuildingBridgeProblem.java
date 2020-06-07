package Algorithms.DynamicProblems;

import java.util.Arrays;
import java.util.Comparator;

import Utility.Utils;

public class BuildingBridgeProblem {
	static class Bridge {
		int south;
		int north;

		public Bridge(int n, int s) {
			// TODO Auto-generated constructor stub
			south = s;
			north = n;
		}

		@Override
		public String toString() {
			return "Bridge [south=" + south + ", north=" + north + "]";
		}

	}

	/**
	 * Approach: It is a variation of LIS problem. The following are the steps to
	 * solve the problem.
	 * 
	 * Sort the north-south pairs on the basis of increasing order of south
	 * x-coordinates. If two south x-coordinates are same, then sort on the basis of
	 * increasing order of north x-coordinates. Now find the Longest Increasing
	 * Subsequence of the north x-coordinates. One thing to note that in the
	 * increasing subsequence a value can be greater as well as can be equal to its
	 * previous value
	 * 
	 * 
	 **/
	public static int BuildingBridgeProblemSolution(Bridge[] bridges, int n) {
		//sorting
		Comparator<Bridge> s = (a, b) -> {
			if (a.south == b.south) {
				return a.north - b.north;
			} else {
				return a.south - b.south;
			}
		};

		Arrays.sort(bridges, s);
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		//LIS calculator
		for (int i = 1; i < n; i++) {
			int res = Integer.MIN_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				if (bridges[i].north > bridges[j].north) {
					res = Math.max(res, dp[j]);
				}
			}
			if (res != Integer.MIN_VALUE) {
				dp[i] = res + 1;
			} else {
				dp[i] = 1;
			}
		}
		int result = dp[0];
		for (int i = 1; i < n; i++) {
			result = Math.max(result, dp[i]);
		}
		return result;

	}

	public static void main(String[] args) {
		int bridges[][] = { { 6, 2 }, { 4, 3 }, { 2, 6 }, { 1, 5 } };
		Bridge[] briges_ = new Bridge[bridges.length];
		int i = 0;
		for (int[] brige : bridges) {
			briges_[i] = new Bridge(brige[0], brige[1]);
			i++;
		}
		System.out.println(Arrays.toString(briges_));
		System.out.println(BuildingBridgeProblemSolution(briges_, briges_.length));
	}

}
