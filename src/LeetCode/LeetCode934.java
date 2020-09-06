package LeetCode;

import java.util.*;

public class LeetCode934 {
	boolean check(int arr[][], int i, int j) {
		int n = arr.length;
		int m = arr[0].length;
		if (i - 1 >= 0) {
			if (arr[i - 1][j] == 1) {
				return false;
			}
		}
		if (i + 1 < n) {
			if (arr[i + 1][j] == 1) {
				return false;
			}
		}
		if (j + 1 < m) {
			if (arr[i][j + 1] == 1) {
				return false;
			}
		}
		if (j - 1 >= 0) {
			if (arr[i][j - 1] == 1) {
				return false;
			}
		}
		return true;

	}

	class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	int ans = 0;

	public int shortestBridge(int[][] A) {
		ans = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 1 && check(A, i, j)) {
				
					bfs(A, i, j, A.length, A[0].length);
				}
			}

		}
		return ans;
	}

	public void  bfs(int arr[][],int x,int y,int n,int m) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		int dir[][]= {{1,0},{-1,0},{0,-1},{0,1}};
		boolean inLandFound=false;
		int h=0;
		boolean vis[][]=new boolean[n][m];
		
		vis[x][y]=true;
		while(!q.isEmpty()) {
			int s=q.size();
			for(int i=0;i<s;i++) {
				int point[]=q.remove();
				
				for(int d[]:dir) {
					int r=point[0]+d[0];
					int c=point[1]+d[1];
					
					if(r>=0&&r<n&&c>=0&&c<m&&!vis[r][c]) {
						if(arr[r][c]==1) {
							inLandFound=true;break;
						}
						
						vis[r][c]=true;
						q.add(new int[] {r,c});
					}
				}
			}
			if(inLandFound) {
				break;
			}
			h++;
		}
		ans+=h;
	}

}
