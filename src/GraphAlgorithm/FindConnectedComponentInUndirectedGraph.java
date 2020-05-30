package GraphAlgorithm;

import java.util.ArrayList;

import Data.GraphData;

/**
 * It can be solved by simple dfs or BFS
 * 
 * 
 **/
public class FindConnectedComponentInUndirectedGraph {
	public static void FindConnectedComponentInUndirectedGraphImpl(ArrayList<ArrayList<Integer>> adjList, int m) {
		boolean visited[] = new boolean[m+1];

		for (int i = 0; i < m; i++) {
			if (visited[m] == false) {
				dfs(adjList, i, visited);
			}
			System.out.println();
		}
	}

	public static void dfs(ArrayList<ArrayList<Integer>> adjList, int src, boolean visited[]) {
		if (visited[src] == true) {
			return;
		}
		visited[src] = true;
		System.out.print(src + " ");
		for (int _vList : adjList.get(src)) {
			dfs(adjList, _vList, visited);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyList g = GraphData.getGraph();
		System.out.println(g);
		FindConnectedComponentInUndirectedGraphImpl(g.adjList, g.adjList.size());

		GraphAdjacencyList g2 = GraphData.getDisconnectedGraph();
		System.out.println(g2);
		FindConnectedComponentInUndirectedGraphImpl(g2.adjList, g2.adjList.size());

	}

}
