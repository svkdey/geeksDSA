package CrackingTheCodingInterView.TreeAndGraphs;

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

	public static void solve(int dependencies[][], int numberOfDependency) {
		GraphAdjacencyListDirectedGraph graph = new GraphAdjacencyListDirectedGraph(numberOfDependency);
		for (int x[] : dependencies) {
			graph.addEdge(x[0], x[1]);
		}

		Stack<Integer> order = new Stack<Integer>();
		boolean visited[] = new boolean[numberOfDependency];
		for (int i = 0; i < numberOfDependency; i++) {
			dfs(graph.adjList, visited, i, order);
		}
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjList, boolean v[], int src, Stack<Integer> order) {
		if (v[src]) {
			return;
		}

		v[src] = true;
		for (int child : adjList.get(src)) {
			if (!v[child]) {
				dfs(adjList, v, child, order);
			}
		}
		order.push(src);

	}

	public static void main(String[] args) {

	}

}
