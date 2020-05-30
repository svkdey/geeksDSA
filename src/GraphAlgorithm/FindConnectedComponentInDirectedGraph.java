package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

import Data.GraphData;

/**
 a graph is connected if we can reach form all the vertex from each vertex
 
 in directed graph if there is a cycle then it is possible else not;
 
 so we find subsets of graph which are connected by kosaraju and targan's algo\
 
 it is used to show feeds to a certain kind of people who likes same things
 **/
public class FindConnectedComponentInDirectedGraph {
	public static void FindConnectedComponentInDirectedGraphbyKosaraju(ArrayList<ArrayList<Integer>> adjList,int V) {
		//1st we find all the deepest nodes by dfs and keep it stack
		boolean isVisited[]=new boolean[V];
		Stack<Integer> s= new Stack<Integer>();
		for(int i=0;i<V;i++) {
			if(!isVisited[i]) {
				dfs(adjList,s,i,isVisited);
			}
		}
		
		//reverse the graph
		GraphAdjacencyListDirectedGraph revGraph=reverseGraph(adjList);
		
		
		//traverse rev graph considering source as the poped item of the stack
		boolean isVisitedRev[]=new boolean[V];
		while(!s.isEmpty()) {
			int v=s.pop();
			if(!isVisitedRev[v]) {
				dfsPrint(revGraph.adjList,v,isVisitedRev);
				System.out.println();
			}
			
		}
		
		
	}
	public static void dfsPrint(ArrayList<ArrayList<Integer>> adjList, int src, boolean visited[]) {
		if (visited[src] == true) {
			return;
		}
		visited[src] = true;
		System.out.print(src + " ");
		for (int _vList : adjList.get(src)) {
			dfsPrint(adjList, _vList, visited);
		}
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> adjList,Stack<Integer> s,int src,boolean isVisited[]) {
		if(isVisited[src]) {
			return;
		}
		isVisited[src]=true;
		
		for(int v:adjList.get(src)) {
			if(!isVisited[v]) {
				dfs(adjList, s, v, isVisited);
			}
		}
		s.add(src);
	}
	public static GraphAdjacencyListDirectedGraph reverseGraph(ArrayList<ArrayList<Integer>> adjList) {
		GraphAdjacencyListDirectedGraph graph=new GraphAdjacencyListDirectedGraph(adjList.size());
		
		for(int i=0;i<adjList.size();i++) {
			int src=i;
			for(int dest:adjList.get(src)) {
				graph.addEdge(dest,src);
			}
		}
		
		return graph;
	}
	
	
	public static void main(String[] args) {
		GraphAdjacencyListDirectedGraph graph=GraphData.getNoCycleDirectedGraph2();
		FindConnectedComponentInDirectedGraphbyKosaraju(graph.adjList,graph.adjList.size());
	}
}
