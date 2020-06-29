package Playground.Graph;

import java.util.ArrayList;

public class DfsOfCGraph {
	static class GraphAdjacencyList {
		public ArrayList<ArrayList<Integer>> adjList;
		public ArrayList<Integer> vertexList;

		public GraphAdjacencyList(int x) {
			// TODO Auto-generated constructor stub

			adjList = new ArrayList<ArrayList<Integer>>();
			addVertex(x);
		}

		public void addVertex(int numberOfVertex) {
			vertexList = new ArrayList<Integer>();

			for (int i = 0; i < numberOfVertex; i++) {
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
			return "GraphAdjacencyList [adjList=" + adjList + "]";
		}

	}

	public static void dfs(ArrayList<ArrayList<Integer>> adjList, int v) {
		boolean visited[] = new boolean[v];
		
		int numberOfconnectedComponent=0;
		for (int i = 0; i < v; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			if (!visited[i]) {
				dfsHelper(adjList, visited, i, list);
				numberOfconnectedComponent++;
				System.out.println(list);
			}
		}

		
		System.out.println(numberOfconnectedComponent);
	}

	private static void dfsHelper(ArrayList<ArrayList<Integer>> adjList, boolean visited[], int src,
			ArrayList<Integer> ans) {
		if (visited[src]) {
			return;
		}
		visited[src] = true;
		ans.add(src);
		for (int eachNbr : adjList.get(src)) {
			if (!visited[eachNbr]) {
				dfsHelper(adjList, visited, eachNbr, ans);
			}
		}
	}

	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	
	private static void printAllThePath(ArrayList<ArrayList<Integer>> adjList, int dest, int src,
			ArrayList<Integer> ans, boolean visited[]) {
		if (src == dest) {
			ans.add(dest);
			ArrayList<Integer> list = new ArrayList<Integer>(ans);
			result.add(list);

			// back track
			ans.remove(ans.size() - 1);
			return;
		}

		ans.add(src);
		visited[src] = true;
		for (int eachNbr : adjList.get(src)) {
			// for each path we will check if it is visited or not
			if (!visited[eachNbr]) {
				printAllThePath(adjList, dest, eachNbr, ans, visited);
			}
		}
		ans.remove(ans.size() - 1);
		visited[src] = false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyList graph = new GraphAdjacencyList(9);
		graph.addEdge(0, 3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(4, 3);
		graph.addEdge(4, 5);
		graph.addEdge(8,7);
		graph.addEdge(6,7);
		graph.printGraph(graph.adjList);

		// 0 3,1 2,4 5
		// 0 1,3 2,4 5
		dfs(graph.adjList, 9);

		//printAllThePath(graph.adjList, 5, 0, new ArrayList<Integer>(), new boolean[6]);
	//	System.out.println(result);
	}

}
