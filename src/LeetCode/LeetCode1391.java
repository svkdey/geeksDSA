package LeetCode;

public class LeetCode1391 {
	static int dir[][]= {
            {1,0,1,0},
            {0,1,0,1},
            {1,0,0,1},
            {0,0,1,1},
            {1,1,0,0},
            {0,1,1,0}
        };
	static int move[][]= {
		  {0,-1},{-1,0},{0,1},{1,0}
        };
	
	
	private boolean dfs(int[][] grid, int i, int j, int m, int n) {
		if(i==m-1&&j==n-1) {
			return true;
		}
		int currentVal=grid[i][j];
		grid[i][j]=-1;
		for(int k=0;k<4;k++) {
			int dx=i+move[k][0];
			int dy=j+move[k][1];
			if(dx>=0&&dx<m&&dy>=0&&dy<n&&grid[dx][dy]!=-1) {
				if(dir[currentVal-1][k]==1 && dir[currentVal-1][k]==dir[grid[dx][dy]-1][(k+2)%4]) {
					if(dfs(grid, dx, dy, m,n)) {
						return true;
					}
				}
			}
			
		}
		return false;
	}
	 private void dfs2(int[][] grid, int i, int j, int m, int n, boolean v[][]) {
			if (i < 0 || i >= m || j < 0 || j >= n || v[i][j]) {
				return;
			}
			v[i][j] = true;
			if (grid[i][j] == 1) {
				dfs2(grid, i, j+1, m, n, v);
//				dfs(grid, i, j-1, m, n, v);
			}

			else if (grid[i][j] == 2) {
				dfs2(grid, i+1, j, m, n, v);
			}
			else if (grid[i][j] == 3) {
				dfs2(grid, i-1, j+1, m, n, v);
			}
			else if (grid[i][j] == 4) {
				dfs2(grid, i+1, j+1, m, n, v);
			}
			else if (grid[i][j] == 5) {
				dfs2(grid, i-1, j-1, m, n, v);
			}
			else if (grid[i][j] == 6) {
				dfs2(grid, i-1, j+1, m, n, v);
//				dfs(grid, i-1, j, m, n, v);
			}
		}

	public boolean hasValidPath(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		
		return dfs(grid, 0, 0, m, n);
		
	
	}

	public static void main(String[] args) {
		LeetCode1391 s = new LeetCode1391();
		int grid[][] = { { 1, 1, 1, 1, 1, 1, 3 } };
		System.out.println(s.hasValidPath(grid));
	}
}
