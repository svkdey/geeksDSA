package CrackingTheCodingInterView.TreeAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;

public class RouteBetweenTwoNodes {
	static class GraphAdjacencyListDirectedGraph {
		public ArrayList<ArrayList<Integer>> adjList;

		public GraphAdjacencyListDirectedGraph(int vertexNumber) {
			this.adjList = new ArrayList<ArrayList<Integer>>(vertexNumber);
			for (int i = 0; i < vertexNumber; i++) {
				this.adjList.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(int v1, int v2) {
			this.adjList.get(v1).add(v2);
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
			return "GraphAdjacencyListDirectedGraph{" + "adjList=" + adjList + '}';
		}
	}
	public static boolean solve(int source,int dest,GraphAdjacencyListDirectedGraph graph,int n) {
		boolean visited[]=new boolean[n];
		return dfs(graph.adjList,source,dest,visited);
//		System.out.println(Arrays.toString(visited));
	}
	private static boolean dfs(ArrayList<ArrayList<Integer>> adjList,int s,int dest,boolean visited[]) {
		if(s==dest) {
			return true;
		}
		visited[s]=true;
		
		ArrayList<Integer> v=adjList.get(s);
		for(int x:v) {
			if(!visited[x]&&dfs(adjList,x,dest,visited)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjacencyListDirectedGraph graph=new GraphAdjacencyListDirectedGraph(5);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 0);
		System.out.println(graph.adjList);
		graph.printGraph(graph.adjList);
		System.out.println(solve(0,1,graph,5));
		System.out.println(solve(1,3,graph,5));
		System.out.println(solve(3,0,graph,5));
		System.out.println(solve(4,1,graph,5));
	}

}
