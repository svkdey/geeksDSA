package Playground.Graph;

import java.util.ArrayList;

import Playground.Graph.EularTour.GraphAdjacencyList;

public class IsAnsistorGraph {
	static class GraphAdjacencyList {
		public ArrayList<ArrayList<Integer>> adjList;
		public ArrayList<Integer> vertexList;

		public GraphAdjacencyList() {
			// TODO Auto-generated constructor stub

			adjList = new ArrayList<ArrayList<Integer>>();
		}

		public void addVertex(int numberOfVertex) {
			vertexList = new ArrayList<Integer>();

			for (int i = 0; i <= numberOfVertex; i++) {
				vertexList.add(i);
				ArrayList<Integer> a = new ArrayList<Integer>();
				adjList.add(a);
			}
		}

		public void addEdge(int v1, int v2) {
			if (adjList.size() > v1 && adjList.size() > v2) {
				adjList.get(v1).add(v2);
				adjList.get(v2).add(v1);
			} else {
				throw new Error("Vertex does not exist");
			}

		}

		public ArrayList<Integer> getVertex() {
			return vertexList;
		}

		public void getEdgeList(int v1, int v2) {
			if (adjList.size() > v1 && adjList.size() > v2) {
				adjList.get(v1).add(v2);
				adjList.get(v2).add(v1);
			} else {
				throw new Error("Vertex does not exist");
			}

		}

		public static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
			for (int i = 0; i < adjList.size(); i++) {
				System.out.print("vertex " + i + "==>");
				for (int vertex : adjList.get(i)) {
					System.out.print(vertex + " ");
				}
				System.out.println();
			}
		}

		@Override
		public String toString() {
			return "GraphAdjacencyList [adjList=" + adjList + "]";
		}

	}

	public static void solve(int vertexNumber, ArrayList<ArrayList<Integer>> graph, int x, int y) {
		System.out.println(SolveEularTourType3(vertexNumber, graph, 0, x, y));
	}

	static int time = 0;

	public static boolean SolveEularTourType3(int vertexNumber, ArrayList<ArrayList<Integer>> graph, int src, int x,
			int y) {
		boolean v[] = new boolean[vertexNumber];
		int timeIn[] = new int[vertexNumber];
		int timeout[] = new int[vertexNumber];
		time = 0;
		dfsforType3(graph, v, src, timeIn, timeout);
		
		//after this step devide graph into 2part or segment tree depending on conditions and do range queries
		
		
		boolean isAnsestor = false;
		if (timeIn[x] <= timeIn[y] && timeout[x] >= timeout[y]) {
			isAnsestor = true;
		}
		time = 0;
		return isAnsestor;
	}

	public static void dfsforType3(ArrayList<ArrayList<Integer>> graph, boolean visited[], int src, int timeIn[],
			int timeout[]) {
		if (visited[src]) {
			return;
		}
		visited[src] = true;
		System.out.print(src + " ");
		timeIn[src] = ++time;
		for (int x : graph.get(src)) {
			if (!visited[x]) {
				dfsforType3(graph, visited, x, timeIn, timeout);
			}
		}

		timeout[src] = time;
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyList graph = new GraphAdjacencyList();
		graph.addVertex(9);
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(0, 2);
		graph.addEdge(2, 6);
		graph.addEdge(6, 8);
		graph.addEdge(6, 7);
		System.out.println(graph);
		graph.printGraph(graph.adjList);

		solve(9, graph.adjList, 1,6);

	}

}
