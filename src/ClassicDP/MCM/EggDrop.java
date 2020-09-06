package ClassicDP.MCM;

import java.util.Arrays;

public class EggDrop {
	static int dp[][] = null;
	public static int solve(int eggs, int floor) {
		if (eggs == 1) {
			return floor;
		}
		if (floor == 0 || floor == 1)
			return floor;
		if (dp[eggs][floor] != -1) {
			return dp[eggs][floor];
		}
		int val = Integer.MAX_VALUE;
		for (int k = 1; k < floor; k++) {
			int tempAns = 1 + Math.max(solve(eggs - 1, k - 1), solve(eggs, floor - k));

			val = Math.min(val, tempAns);
		}
		return dp[eggs][floor] = val;
	}

	

	public static int superEggDrop(int eggs, int floor) {
		dp = new int[eggs + 1][floor + 1];
		for(int i=0;i<=eggs;i++) {
			Arrays.fill(dp[i], -1);
		}
		int ans= solve(eggs, floor);
		for(int i=0;i<=eggs;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return ans;
	}

	public static void main(String[] args) {

		System.out.println(superEggDrop(6, 1000));
	}
}
