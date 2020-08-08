package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;

import Playground.Graph.DfsOfCGraph.GraphAdjacencyList;

public class IsBipartile {
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

	static boolean isBipartileResult = true;

	public static void biPartileImpl(ArrayList<ArrayList<Integer>> adjList, int v) {
		int visited[] = new int[v];
		dfs(adjList, 0, -1, visited, 1);
		System.out.println(isBipartileResult);
		System.out.println(Arrays.toString(visited));
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjList, int currentNode, int parentNode, int visited[],
			int color) {
		visited[currentNode] = color;
		for (int childvtx : adjList.get(currentNode)) {
			if (visited[childvtx] == 0) {
				dfs(adjList, childvtx, currentNode, visited, 3 - color);
			} else {
				if (parentNode != childvtx && color == visited[childvtx]) {
					isBipartileResult = false;
				}
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyList graph = new GraphAdjacencyList(6);
//		graph.addEdge(0, 3);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(4, 2);
//		graph.addEdge(3, 5);
		
		graph.printGraph(graph.adjList);
		biPartileImpl(graph.adjList,6);
	}

}
