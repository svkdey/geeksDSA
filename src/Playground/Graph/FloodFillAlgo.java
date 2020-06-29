package Playground.Graph;

import java.util.Arrays;

public class FloodFillAlgo {
	public static void floodfillALgoImpl(int image[][], int i, int j, int color) {
		int n = image.length;
		int m = image[0].length;
		boolean visited[][] = new boolean[n][m];
		dfs(image, i, j, color, n, m, visited);

		for (int k = 0; k < n; k++) {
			System.out.println(Arrays.toString(image[k])
					);
		}
	}
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	private static void dfs(int image[][], int i, int j, int color, int n, int m, boolean visited[][]) {
		if (i < 0 || i >= n || j < 0 || j >= m || image[i][j] == 0 || visited[i][j]) {
			return;
		}
		image[i][j] = color;
		visited[i][j] = true;
		for(int k=0;k<4;k++) {
			dfs(image, i+dx[k], j+dy[k], color, n, m, visited);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int image[][]= {{1,1,1},{1,1,0},{1,0,1}};
		floodfillALgoImpl(image, 1, 1, 2);
	}

}
