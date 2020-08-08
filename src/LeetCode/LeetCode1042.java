package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeetCode1042 {
	public int[] gardenNoAdj(int N, int[][] paths) {
		int color[] = new int[N];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int path[] : paths) {
			list.get(path[0] - 1).add(path[1] - 1);
			list.get(path[1] - 1).add(path[0] - 1);
		}
		System.out.println(list);
		for (int i = 0; i < N; i++) {
			if (color[i] == 0) {
				dfs(list, 1, color, i, N);
			}
		}
		return color;
	}

	public boolean dfs(ArrayList<ArrayList<Integer>> graph, int color, int colors[], int src, int N) {
		if (src == N) {
			return true;
		}
		for (int i = 1; i <= 4; i++) {
			if (isSafe(graph, i, colors, src)) {
				colors[src] = i;
				if (dfs(graph, color, colors, src + 1, N)) {
					return true;
				}
				colors[src] = 0;
			}
		}
		return false;
	}

	public boolean isSafe(ArrayList<ArrayList<Integer>> graph, int color, int colors[], int src) {
		for (int x : graph.get(src)) {
			if (colors[x] == color) {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		int path[][] = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
		LeetCode1042 s = new LeetCode1042();
		s.gardenNoAdj(3, path);
	}
}
