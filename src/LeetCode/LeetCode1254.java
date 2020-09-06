package LeetCode;

public class LeetCode1254 {
	 public int closedIsland(int[][] grid) {
	        int n=grid.length;
	        int m=grid[0].length;
	        for(int i=0;i<n;i++) {
	        	for(int j=0;j<m;j++) {
	        		if(i==0||j==0||i==n-1||j==m-1) {
	        			if(grid[i][j]==0) {
	        				floodFill(grid,i,j,n,m);
	        			}
	        		}
	        	}
	        }
	        int ans=0;
	        for(int i=0;i<n;i++) {
	        	for(int j=0;j<m;j++) {
	        			if(grid[i][j]==0) {
	        				ans++;
	        				floodFill(grid,i,j,n,m);
	        			}
	        		}
	        	
	        	}
	       
	        return ans;
	    }
	 public void floodFill(int[][] grid,int i,int j,int n,int m) {
		 if(i<0||i>=n||j<m||j>=m||grid[i][j]==1) {
			 return ;
		 }
		 grid[i][j]=1;
		 floodFill(grid, i+1, j, n, m);
		 floodFill(grid, i-1, j, n, m);
		 floodFill(grid, i, j-1, n, m);
		 floodFill(grid, i, j+1, n, m);
	 }
}
