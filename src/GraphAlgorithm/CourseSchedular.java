package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedular {
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

		public void printGraph(ArrayList<ArrayList<Integer>> adjList) {
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
			return "GraphAdjacencyListDirectedGraph{" + "adjList=" + adjList + '}';
		}
	}

	public static void solve(int n,int [][]course) {
		GraphAdjacencyListDirectedGraph graph=new GraphAdjacencyListDirectedGraph(n);
		for(int i=0;i<course.length;i++) {
			graph.addEdge(course[i][0], course[i][1]);
		}
		graph.printGraph(graph.adjList);
		int visited[]=new int[n];
		int inStack[]=new int[n];
		//stack to print course order
		Stack<Integer> s = new Stack<Integer>();
		boolean ans=false;
		for(int i=0;i<n;i++) {
			if(visited[i]!=1&&dfs(graph.adjList, n, visited, inStack, i,s)) {
				ans=false;
				break;
			}else {
				ans=true;
			}
		}
		System.out.println(ans);
		if(ans) {
			System.out.println(s);
		}
	}
	//this dfs will return if cycle of not
	public static boolean dfs(ArrayList<ArrayList<Integer>> adjList,int n,int visited[],int inStack[],int node,Stack<Integer>  s) {
		visited[node]=1;
		inStack[node]=1;
		
		ArrayList<Integer> list =adjList.get(node);
		for(int v:list) {
			if(visited[v]!=1&&dfs(adjList, n, visited, inStack, v,s)) {
				return true;
			}
			if(inStack[v]==1) {
				return true;
			}
		}
		inStack[node]=0;
		//for topogical sort
		s.push(node);
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int course[][]= {{0,1},{1,2},{2,4},{5,6},{5,4},{6,4}};
		solve(7, course);
	}	

}
