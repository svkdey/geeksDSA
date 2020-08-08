package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode886 {
	public boolean possibleBipartition(int N, int[][] dislikes) {
		isBipartile = true;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());

		}
	     
		for (int x[] : dislikes) {
			graph.get(x[0]).add(x[1]);
			graph.get(x[1]).add(x[0]);
		}
		
		  System.out.println(graph); 
		int colors[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (colors[i] == 0) {
				dfs(graph, colors, i, 1, -99);
			}
		}
		System.out.println(Arrays.toString(colors));
		return isBipartile;
	}

	static boolean isBipartile = true;

	public void dfs(ArrayList<ArrayList<Integer>> graph, int colors[], int src, int color, int parent) {
		colors[src] = color;
		for (int child : graph.get(src)) {
			if (colors[child] == 0) {
				dfs(graph, colors, child,3- color, src);
			} else {
				if (child != parent && colors[child] == color) {
					isBipartile = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		int N = 4; int dislikes[][] = {{1,2},{1,3},{2,4}};
		LeetCode886 s=new LeetCode886();
		s.possibleBipartition(N,dislikes);
	}
}
