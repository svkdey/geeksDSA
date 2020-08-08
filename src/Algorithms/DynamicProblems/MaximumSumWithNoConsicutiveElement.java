package Algorithms.DynamicProblems;

//o(2^n)
public class MaximumSumWithNoConsicutiveElement {
	public static int MaximumSumWithNoConsicutiveElementImplRecursive(int arr[], int n) {
		if (n == 1)
			return arr[0];
		else if (n == 2)
			return Math.max(arr[0], arr[1]);
		else
			return Math.max(MaximumSumWithNoConsicutiveElementImplRecursive(arr, n - 1),
					MaximumSumWithNoConsicutiveElementImplRecursive(arr, n - 2) + arr[n - 1]);
	}

//	o(n)
	public static int MaximumSumWithNoConsicutiveElementImplDP(int arr[], int n) {
		int dp[] = new int[n + 1];
		dp[0] = Integer.MAX_VALUE;
		dp[1] = arr[0];
		dp[2] = Math.max(arr[0], arr[1]);
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[n - 1], arr[n - 1] + dp[n - 2]);
		}
		return dp[n];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 10, 5, 15, 20 };
		System.out.println(MaximumSumWithNoConsicutiveElementImplRecursive(arr, arr.length));
		System.out.println(MaximumSumWithNoConsicutiveElementImplDP(arr, arr.length));
	}

}
