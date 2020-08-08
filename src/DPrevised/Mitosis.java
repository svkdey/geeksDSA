package DPrevised;

// moves -> i-> 2i ,i+1 ,i-1
public class Mitosis {
	public static int solve(int x, int y, int z, int finalCellNumber) {
		int dp[] = new int[finalCellNumber + 1];

		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= finalCellNumber; i++) {
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i - 1] + y, dp[i / 2] + x);
			} else {
				dp[i] = Math.min(dp[i - 1] + y, dp[(i + 1) / 2] + x + z);
			}
		}
		return dp[finalCellNumber];
	}

	public static void main(String[] args) {
		System.out.println(solve(2,1,3,5));
	}
}
