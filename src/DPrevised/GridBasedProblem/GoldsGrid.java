package DPrevised.GridBasedProblem;

import java.util.Arrays;

public class GoldsGrid {
	// note that we are taking dp[x-1][y-1] 2times 1 .for 1. memo[i-1][j]
	// 2.memo[i][j-j]
//	so we need to take it once
	public static void solve(int grid[][], int N) {
		int memo[][] = new int[N][N];
		memo[0][0] = grid[0][0];
		for (int i = 1; i < N; i++) {
			memo[i][0] = memo[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < N; i++) {
			memo[0][i] = memo[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				int i_j_1 = memo[i][j - 1];
				int i_1_j = memo[i - 1][j];
				int i_1_j_1 = memo[i - 1][j - 1];
				memo[i][j] = i_j_1 + i_1_j - i_1_j_1 + grid[i][j];

			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
		int ans=Integer.MIN_VALUE;
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				int cell = memo[i][j];
				int right = memo[N-1][j];
				int left = memo[i][N-1];
				int last = memo[N - 1][N - 1]+cell-right-left;
//				System.out.println(cell+"->"+left+"->"+right+"->"+last);
				ans= Math.max(ans,Math.min(cell,Math.min(right,Math.min(left,last))));
//				System.out.println(ans);
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int goldMatrix[][] = { { 1, 0, 1, 1 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } };
		solve(goldMatrix, goldMatrix.length);

	}

}
