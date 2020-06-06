package Algorithms.DynamicProblems;

public class NumberOfHopsByFrog {
	static int count;

	static int numberofhops(int target) {
		if (target < 0) {
			return 0;

		}
		if (target == 0) {
			return 1;

		} else {
			return numberofhops(target - 1) + numberofhops(target - 2) + numberofhops(target - 3);
		}
	}

	static long numberofhopDPs(long target) {
		long dp[] = new long[((int) target) + 1];
		dp[0] = 1;
		dp[1] = 1;
		if (target > 1) {
			dp[2] = 2;
			for (int i = 3; i <= target; i++) {
				dp[i] = (dp[i - 2] % 1000000007 + dp[i - 1] % 1000000007 + dp[i - 3] % 1000000007) % 1000000007;
			}

		}
		return dp[(int) target];

	}

	public static void main(String[] args) {

		System.out.println(numberofhops(3));
		System.out.println(numberofhops(4));
		System.out.println(numberofhops(5));
		System.out.println(numberofhops(6));
		System.out.println("-----------------------");
		System.out.println(numberofhopDPs(1));
		System.out.println(numberofhopDPs(2));
		System.out.println(numberofhopDPs(3));
		System.out.println(numberofhopDPs(4));
		System.out.println(numberofhopDPs(5));
		System.out.println(numberofhopDPs(6));
	}
}
