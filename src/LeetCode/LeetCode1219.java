package LeetCode;

import java.util.*;

public class LeetCode1219 {
	static class GoldSpot {
		int x, y, weight;

		public GoldSpot(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "GoldSpot [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
	}

	public static int getMaximumGold(int[][] grid) {
		ArrayList<GoldSpot> list = new ArrayList<LeetCode1219.GoldSpot>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != 0) {
					list.add(new GoldSpot(i, j, grid[i][j]));
				}
			}
		}
		System.out.println(list);
		int ans = Integer.MIN_VALUE;
		boolean v[][]=new boolean[grid.length][grid[0].length];
		for (GoldSpot g : list) {
			ans = Math.max(ans, dfs(grid, g.x,g.y, grid.length, grid[0].length,v));
		}
		return ans;
	}

	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static int dfs(int[][] grid,int i, int j, int n, int m,boolean v[][]) {
		if(i<0||i>=n||j<0||j>=m||v[i][j]||grid[i][j]==0) {
			return 0;
		}
		v[i][j]=true;
		int op1=0,op2=0,op3=0,op4=0;
		op1=dfs(grid, i+1, j, n, m, v);
		op2=dfs(grid, i-1, j, n, m, v);
		op3=dfs(grid, i, j+1, n, m, v);
		op4=dfs(grid, i, j-1, n, m, v);
		v[i][j]=false;
		return grid[i][j]+Math.max(op1, Math.max(op2,Math.max(op3, op4)));
		
	}

	public static void main(String[] args) {
		int grid[][] = { 
				{ 1, 0, 7, 0, 0, 0 }, 
				{ 2, 0, 6, 0, 1, 0 }, 
				{ 3, 5, 6, 7, 4, 2 },
				{ 4, 3, 1, 0, 2, 0 },
				{ 3, 0, 5, 0, 20, 0 } };
		System.out.println(getMaximumGold(grid));
	}
}
