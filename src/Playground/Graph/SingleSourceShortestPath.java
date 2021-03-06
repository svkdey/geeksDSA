package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SingleSourceShortestPath {
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

	public static void minimumTime(ArrayList<ArrayList<Integer>> adjList, int V, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		int visited[] = new int[V];
		q.add(src);
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[src] = 0;

	
		while (!q.isEmpty()) {

		
			int size = q.size();

			for (int i = 0; i < size; i++) { // each level of burning
				int source = q.remove();
				ArrayList<Integer> nbr_list = adjList.get(source);

				for (int nbr : nbr_list) {
					if (visited[nbr] == Integer.MAX_VALUE) {
						visited[nbr] = visited[source] + 1;
						q.add(nbr);
					}
				}
			}
		}
		System.out.println(Arrays.toString(visited));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphAdjacencyList graph = new GraphAdjacencyList(6);
		graph.addEdge(0, 3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(4, 3);
		graph.addEdge(4, 5);
		graph.printGraph(graph.adjList);

		// 0 3,1 2,4 5
		// 0 1,3 2,4 5
		minimumTime(graph.adjList, 6, 3);

	}
}
