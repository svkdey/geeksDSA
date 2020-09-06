package ClassicDP.Knapsac01;

import java.util.Arrays;

public class BasicKnapsac {
	static int dp[][] = null;

	public static int bottomUP(int totalItems, int targetW, int W[], int V[]) {
		dp = new int[totalItems + 1][targetW + 1];
		// intital case
		for (int i = 0; i <= totalItems; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= targetW; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i <= totalItems; i++) {
			for (int w = 1; w <= targetW; w++) {
				if (w - W[i - 1] >= 0) {
					dp[i][w] = Math.max(dp[i - 1][w], V[i - 1] + dp[i - 1][w - W[i - 1]]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		for (int i = 0; i <= totalItems; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[totalItems][targetW];

	}
}
