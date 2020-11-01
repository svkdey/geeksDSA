package LeetCode.InterviewPrep;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	int dp[][] = null;

	int ncr(int n, int r) {
		if (n == r || r == 0) {
			return dp[n][r] = 1;
		}
		if (dp[n][r] != 0) {
			return dp[n][r];
		}
		return dp[n][r] = ncr(n - 1, r - 1) + ncr(n - 1, r);
	}

	public List<List<Integer>> generate(int n) {
		dp = new int[2*n+1][n+1];
		ncr(2*n, n);
		dp[0][0]=1;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			List<Integer> l = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				l.add(dp[i][j]);
			}
			ans.add(l);
		}
		return ans;
	}
	public static void main(String[] args) {
		PascalTriangle p=new PascalTriangle();
		System.out.println(p.generate(20));
	}
}
