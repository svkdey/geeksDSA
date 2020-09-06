package LeetCode;

import java.util.PriorityQueue;

public class LeetCode1049 {
	 public static int lastStoneWeightII(int[] arr) {
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
			int otherSide=sum-oneSide;
			return Math.abs(otherSide-oneSide);
	    }
	 public static void main(String[] args) {
		 int stones[]= {2,7,4,1,8,1};
		System.out.println(lastStoneWeightII(stones));
	}
}
