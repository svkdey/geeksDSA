package CrackingTheCodingInterView.LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class BuildOrder {
	static class GraphAdjacencyListDirectedGraph {
		public ArrayList<ArrayList<Integer>> adjList;

		public GraphAdjacencyListDirectedGraph(int vertexNumber) {
			this.adjList = new ArrayList<ArrayList<Integer>>(vertexNumber);
			for (int i = 0; i < vertexNumber; i++) {
				this.adjList.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(int v1, int v2) {
			this.adjList.get(v1).add(v2);
		}

		public static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
			for (ArrayList<Integer> vertexlist : adjList) {
				System.out.print("vertex " + adjList.indexOf(vertexlist) + "==>");
				for (int vertex : vertexlist) {
					System.out.print(vertex + " ");
				}
				System.out.println();
			}
		}

		@Override
		public String toString() {
			return "GraphAdjacencyListDirectedGraph{" + "adjList=" + adjList + '}';
		}
	}

	public static void solve(int arr[][], int n, int w) {

		GraphAdjacencyListDirectedGraph graph = new GraphAdjacencyListDirectedGraph(w);
		for (int i = 0; i < n; i++) {
			graph.addEdge(arr[i][0], arr[i][1]);
		}
		System.out.println(graph.adjList);
		Stack<Integer> s = new Stack<Integer>();
		boolean visited[] = new boolean[w];
		for (int i = 0; i < w; i++) {
			if (!visited[i]) {
				dfs(graph.adjList, s, visited, i);
			}
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}

	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjList, Stack<Integer> s, boolean visited[], int v) {
		if (visited[v]) {
			return;
		}
		visited[v] = true;
		ArrayList<Integer> list = adjList.get(v);
		for (int x : list) {
			if (!visited[x]) {
				dfs(adjList, s, visited, x);
			}
		}
		s.push(v);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int arr[][] = { { 0, 4 }, { 5, 1 }, { 1, 3 }, { 5, 0 }, { 3, 2 } };
		int w = 6;
		solve(arr, n, w);
	}

}
