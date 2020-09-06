package ClassicDP.Knapsac01;
//1049. Last Stone Weight II
public class CountOfMinimumDiffSubset {
	public static void solve(int arr[]) {
		int sum = 0;
		for (int x : arr) {
			sum += x;
		}
		boolean dp[][] = new boolean[arr.length + 1][sum + 1];
		for (int i = 0; i <= arr.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j >= arr[i - 1]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		int half = sum / 2;
		int oneSide = 0;
		for (int i = 1; i <= half; i++) {
			if (dp[arr.length][i]) {
				oneSide = i;
			}
		}
		System.out.println(oneSide);
		System.out.println(sum - oneSide);
//		return dp[arr.length][target];
	}

	public static void main(String[] args) {
		int stones[] = { 2, 7, 4, 1, 8, 1 };
		solve(stones);
	}
}
