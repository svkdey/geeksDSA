package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//single source weighted graph
public class DijkstraAlgorithm {
	static class Destination {
		int vertex;
		int weight;

		@Override
		public String toString() {
			return "Destination [destination=" + vertex + ", weight=" + weight + "]";
		}

		public Destination(int destination, int weight) {
			super();
			this.vertex = destination;
			this.weight = weight;
		}

	}

	static class Graph {
		ArrayList<ArrayList<Destination>> adjList = null;
		int vertex = 0;

		public Graph(int vertex) {
			super();
			this.adjList = new ArrayList<ArrayList<Destination>>();
			this.vertex = vertex;
			for (int i = 0; i < vertex; i++) {
				adjList.add(new ArrayList<Destination>());
			}
		}

		public void addEdge(int src, int dest, int wt) {
			adjList.get(src).add(new Destination(dest, wt));
			adjList.get(dest).add(new Destination(src, wt));
		}

	}

	public static void solve(ArrayList<ArrayList<Destination>> adjList, int vertex, int src) {
		int distances[] = new int[vertex];
		boolean visited[] = new boolean[vertex];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[src] = 0;

		Comparator<Destination> rule = (dest1, dest2) -> {
			return dest1.weight - dest2.weight;
		};
		PriorityQueue<Destination> pq = new PriorityQueue<Destination>(rule);
		pq.add(new Destination(src, 0));

		while (!pq.isEmpty()) {
			Destination presentVertex = pq.remove();
			visited[presentVertex.vertex] = true;
			// for all the nbr of presentVtx we need to relax .
			for (Destination nbr : adjList.get(presentVertex.vertex)) {
				int vtx = nbr.vertex, vtx_Wt = nbr.weight;
				if (!visited[vtx]) {
					int srcToVtxDistance = vtx_Wt + distances[presentVertex.vertex];

					if (distances[vtx] > srcToVtxDistance) {
						pq.add(new Destination(vtx, srcToVtxDistance));

						distances[vtx] = srcToVtxDistance;
					}

				}

			}

		}
		System.out.println(Arrays.toString(distances));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(9);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);
		solve(graph.adjList, 9, 0);
	}

}
