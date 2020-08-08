package DPrevised;

public class KStones {
	public static String solve(int moves[], int k) {
		int dp[] = new int[k + 1];
		for (int i = 1; i <= k; i++) {
			for (int move : moves) {
				if (i > move && dp[i - move] == 0) {
					dp[i] = 1;
				}
			}
		}
		return dp[k] == 1 ? "first" : "second";
	}
}
