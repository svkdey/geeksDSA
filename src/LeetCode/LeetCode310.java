package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode310 {

	static class Graph {
		ArrayList<HashSet<Integer>> adjList = new ArrayList<HashSet<Integer>>();

		public Graph(int n) {
			adjList = new ArrayList<HashSet<Integer>>();
			for (int i = 0; i < n; i++) {
				adjList.add(new HashSet<Integer>());
			}
		}

		public void addEdge(int v1, int v2) {
			this.adjList.get(v1).add(v2);
			this.adjList.get(v2).add(v1);
		}

		@Override
		public String toString() {
			return "Graph [adjList=" + adjList + "]";
		}

	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (edges.length == 0 && n == 1) {
			List<Integer> a = new ArrayList<Integer>();
			a.add(0);
			return a;
		}
		Graph g = new Graph(n);

		for (int i = 0; i < edges.length; i++) {
			g.addEdge(edges[i][0], edges[i][1]);
		}
		int span = n;
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (g.adjList.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		while (n > 2) {
			n -= leaves.size();
			ArrayList<Integer> newleaves = new ArrayList<Integer>();
			for (int v : leaves) {
				// going leaf to internal node
				int j = g.adjList.get(v).iterator().next();

				// deleting leafs
				g.adjList.get(j).remove(v);
				// after deleting is j node becomes leaf?
				if (g.adjList.get(j).size() == 1) {
					newleaves.add(j);
				}
				System.out.println(g.adjList);

			}
			// over riding new leafs
			leaves = newleaves;
		}

		return leaves;
	}

	public static void main(String[] args) {
		int edges[][] = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		int n = 6;
		System.out.println(findMinHeightTrees(n, edges));
	}

}
