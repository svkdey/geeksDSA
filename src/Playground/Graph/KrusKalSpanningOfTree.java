package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KrusKalSpanningOfTree {
	// s ->src ,d->destination, wt->weight
	
	static class Edge {
		int s, d, wt;

		public Edge(int s, int d, int wt) {
			super();
			this.s = s;
			this.d = d;
			this.wt = wt;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", d=" + d + ", wt=" + wt + "]";
		}

	}

	static class EdgeGraph {
		Edge edges[] = null;
		int capacity = 0;
		int presentNode = 0;

		public EdgeGraph(int edgeNumber) {
			super();
			this.edges = new Edge[edgeNumber];
			this.capacity = edgeNumber;
		}

		public void addEdge(int s, int d, int wt) {
			if (presentNode < capacity) {
				edges[presentNode++] = new Edge(s, d, wt);
			}
		}

		@Override
		public String toString() {
			return "EdgeGraph [edges=" + Arrays.toString(edges) + ", capacity=" + capacity + ", presentNode="
					+ presentNode + "]";
		}
		
	}

	static class DisJointSet {
		int set[] = null;

		public DisJointSet(int n) {
			super();
			this.set = new int[n];

			for (int i = 0; i < n; i++) {
				set[i] = i;
			}
		}

		public int find(int x) {
			if (x == set[x]) {
				return x;
			}
			return set[x] = find(set[x]);
		}

		public void union(int v1, int v2) {
			int v1_root = find(v1);
			int v2_root = find(v2);
			if (v1_root == v2_root)
				return;
			set[v1_root] = v2_root;
		}

		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}
	}
	
	//o(eloge)
	public static void solve(Edge[] edges,int vertexNumber) {
		Comparator<Edge> rule=(edge1,edge2)->{
			return edge1.wt-edge2.wt;
		};
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(rule);
		
		for(Edge e:edges) {
			pq.add(e);
		}
		DisJointSet s=new DisJointSet(vertexNumber);
		ArrayList<Edge> result=new ArrayList<>();
//		System.out.println(pq);
		while(!pq.isEmpty()) {
			Edge edge=pq.remove();
	
			if(!s.isConnected(edge.s, edge.d)) {
				result.add(edge);
				s.union(edge.s, edge.d);
			}
			
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EdgeGraph graph=new EdgeGraph(4);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 3, 5);
		graph.addEdge(2, 3, 4);
		graph.addEdge(1, 3, 15);
	
//		System.out.println(Arrays.toString(graph.edges) );
		solve(graph.edges, 4);
		
	}

}
