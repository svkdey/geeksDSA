package DPrevised.GridBasedProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestPathSize {
	static int result[] = null;
	static int longPathSize = 0;

	public static void solve(ArrayList<ArrayList<Integer>> graph, int n, int m) {
		boolean v[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!v[i])
				dfsGraph(graph, v, i, 0);
		}
		System.out.println(Arrays.toString(result));
//		System.out.println(ans);
	}

	private static int dfsGraph(ArrayList<ArrayList<Integer>> graph, boolean v[], int src, int len) {
		if (v[src]) {
			return 0;
		}
		v[src] = true;
		
	
		for (int x : graph.get(src)) {
			if (!v[x]) {
				len = dfsGraph(graph, v, x, len+1);
			}
		}
		
		result[src] = len;
		return result[src];
	}

	public static void main(String[] args) {

		int v = 6;
		int e = 3;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		result = new int[v];
		graph.get(3).add(4);
		graph.get(1).add(2);
		graph.get(4).add(5);
//		graph.get(4).add(1);
//		graph.get(4).add(0);
//		graph.get(0).add(3);
//		graph.get(3).add(2);
//		graph.get(0).add(2);
		System.out.println(graph);
		solve(graph, v, e);
	}
}
