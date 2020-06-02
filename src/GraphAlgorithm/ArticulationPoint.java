package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

import Data.GraphData;

/*
 *articulation point is the vertex which removal make the graph more than one strongly component graph
 * 
 *It is used to find vulnerable point in the network
 *
 *Bridge is the edge which removal increase the number of strongly connected component
 *
 *back edge = during DFS if we find for u there is v which is in recursion call stack then that is called back edge.
 *
 *discovery time = during DFS (the distance from start vertex to u ) +1 is discovery time for a vertex u.
 *
 *lowValue = from u vertex to root vertex minimum distance .that can be through back edge or normal egde
 *
 *
 *a edge will be bridge if low[u]>dist[v]
 *
 *a vertex will be articulation point if 1. we start dfs form that point and it breaks the graph into 2 tree
 *					2.if  low[v] >= disc[u] then that v point is articulation point
 */
public class ArticulationPoint {
	// A recursive function that find articulation points using DFS
	// u --> The vertex to be visited next
	// visited[] --> keeps tract of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	// ap[] --> Store articulation point

	public static void findArticulationPointAndBridgeInGraph(ArrayList<ArrayList<Integer>> adjList, int V) {
		boolean visited[] = new boolean[V];

		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];
		Arrays.fill(parent, -1);

		boolean ap[] = new boolean[V];
		int time = 0;
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				utilTofinAPandBridge(adjList, i, visited, disc, low, parent, ap, time);
			}
		}
		System.out.println(Arrays.toString(ap));
		//System.out.println(Arrays.toString(disc));
		//System.out.println(Arrays.toString(low));
	}

	public static void utilTofinAPandBridge(ArrayList<ArrayList<Integer>> adjList, int vertex, boolean visited[],
			int disc[], int low[], int parent[], boolean ap[], int time) {
		// count children in dfs tree;
		int children = 0;
		visited[vertex] = true;
		disc[vertex] = low[vertex] = ++time;

		for (int _v : adjList.get(vertex)) {
			// If v is not visited yet, then make it a child of vertex
			// in DFS tree and recur for it
			if (!visited[_v]) {
				children++;
				parent[_v] = vertex;

				utilTofinAPandBridge(adjList, _v, visited, disc, low, parent, ap, time);
//				System.out.println("low array===> for"+ vertex+" "+_v+Arrays.toString(parent) +Arrays.toString(low)  );
				low[vertex] = Math.min(low[vertex], low[_v]);
				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u

				// u is an articulation point in following cases

				// (1) u is root of DFS tree and has two or more chilren.
				if (parent[vertex] == -1&& children > 1)
					ap[vertex] = true;

				// (2) If u is not root and low value of one of its child
				// is more than discovery value of u.
				if (parent[vertex] != -1 && low[_v] >= disc[vertex])
					ap[vertex] = true;

				// If the lowest vertex reachable from subtree
				// under v is below u in DFS tree, then u-v is
				// a bridge
				if (low[_v] > disc[vertex])
					System.out.println(vertex + " " + _v);
			} else if (_v != parent[vertex]) {
				 // if v discovered and is not parent of vertex, update low[vertex], cannot use low[vertex] because vertex is not subtree of _v
				low[vertex] = Math.min(disc[_v], low[vertex]);
			//	System.out.println("*********"+u+" " +v +"   low"+"--->"+Arrays.toString(low)+"  disc  "+Arrays.toString(disc));
			}
		}

	}

	public static void main(String[] args) {
//		GraphAdjacencyList g = GraphData.getGraph();
		GraphAdjacencyList g3= GraphData.getGraph();
		System.out.println(g3);
		findArticulationPointAndBridgeInGraph(g3.adjList, g3.adjList.size());
	}

}
