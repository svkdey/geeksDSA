package CodeForces;

import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatoes {
	static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Coordinate [x=" + x + ", y=" + y + "]";
		}
		
	}
	private static boolean check(int x,int y,int n,int m) {
		if(x>=0&&x<n&&y>=0&&y<m) {
			return true;
		}else {
			return false;
		}
	}
	public static int solve(int grid[][]) {
		int n = grid.length;
		int m = grid[0].length;
		Queue<Coordinate> q = new LinkedList<Coordinate>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					q.add(new Coordinate(i, j));
				}
			}
		}
		int ans = 0;
		int time=2;
		while (!q.isEmpty()) {

			int size = q.size();
			ans++;
			time++;
			for (int i = 0; i < size; i++) {
				Coordinate pos=q.remove();
				int pos_x=pos.x;
				int pos_y=pos.y;
				if(check(pos_x+1,pos_y,n,m)&&grid[pos_x+1][pos_y]==1) {
					grid[pos_x+1][pos_y]=time;
					
					q.add(new Coordinate(pos_x+1,pos_y));
				}
				
				if(check(pos_x-1,pos_y,n,m)&&grid[pos_x-1][pos_y]==1) {
					grid[pos_x-1][pos_y]=time;
					q.add(new Coordinate(pos_x-1,pos_y));
				}
				
				if(check(pos_x,pos_y+1,n,m)&&grid[pos_x][pos_y+1]==1) {
					grid[pos_x][pos_y+1]=time;
					q.add(new Coordinate(pos_x,pos_y+1));
				}
				
				if(check(pos_x,pos_y-1,n,m)&&grid[pos_x][pos_y-1]==1) {
					grid[pos_x][pos_y-1]=time;
					q.add(new Coordinate(pos_x,pos_y-1));
				}
			}
		}
		boolean isNotInfected=false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					isNotInfected=true;
				}
				ans=Integer.max(ans,grid[i][j]);
			}
		}
		if(isNotInfected) {
			ans=0;
		}else {
			ans=ans-2;
		}
		
		System.out.println(ans);
		return ans;
		

	}
	public static void main(String[] args) {
		int grid[][]= {{2,1,1},{0,1,0},{1,0,1}};
		solve(grid);
	}

}
