package DPrevised;

import java.util.Arrays;

public class FriendsPairing {
	static int dp[] = new int[100];

	public static int solve(int n) {
		if (dp[n] != -1) {
			return dp[n];
		}

		dp[n] = solve(n - 1) + (n - 1) * solve(n - 2);
		return dp[n];
	}

	public static void main(String[] args) {
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		System.out.println(solve(3));

	}

}
