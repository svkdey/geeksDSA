package LeetCode;

import java.util.*;

public class LeetCode797 {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		ans = new ArrayList<List<Integer>>();
		int dest = graph.length - 1;
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(0);
		dfs(graph, 0, dest, l);
		System.out.println(ans);
		return ans;
	}

	static List<List<Integer>> ans = null;

	private void dfs(int[][] graph, int src, int dest, ArrayList<Integer> l) {
		if (src == dest) {
			ans.add(new ArrayList<Integer>(l));
			return;
		}
		for (int child : graph[src]) {
			l.add(child);
			dfs(graph, child, dest, l);
			l.remove(l.size() - 1);
		}

	}
	public static void main(String[] args) {
		LeetCode797 s=new LeetCode797();
		int graph[][]= {{1,2}, {3},{3}, {}};
		
		s.allPathsSourceTarget(graph);
	}
}
