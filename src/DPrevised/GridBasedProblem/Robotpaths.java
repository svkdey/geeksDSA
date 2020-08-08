package DPrevised.GridBasedProblem;

import java.util.Arrays;

public class Robotpaths {
	//bottom up
	public static void solve(int grid[][], int n, int m) {
		int result[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == -1) {
					result[i][j] = 0;
				} else {
					if (i == 0) {
						if(j>0) {
							result[0][j]=result[0][j-1]!=0?1:0;
						}else {
							result[0][j]=1;
						}
					} else if (j == 0) {
						
						if(i>0) {
							result[i][0] = result[i - 1][0] != 0 ? 1 : 0;
						}else {
							result[i][0]=1;
						}
					} else
						result[i][j] = result[i - 1][j] + result[i][j - 1];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
	
	
	//in top down approach recusion goes to deep down searching for that n-1&&m-1 that causes invalid solution
	
//	static int dp[][]=null;
//	public static void topDown(int grid[][], int n, int m) {
//		dp = new int[n][m];
//		for(int i=0;i<n;i++) {
//			Arrays.fill(dp[i], -1);
//		}
//		for(int i=0;i<m;i++) {
//			if(grid[0][i]!=-1) {
//				if(i>0) {
//					dp[0][i]=dp[0][i-1]!=0?1:0;
//				}else {
//					dp[0][i]=1;
//				}
//			}else {
//				dp[0][i]=0;
//			}
//		}
//		
//		
//		for(int i=0;i<n;i++) {
//			if(grid[i][0]!=-1) {
//				if(i>0) {
//					dp[i][0]=dp[i-1][0]!=0?1:0;
//				}else {
//					dp[i][0]=1;
//				}
//			}else {
//				dp[i][0]=0;
//			}
//		}
//		
//		topDownUtil(grid, n, m,1,1);
//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//		
//		
//	}
//	public static int topDownUtil(int grid[][], int n, int m,int i,int j) {
//		if(i<0||i>=n||j<0||j>=m||grid[i][j]==-1) {
//			return 0;
//		}
//		if(i==n-1&&j==m-1) {
//			return 1;
//			 
//		}
//		if(dp[i][j]!=-1) {
//			return dp[i][j];
//		}
//		
//		dp[i][j]=topDownUtil(grid, n, m,i+1,j)+topDownUtil(grid, n, m,i,j+1);
//		return dp[i][j];
//		
//	}
	
	public static void main(String[] args) {
		int grid[][] = { { 0, 0, -1, 0 }, { 0, 0, 0, 0 }, { 0, -1, 0, -1 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 } };
		int n = grid.length;
		int m = grid[0].length;
		solve(grid, n, m);
	}

}
