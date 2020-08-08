package DPrevised;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MiniMumCoins {
	public static int topDown(int coins[], int n, int target, Map<Integer, Integer> map) {
		if (target == 0)
			return 0;
		if (map.containsKey(target)) {
			return map.get(target);
		}
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (target - coins[i] >= 0) {
				int subProblem = topDown(coins, n, target - coins[i], map);
				ans = Math.min(subProblem, ans);

			}

		}
		ans = (ans == Integer.MAX_VALUE ? ans : ans + 1);
		map.put(target, ans);
		return ans;

	}

	static int dp[] = null;

	public static int bottomUp(int coins[], int n, int target) {
		dp[0]=0;
		for (int j = 1; j <= target; j++) {
			dp[j] = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (j - coins[i] >= 0) {
					int subProblem = dp[j - coins[i]];
					dp[j] = Math.min(subProblem+1, dp[j]);

				}

			}
		}
		return dp[target];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = { 1, 7, 10 };int target=15;
		Map<Integer, Integer> map = new HashMap<>();
		dp=new int[target+1]; 
		System.out.println(bottomUp(coins, coins.length, target));
		System.out.println(Arrays.toString(dp));
	}

}
