package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;
//basically if u make multiple queries on single graph then this method is useful
public class BinaryLiftingQuariesOnTree {
	 ArrayList<ArrayList<Integer>> graph;
	 int timeIn[];
	 int timeOut[];
	 boolean visited[] = null;
	 int n;
	 int m;
	 int matrix[][];

	public  void addEdge(int v1, int v2) {
		graph.get(v1).add(v2);
		graph.get(v2).add(v1);
	}

	public BinaryLiftingQuariesOnTree(int vertexNo) {
		// TODO Auto-generated constructor stub

		this.graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < vertexNo; i++) {
			graph.add(new ArrayList<Integer>());
		}
		this.visited = new boolean[vertexNo];
		this.timeIn = new int[vertexNo];
		this.timeOut = new int[vertexNo];

		this.n = vertexNo;
		this.m = (int) (Math.ceil(Math.log(vertexNo)))+1;
		this.matrix = new int[n][m];
		System.out.println(m+ "  "+n);
	}

	static int timer = 0;

	 void dfs(int curr, int parent) {
		visited[curr] = true;
		timeIn[curr] = ++timer;
		matrix[curr][0]=parent;
		for(int i=1;i<m;++i) {
			matrix[curr][i]=matrix[matrix[curr][i-1]][i-1];
		}
		
		for (int child : graph.get(curr)) {
			if (!visited[child]) {
				//if u need to add distace then
				//dis[child.vertex]=dis[current.vertex]+child.w
				dfs(child, curr);

			}
		}
		timeOut[curr] = timer;
	}

	 boolean isAncestor(int u, int v) {
		// if u is an ancestor of v

		return timeIn[u] <= timeIn[v] && timeOut[u] >= timeOut[v];

	}

	 int LCA_using_time(int u, int v) {
		if (isAncestor(u, v))
			return u;
		if (isAncestor(v, u))
			return v;
		for (int i = m - 1; i >= 0; i--) {
			//
			if (!isAncestor(u, v)) {
				u = matrix[u][i];
			}
		}
		return matrix[u][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryLiftingQuariesOnTree graph = new BinaryLiftingQuariesOnTree(10);

		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 6);
		graph.addEdge(6, 8);
		graph.addEdge(6, 7);
		System.out.println(graph.graph);
		timer = 0;
		graph.dfs(0, 0);
		for(int x[]:graph.matrix) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println(Arrays.toString(graph.timeIn));
		System.out.println(Arrays.toString(graph.timeOut));
		

	}

}
