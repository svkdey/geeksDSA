package DPrevised;

import java.util.Arrays;

public class NcoinProbability {
	// Head> tails so we can say we need at least (n+1)/2 H for a particular trail
	static double dp[][] = null;

	public static double ncoinProbability(double p[], int numberOfcoins, int numberOfHeads) {
		if (numberOfHeads == 0) { //we need to make this base test case at first
			return 1;
		}
		if (numberOfcoins == 0) {
			return 0;
		}
		
		if(dp[numberOfcoins][numberOfHeads]!=(double)-1){
			return dp[numberOfcoins][numberOfHeads];
		}
		dp[numberOfcoins][numberOfHeads]= (p[numberOfcoins - 1] * ncoinProbability(p, numberOfcoins - 1, numberOfHeads - 1))
				+ ((1 - p[numberOfcoins - 1]) * ncoinProbability(p, numberOfcoins - 1, numberOfHeads));
		return dp[numberOfcoins][numberOfHeads];
	}

	public static void main(String[] args) {
		double probability[] = { 0.3, 0.6, 0.8 };

		int n = probability.length;
		int m = (n + 1) / 2; // >=50% heads
		dp = new double[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], (double) -1);
		}
		System.out.println(ncoinProbability(probability, n, m));
	}
}
