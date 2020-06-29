package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class EularTour {
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
			for (int i=0;i<adjList.size();i++) {
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

	static int time = 0;

	public static void SolveEularTourType2(int vertexNumber, ArrayList<ArrayList<Integer>> graph, int src) {
		boolean v[] = new boolean[vertexNumber];
		int timeIn[] = new int[vertexNumber];
		int timeout[] = new int[vertexNumber];
		time = 1;
		dfsforType2(graph, v, src, timeIn, timeout);

		System.out.println();
		System.out.println(Arrays.toString(timeIn));
		System.out.println(Arrays.toString(timeout));
		time = 0;
	}

	public static void dfsforType2(ArrayList<ArrayList<Integer>> graph, boolean visited[], int src, int timeIn[],
			int timeout[]) {
		if (visited[src]) {
			return;
		}
		visited[src] = true;
		System.out.print(src + " ");
		timeIn[src] = time++;
		for (int x : graph.get(src)) {
			if (!visited[x]) {
				dfsforType2(graph, visited, x, timeIn, timeout);
			}
		}
		System.out.print(src + " ");
		timeout[src] = time++;
	}

	public static void SolveEularTourType3(int vertexNumber, ArrayList<ArrayList<Integer>> graph, int src) {
		boolean v[] = new boolean[vertexNumber];
		int timeIn[] = new int[vertexNumber];
		int timeout[] = new int[vertexNumber];
		time = 0;
		dfsforType3(graph, v, src, timeIn, timeout);
		System.out.println();
		for (int i = 0; i < vertexNumber; i++) {
			System.out.println("index :" + (i+1) + " time in :" + timeIn[i] + "time out" + timeout[i]);
		}
		time = 0;
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
		graph.addEdge(1, 2);
		graph.addEdge(2, 6);
		graph.addEdge(6, 8);
		graph.addEdge(6, 7);
		System.out.println(graph);
		graph.printGraph(graph.adjList);

		SolveEularTourType3(9, graph.adjList, 0);

	}
}