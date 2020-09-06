package ClassicDP.unboundKnapsac;

import java.util.Arrays;

public class TotalNumberOfCoinChange {
	public static int totalNumberOfCoinChange(int coins[], int sum) {
		int t[][] = new int[coins.length + 1][sum + 1];
		for (int i = 0; i < sum + 1; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i < coins.length + 1; i++) {
			t[i][0] = 1;
		}
		for (int i = 0; i <= coins.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		System.out.println();
		for (int i = 1; i < coins.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (j - coins[i - 1] >= 0) {
					t[i][j] = t[i - 1][j] + t[i][j - coins[i-1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		for (int i = 0; i <= coins.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		return t[coins.length][sum];
	}
	public static void main(String[] args) {
		int amount = 5, coins[] = {10};
		System.out.println(totalNumberOfCoinChange(coins,amount));
	}
}
