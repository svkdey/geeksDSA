package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import Data.GraphData;

public class TrajanTheorem {
	// adj : adjacency list of the graph
	// N : Number of vertices
	int time = 0;

	public void TrajanTheoremImpl(ArrayList<ArrayList<Integer>> list, int n) {
		boolean visited[] = new boolean[n];
		int disc[] = new int[n];
		int low[] = new int[n];
		int parent[] = new int[n];
		Arrays.fill(parent, -1);
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(list, i, visited, disc, low, parent, stack);
			}
		}
//		System.out.println();
	}

	public void dfs(ArrayList<ArrayList<Integer>> list, int u, boolean[] visited, int[] disc, int[] low, int[] parent,
			Stack<Integer> stack) {
		visited[u] = true;
		disc[u] = low[u] = time++;
		stack.push(u);
		System.out.println(u+"---->"+Arrays.toString(parent));
		for (int v : list.get(u)) {
			if (visited[v] == false) {
				parent[v] = u;
				dfs(list, v, visited, disc, low, parent, stack);
				low[u] = Math.min(low[u], low[v]);
				System.out.println("low"+"--->"+Arrays.toString(low)+"  disc  "+Arrays.toString(disc));
				if (low[v] > disc[u]) {
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(u);
					l.add(v);
					System.out.println("----------->"+l);
				}
			} else if (v !=parent[u]) {
				
				low[u] = Math.min(low[v], disc[u]);
				System.out.println("*********"+u+" " +v +"   low"+"--->"+Arrays.toString(low)+"  disc  "+Arrays.toString(disc));
				}
			}
		
		StringBuffer br = new StringBuffer();
		if (low[u] == disc[u]) {
			while (!stack.isEmpty()) {
				int x = stack.pop();
				parent[x] = -1;
				br.append(x + " ");
				if (x == u)
					break;
			}
			System.out.print(br.toString().trim() + ",");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrajanTheorem t = new TrajanTheorem();
		GraphAdjacencyListDirectedGraph g=GraphData.getNoCycleDirectedGraph2();
		System.out.println(g);
		t.TrajanTheoremImpl(g.adjList, g.adjList.size());

//		GraphAdjacencyList g2 = GraphData.getDisconnectedGraph();
//		System.out.println(g2);
//		t.TrajanTheoremImpl(g2.adjList, g2.adjList.size());
//		
//		GraphAdjacencyList g3= GraphData.getGraph();
//		System.out.println(g3);
//		t.TrajanTheoremImpl(g3.adjList, g3.adjList.size());
	

	}
//	if(low[v]>dist[u]) {
//	ArrayList<Integer> l=new ArrayList<Integer>();
//	l.add(u);l.add(v);
//	res.add(l);
//	
//}

}
