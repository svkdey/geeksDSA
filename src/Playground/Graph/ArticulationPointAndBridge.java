package Playground.Graph;

import java.util.ArrayList;

/**
 * articulation pt->vertex -x removed . if (increase in no of connected
 * Component)->it is called articulation point bridge ->edge x-y removed . if
 * (increase in no of connected Component)->it is called articulation point
 * 
 *
 * backedge -> edge btw current visited vertex to another vertex that edge is
 * not visited yet . discovery time -> during dfs .time to visit the a node for
 * first time is called discovery time
 * 
 * Lowest time -> min time of a node of Math.min(it's all back edge) is pointing
 * .
 * 
 * 
 * lowest[child]>=discovery[x] && discoveryTime[x]!=1; then x is articulation
 * point . ie back edge's destination is articulation point.and
 * 
 * 
 * edge above articulation point is a bridge .lowest[child]>discovery[x]
 * 
 *
 ***/

//note here we update current node's low time .but we check child's low time wrt to current node's dicovery time for bridge and articulation points 

public class ArticulationPointAndBridge {
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
/*----------------------------------------------------------------------------------------------------------------------------------------*/
	static int time = 0;

	public static void solve(ArrayList<ArrayList<Integer>> adjList, int v) {
		int discoveryTime[] = new int[v];
		int lowTime[] = new int[v];

		dfs(adjList, 0, discoveryTime, lowTime, -1);
		time = 0;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjList, int currentNode, int discoveryTime[], int lowTime[],
			int parent) {
		discoveryTime[currentNode] = lowTime[currentNode] = time++;
		int no_ofchild = 0;
		for (int childvertex : adjList.get(currentNode)) {
			if (discoveryTime[childvertex] == 0) {
				dfs(adjList, childvertex, discoveryTime, lowTime, currentNode);
				no_ofchild++;
				lowTime[currentNode] = Math.min(lowTime[childvertex], lowTime[currentNode]);

				// if articulation point
				if (parent != 0 && lowTime[childvertex] >= discoveryTime[currentNode]) {
					System.out.println("Articulartion  point : " + currentNode);
				}
				//	bridge
				if (lowTime[childvertex] > discoveryTime[currentNode]) {
					System.out.println("bridge : " + currentNode + " " + childvertex);
				}

			} else if (childvertex != parent) {
				// backedge and cycle found
				lowTime[currentNode] = Math.min(discoveryTime[childvertex], lowTime[currentNode]);
			}
		}

		// separate root node condition .note : i started parent as -1

		if (parent == -1 && no_ofchild >= 2) {
			System.out.println(currentNode);
		}
		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyList graph = new GraphAdjacencyList();
		graph.addVertex(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);

		graph.printGraph(graph.adjList);

		solve(graph.adjList, 6);
	}

}
