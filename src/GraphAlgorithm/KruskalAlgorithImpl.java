package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import DisJointSet.DisjointSetImproved;

public class KruskalAlgorithImpl {
	static class Edge {
		int src;
		int dist;
		int wt;

		public Edge(int src, int dist, int wt) {
			super();
			this.src = src;
			this.dist = dist;
			this.wt = wt;
		}

		@Override
		public String toString() {
			return "Edge [src=" + src + ", dist=" + dist + ", wt=" + wt + "]";
		}

	}

	static class GraphByEdge {
		Edge edges[] = null;
		int i = 0;

		public GraphByEdge(int n) {
			super();
			this.edges = new Edge[n];
		}

		public void addEdge(int src, int dist, int wt) {
			if (i < edges.length) {
				edges[i] = new Edge(src, dist, wt);
				i++;
			}
		}

		@Override
		public String toString() {
			return "GraphByEdge [graph=" + Arrays.toString(edges) + ", i=" + i + "]";
		}

	}

	// space o(v)
	// time o(log E + vE)
	public static void krusKalAlgoImpl(int V, Edge edges[]) {
		Comparator<Edge> edgeComparator = (a, b) -> {
			return a.wt - b.wt;
		};

		// instance of disjoint data set
		DisjointSetImproved ds = new DisjointSetImproved(V);
		// sorted edges by weight
		Arrays.sort(edges, edgeComparator);
		int result_Weight = 0; // resultantWeight
		ArrayList<KruskalAlgorithImpl.Edge> list = new ArrayList<KruskalAlgorithImpl.Edge>();// edges in solution set
		// for i:0---> until get all the solution edges
		for (int i = 0, S1 = 0; S1 < V - 1; i++) {
			Edge edge = edges[i];

			int x_rep = ds.find(edge.src);
			int y_rep = ds.find(edge.dist);
			// if not both represent same candidate key
			if (x_rep != y_rep) {
				S1++;
				// get into union
				ds.union(edge.src, edge.dist);

				// get into solution
				list.add(edge);
				result_Weight += edge.wt;
			}
		}

		System.out.println(result_Weight);
		System.out.println(list);

	}

	public static void main(String[] args) {
		GraphByEdge graph = new GraphByEdge(4);
		graph.addEdge(0, 1, 5);
		graph.addEdge(3, 1, 3);
		graph.addEdge(3, 2, 8);
		graph.addEdge(3, 0, 7);
		graph.addEdge(0, 2, 15);
		krusKalAlgoImpl(4, graph.edges);
	}

}
