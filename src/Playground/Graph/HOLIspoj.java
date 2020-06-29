package Playground.Graph;

import java.util.ArrayList;

public class HOLIspoj {
	static class Pair {
		int vertex;
		int weight;

		public Pair() {
		}

		public Pair(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Pair{" + "vertex=" + vertex + ", weight=" + weight + '}';
		}
	}

	static class GraphAdjcencyListDirectedWeightedGraph {
		public ArrayList<ArrayList<Pair>> adjList;

		public GraphAdjcencyListDirectedWeightedGraph(int vertexNumber) {
			this.adjList = new ArrayList<ArrayList<Pair>>(vertexNumber);
			for (int i = 0; i < vertexNumber; i++) {
				this.adjList.add(new ArrayList<Pair>());
			}
		}

		public void addEdge(int v1, int v2, int weight) {
			this.adjList.get(v1).add(new Pair(v2, weight));
			this.adjList.get(v2).add(new Pair(v1, weight));
		}

		@Override
		public String toString() {
			return "GraphAdjcencyListDirectedWeightedGraph{" + "adjList=" + adjList + '}';
		}
	}

	public static void solve(int v, ArrayList<ArrayList<Pair>> adjList) {
		boolean visited[] = new boolean[v];
		int count[] = new int[v];
		dfs(v, 0, adjList, visited, count);
		System.out.println(ans);
	}

	static int ans = 0;

	private static int dfs(int v, int src, ArrayList<ArrayList<Pair>> adjList, boolean vis[], int count[]) {
		vis[src] = true;
		count[src] = 1;
		for (Pair nbr : adjList.get(src)) {
			if (!vis[nbr.vertex]) {
				count[src] += dfs(v, nbr.vertex, adjList, vis, count);
				int nx = count[nbr.vertex];
				int ny = v - nx;

				ans += 2 * Math.min(nx, ny) * nbr.weight;
			}
		}
		return count[src];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjcencyListDirectedWeightedGraph g=new GraphAdjcencyListDirectedWeightedGraph(4);
		g.addEdge(0, 1, 3);
		g.addEdge(2, 1, 2);
		g.addEdge(2, 3, 2);
		
		solve(4, g.adjList);
	}

}
