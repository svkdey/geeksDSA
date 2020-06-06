package Algorithms.DynamicProblems;

public class MinimumNumberCoin {
	public static int MinimumNumberCoinImpl(int[] coins, int sum, int n) {
		if (n <= 0&&sum>=0) {
			return 0;
		}
		if (sum < 0) {
			return 0;
		}
		if (sum == 0) {
			return 1;
		}
		
		int res=MinimumNumberCoinImpl(coins, sum, n - 1)+MinimumNumberCoinImpl(coins, sum - coins[n - 1], n - 1);
//		return Math.min(res,MinimumNumberCoinImpl(coins, sum, n - 1));
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[]= {2, 5, 3, 6};
		System.out.println(MinimumNumberCoinImpl(coins, 10, coins.length));
	}

}
