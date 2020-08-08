package DPrevised;

public class NumberOfWays {
	public static int numberOfWays(int coins[], int numberOfCoins, int targetSum) {
		if (targetSum == 0) {
			return 1;
		}
		if (targetSum < 0 || numberOfCoins <= 0) {
			return 0;
		}

		int ans = numberOfWays(coins, numberOfCoins - 1, targetSum)
				+ numberOfWays(coins, numberOfCoins, targetSum - coins[numberOfCoins - 1]);

		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = { 1, 7, 10 };
		System.out.println(numberOfWays(coins, coins.length, 15));
	}

}
