package LeetCode;

import java.util.Arrays;

public class LeetCode64 {
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		dp=new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		return dfs(grid, n, m, 0, 0);
	}
	static int dp[][]=null;
	public int dfs(int[][] grid, int n, int m, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m) {
			return Integer.MAX_VALUE;
		}
		if(i==n-1&&j==m-1) {
			return grid[i][j];
		}
		if(dp[i][j]!=Integer.MAX_VALUE) {
			return dp[i][j];
		}
		int ans=Integer.MAX_VALUE;
		int right=dfs(grid, n, m, i+1, j);
		int down=dfs(grid, n, m, i, j+1);
		ans=Math.min(ans, grid[i][j]+Math.min(right, down));
	
		return 	dp[i][j]=ans;
		
	}
	//bottom up
	
	public int minPathSumbottomUp(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int result[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				result[i][j]=Integer.MAX_VALUE;
				if(i==0&&j==0) {
					result[i][j]=grid[i][j];
				}
				else if(i==0) {
					result[0][j]=Math.min(grid[0][j]+result[0][j-1],result[0][j] );
				}
				else if(j==0) {
					result[i][0]=Math.min(grid[i][0]+result[i-1][0],result[j][0] );
				}else {
					result[i][j]=Math.min(grid[i][j]+result[i-1][j],grid[i][j]+result[i][j-1]);
				}
			}
		}
		return result[n-1][m-1];
		
	}
}
