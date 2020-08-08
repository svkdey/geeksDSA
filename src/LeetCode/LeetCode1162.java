package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class LeetCode1162 {
	static class Co {
		int x, y;

		public Co(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Co [x=" + x + ", y=" + y + "]";
		}

	}
	static int max = 0;
	public static int maxDistance(int[][] grid) {
		max=0;
		int n = grid.length;
		int m = grid[0].length;
		int dist[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					dist[i][j]=0;
					bfs(grid, i, j, n, m,dist);
					
				
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max=Math.max(max, dist[i][j]);
			}
		}
		System.out.println(max);
		return max;
	}

	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void bfs(int[][] grid, int i, int j, int n, int m,int result[][]) {
		Queue<Co> q = new LinkedList<Co>();
		q.add(new Co(i, j));
		boolean visited[][]=new boolean[n][m];
		visited[i][j]=true;
		while (!q.isEmpty()) {
			int s = q.size();
			for (int k = 0; k < s; k++) {
				Co pos = q.remove();
				
				for (int p = 0; p < dir.length; p++) {
					int dr = dir[p][0] + pos.x;
					int dc = dir[p][1] + pos.y;
				
					if (dr >= 0 && dr < n && dc >= 0 && dc < m&&grid[dr][dc]==0&&!visited[dr][dc]) {
						result[dr][dc]=Math.min(result[pos.x][pos.y]+1,result[dr][dc]);
						
						q.add(new Co(dr, dc));
						visited[dr][dc]=true;
						
					}

				}
			}
			

		}
		
		
	}
	public static void main(String[] args) {
		int grid[][]= {{0,0,0},{0,0,0},{0,0,0}};
		maxDistance(grid);
	}
}
