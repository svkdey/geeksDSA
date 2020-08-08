package DPrevised;

public class TheSubArraySumPresent {
	public static boolean subArraySumPresent(int arr[], int tareget) {
		long sum = 0;
		for (int x : arr) {
			sum += x;
		}
		int n = arr.length;
		boolean dp[][] = new boolean[n + 1][(int) sum + 1];
		for (int i = 0; i < sum + 1; i++) {
			dp[0][i] = false;
		}

		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j >= arr[i - 1]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]; //for count of sub arr replace or by +
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}

		
		boolean[] lastRow = dp[n];
		System.out.println(lastRow[tareget ]);
		return lastRow[tareget ];

	}

	public static void main(String[] args) {
		int arr[] = { 100, 100, 99, 99 };
		subArraySumPresent(arr,200);
	}

}
