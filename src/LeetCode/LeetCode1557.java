package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1557 {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (List<Integer> edge : edges) {
			graph.get(edge.get(0)).add(edge.get(1));
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		boolean v[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!v[i]) {

				dfs(graph, v, i);
			}
		}
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				ans.add(i);
			}
		}
		return ans;
	}

	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], int src) {

		System.out.println(src);
		for (int child : graph.get(src)) {
			if (!visited[child]) {
				visited[child] = true;
				dfs(graph, visited, child);
			}
		}

	}
}
