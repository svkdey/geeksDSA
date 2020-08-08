package DPrevised;

import java.util.Arrays;

public class RoddCuttingMaxProfit {
	static int memo[] = null;

	public static int solve(int prices[], int length) {

		if (length == 0)
			return 0;

		if (memo[length] != 0) {
			return memo[length];
		}
		int best = 0;
		for (int i = 1; i <= length; i++) {
			int net = prices[i] + solve(prices, length - i);
			best = Math.max(best, net);
		}
		memo[length] = best;
		return memo[length];
	}

	public static void main(String[] args) {
		memo = new int[100];

		int prices[] = { 0, 2, 3, 2, 5 };

		System.out.println(solve(prices, 4));
		System.out.println(Arrays.toString(memo));
	}

}
