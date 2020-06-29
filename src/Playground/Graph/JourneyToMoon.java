package Playground.Graph;

import java.util.ArrayList;

public class JourneyToMoon {
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
	
	
	
	
	//solution
	public static int nCrModp(int n, int r) {
		if (r == n || r == 0) {
			return 1;
		} else {
			return nCrModp(n - 1, r - 1) + nCrModp(n - 1, r);
		}

	}
	public static void numberOfPossibleWays(ArrayList<ArrayList<Integer>> adjList, int v) {
		boolean visited[] = new boolean[v];
		ArrayList<ArrayList<Integer>> connectedComponentSet=new ArrayList<ArrayList<Integer>>();
		int numberOfconnectedComponent=0;
		for (int i = 0; i < v; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			if (!visited[i]) {
				dfsHelper(adjList, visited, i, list);
				numberOfconnectedComponent++;
				connectedComponentSet.add(list);
			}
		}

		
		System.out.println(connectedComponentSet);
		int totalNumberOFPPLThatCantGo=0;
		for(ArrayList<Integer> x:connectedComponentSet) {
			totalNumberOFPPLThatCantGo+=nCrModp(x.size(),2);
		}
		
		int ans=nCrModp(v,2)-totalNumberOFPPLThatCantGo;
		System.out.println(ans);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyList graph = new GraphAdjacencyList(5);
		
		graph.addEdge(0, 1);
	
		graph.addEdge(2, 3);
		graph.addEdge(4, 0);
	
		graph.printGraph(graph.adjList);

		// 0 3,1 2,4 5
		// 0 1,3 2,4 5
		numberOfPossibleWays(graph.adjList, 5);
	}

}
