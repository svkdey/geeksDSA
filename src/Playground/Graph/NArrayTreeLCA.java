package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;

import Playground.Graph.EularTour.GraphAdjacencyList;

public class NArrayTreeLCA {
	public static void solveMethod1(ArrayList<ArrayList<Integer>> g, int x, int y, int root) {
		ArrayList<Integer> rootToX = new ArrayList<Integer>();
		ArrayList<Integer> rootToY = new ArrayList<Integer>();
		int paths[] = new int[10000];
		boolean visited[] = new boolean[10000];
		int pathLen = 0;
		dfsGetPath(g, root, x, paths, pathLen, rootToX,visited);
		Arrays.fill(paths, 0);Arrays.fill(visited, false);
		pathLen = 0;
		dfsGetPath(g, root, y, paths, pathLen, rootToY,visited);
		System.out.println(rootToX+"  "+rootToY);

	}

	public static void dfsGetPath(ArrayList<ArrayList<Integer>> g, int root, int target, int paths[], int pathLen,
			ArrayList<Integer> rootToLeaf,	boolean visited[]) {
		if (visited[root]) {
			return;
		}
		if (root == target) {
			paths[pathLen++] = root;
			
			for (int i = 0; i < pathLen; i++) {
				rootToLeaf.add(paths[i]);
			}
			
			return;
		}
		paths[pathLen++] = root;
		visited[root]=true;
		for (int x : g.get(root)) {
			if (!visited[x]) {
				dfsGetPath(g, x, target, paths, pathLen, rootToLeaf,visited);
			}
		}
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
		solveMethod1(graph.adjList, 3, 7, 0);

		
	}

}
