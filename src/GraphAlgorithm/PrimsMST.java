package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * spanning of tree (minimum weighted edges+all vertex+no loops) ie only
 * applicable for connected undirected graph
 * 
 * @author Souvik O(v*v)
 */

public class PrimsMST {
	public static void primMST(int adjList[][], int V) {
		// the vertex that will be in solution the minimum weight order
		int inMST[] = new int[V];
		// minimum weight corresponding to i_th vertex
		int key[] = new int[V];

		boolean mstSet[] = new boolean[V];
		// initially nothing has traverse

		// i_th vertex has infy value
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		// weight of 1st vertex is 0
		key[0] = 0;
		inMST[0] = -1; // 0 index node in mst

		for (int c = 0; c < V - 1; c++) {
//            get the key that is minimum value
//            which is connected to the vertex which we have taken in inMST
			int u = minKey(key, mstSet, V);
			// marked as visited
			mstSet[u] = true;

			// include it's weight and it's idx in inMST
			for (int i = 0; i < V; i++) {
				// most important line .it takes u vertex goes to possible edges.
				// finds if minimum value of edge that's considered and not visited,it updates
				// that
				if (adjList[u][i] != 0 && mstSet[i] == false && adjList[u][i] < key[i]) {
					inMST[i] = u;
					key[i] = adjList[u][i];
				}
			}
		}
		System.out.println("key--->");
		System.out.println(Arrays.toString(inMST));

		System.out.println(Arrays.toString(key));
		System.out.println("--------------");
	}
	// this function returns unvisited minimum key's Index

	public static int minKey(int key[], boolean mstSet[], int V) {
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int v = 0; v < V; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				minIdx = v;
			}
		}
		return minIdx;
	}

	// 2nd implementation
	static class Edge {
		int to;
		int cost;

		public Edge(int t, int c) {
			// TODO Auto-generated constructor stub
			to = t;
			cost = c;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", cost=" + cost + "]";
		}

	}

	public static int Prims(int graph[][]) {
		int n = graph.length;
		int sum = 0;
		int count = 1;
		boolean visited[] = new boolean[graph.length];
		Comparator<Edge> c = (a, b) -> a.cost - b.cost;
		PriorityQueue<Edge> pq = new PriorityQueue<PrimsMST.Edge>(c);
		visited[0] = true;

		for (int i = 1; i < n; i++) {
			if (graph[0][i] != 0) {
				pq.offer(new Edge(i, graph[0][i]));
			}
		}

		while (count != n && !pq.isEmpty()) {
			Edge edge = pq.poll();

			if (!visited[edge.to]) {
				for (int j = 0; j < n; j++) {
					if (!visited[j] && graph[edge.to][j] != 0) {
						pq.add(new Edge(j, graph[edge.to][j]));
					}

				}
				count++;
				visited[edge.to] = true;
				sum += edge.cost;
			}

		}
		System.out.println(visited);
		if (count != n) {
			System.out.println(-1);
			return -1;
		} else {
			System.out.println(sum);
			return sum;
		}
	}

	static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
		// Add your code here
		int sum = 0;
		boolean visited[] = new boolean[V];
		int vInclude = 1;
		Comparator<Edge> c = (a, b) -> a.cost - b.cost;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(c);
		int row = 0;
		visited[row] = true;

		for (int i = 0; i < graph.size(); i++) {
			if (graph.get(row).get(i) != Integer.MAX_VALUE) {
				pq.add(new Edge(i, graph.get(row).get(i)));
			}
		}
		while (vInclude != V && !pq.isEmpty()) {
			Edge edge = pq.poll();

			if (!visited[edge.to]) {
				for (int i = 0; i < graph.size(); i++) {
					if (!visited[i] && graph.get(edge.to).get(i) != Integer.MAX_VALUE) {
						pq.add(new Edge(i, graph.get(edge.to).get(i)));
					}
				}
				sum += edge.cost;

				visited[edge.to] = true;

				vInclude++;
			}

		}
		return sum;

	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 1, 5 }, { 5, 0, 3 }, { 1, 3, 0 } };

		// Print the solution
		primMST(graph, 3);
		Prims(graph);
	}
}
