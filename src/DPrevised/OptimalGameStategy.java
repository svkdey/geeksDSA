package DPrevised;

import java.util.Arrays;

public class OptimalGameStategy {
	public static int solve(int points[], int i, int j) {
		if (i + 1 == j) {
			return Math.max(points[i], points[j]);
		}
		return Math.max(points[i] + Math.max(solve(points, i + 2, j), solve(points, i + 1, j - 1)),
				points[j] + Math.max(solve(points, i, j - 2), solve(points, i + 1, j - 1)));

	}

	static int dp[][] = new int[1000][1000];

	public static int topDown(int points[], int i, int j) {
		if (i + 1 == j) {
			return Math.max(points[i], points[j]);
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		dp[i][j] = Math.max(points[i] + Math.max(solve(points, i + 2, j), solve(points, i + 1, j - 1)),
				points[j] + Math.max(solve(points, i, j - 2), solve(points, i + 1, j - 1)));
		return dp[i][j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++) {
			Arrays.fill(dp[i], -1);
		}
		int points[]= {2,4,5,1};
		System.out.println(topDown(points,0,points.length-1));
	}

}
