package LeetCode;

public class LeetCode1267 {
	public int countServers(int[][] grid) {
		int totalConnected = 0;
		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					int ans=dfsI(grid, i, j, n, m);
					totalConnected+=ans==1?0:ans;
				}
			}
		}
		return totalConnected;
	}

	static int ans = 0;

	public int dfsI(int[][] grid, int i, int j, int n, int m) {
		if (i < 0 || i >= n || j < 0 || j >= m) {
			return 0;
		}
		grid[i][j]=0;
		int res=1;
		for(int k=0;k<n;k++) {
			if(grid[k][j]==1) {
				res+=dfsI(grid, k, j, n, m);
			}
		}
		for(int k=0;k<m;k++) {
			if(grid[i][k]==1) {
				res+=dfsI(grid, i, k, n, m);
			}
		}
	return res;
		
	}
	
}
