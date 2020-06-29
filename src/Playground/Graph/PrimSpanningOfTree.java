package Playground.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Playground.Graph.KrusKalSpanningOfTree.EdgeGraph;

public class PrimSpanningOfTree {
	static class Edge {
		int src;
		int to;
		int cost;

		public Edge(int src, int t, int c) {
			this.src = src;

			to = t;
			cost = c;
		}

		@Override
		public String toString() {
			return "Edge [src=" + src + ", to=" + to + ", cost=" + cost + "]";
		}

	}

	static class Pair {
		int vertex;
		int weight;

		public Pair(int v, int w) {
			// TODO Auto-generated constructor stub
			vertex = v;
			weight = w;
		}

		@Override
		public String toString() {
			return "Pair [vertex=" + vertex + ", weight=" + weight + "]";
		}

	}

	static class Graph {

		public ArrayList<ArrayList<Pair>> adjList;

		public Graph(int vertexNumber) {
			this.adjList = new ArrayList<ArrayList<Pair>>(vertexNumber);
			for (int i = 0; i < vertexNumber; i++) {
				this.adjList.add(new ArrayList<Pair>());
			}
		}

		public void addEdge(int v1, int v2, int weight) {
			this.adjList.get(v1).add(new Pair(v2, weight));
			this.adjList.get(v2).add(new Pair(v1, weight));
		}
	}

	public static void solve(ArrayList<ArrayList<Pair>> adjList, int vertexNumber, int src) {
		boolean visited[] = new boolean[vertexNumber];
		ArrayList<Edge> result = new ArrayList<>();
		Comparator<Edge> rule = (e1, e2) -> {
			return e1.cost - e2.cost;
		};
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(rule);
		for (Pair p : adjList.get(src)) {
			pq.add(new Edge(src, p.vertex, p.weight));
		}

		visited[src] = true;
		int sum = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int V = edge.to;
			int wt = edge.cost;

			// if already visited, dont explore
			// else explore marked as visited
			if (!visited[V]) {
				for (Pair p : adjList.get(V)) {
					pq.add(new Edge(V, p.vertex, p.weight));
				}
				visited[V] = true;
				sum += wt;
				result.add(edge);
			}

		}
		System.out.println(result);
		System.out.println(sum);
	}

///[Edge [s=2, d=3, wt=4], Edge [s=0, d=3, wt=5], Edge [s=0, d=1, wt=10]]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(4);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 3, 5);
		graph.addEdge(2, 3, 4);
		graph.addEdge(1, 3, 15);
		solve(graph.adjList, 4, 0);
	}

}
