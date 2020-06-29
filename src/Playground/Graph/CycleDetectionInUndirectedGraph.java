package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;

import Playground.Graph.BfsOfGraph.GraphAdjacencyList;

public class CycleDetectionInUndirectedGraph {
	public static void cycleDetect(ArrayList<ArrayList<Integer>> adjList, int v) {
		boolean visited[] = new boolean[v];

		for (int i = 0; i < v; i++) {

			if (!visited[i]) {
				if (dfsHelper(adjList, visited, i, -1)) {
					System.out.println("cycle");
					break;
				}

			}
		}

	}

	private static boolean dfsHelper(ArrayList<ArrayList<Integer>> adjList, boolean visited[], int src, int parent) {

		System.out.println(Arrays.toString(visited) + "  src   " + src);
		visited[src] = true;

		for (int eachNbr : adjList.get(src)) {
			// two case
			// 1. nbr not visited
			if (!visited[eachNbr]) {
				// try to find cycle in rest of the graph by making source as parent
				
				if (dfsHelper(adjList, visited, eachNbr, src)) {
					return true;
				}
			}

			// 2. nbr visited .check if it is equal to parent
			else if (parent != eachNbr) {
				return true;
			}
		}

		return false;
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
		cycleDetect(graph.adjList, 6);
	}

}
