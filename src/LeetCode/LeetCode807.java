package LeetCode;

import java.util.Arrays;

public class LeetCode807 {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int row[] = new int[n];
		int col[] = new int[m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				row[i]=Math.max(row[i], grid[i][j]);
				col[j]=Math.max(col[j], grid[i][j]);
			}
		}
		
		int ans=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==col[i]) {
					continue;
				}
				if(grid[i][j]==row[j]) {
					continue;
				}
				else {
					ans+=Math.min(col[i],row[j])-grid[i][j];
				}
			}
		}
		return ans;
	}
}
