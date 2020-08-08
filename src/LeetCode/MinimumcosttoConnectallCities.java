package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinimumcosttoConnectallCities {

	static class DisjointSet {
		int vertex[] = null;

		public DisjointSet(int n) {
			super();
			this.vertex = new int[n];
			for (int i = 0; i < n; i++) {
				vertex[i] = i;
			}
		}

		public int find(int x) {
			if (this.vertex[x] == x) {
				return x;
			} else {
				this.vertex[x] = find(this.vertex[x]);
				return this.vertex[x];
			}
		}

		public void union(int x, int y) {
			int x_root = find(x);
			int y_root = find(y);
			if (x_root != y_root) {
				this.vertex[y_root] = x_root;
			}
		}

		public boolean isconnected(int x, int y) {
			int x_root = find(x);
			int y_root = find(y);
			if (x_root == y_root) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public String toString() {
			return "DisjointSet [vertex=" + Arrays.toString(vertex) + "]";
		}

	}

	static class Edge {
		int src, dest, wt;

		@Override
		public String toString() {
			return "Egde [src=" + src + ", dest=" + dest + ", wt=" + wt + "]";
		}

		public Edge(int src, int dest, int wt) {
			super();
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}

	}
	static class EdgeTo {
		int  dest, wt;

		@Override
		public String toString() {
			return "Egde [ dest=" + dest + ", wt=" + wt + "]";
		}

		public EdgeTo( int dest, int wt) {
			super();
			
			this.dest = dest;
			this.wt = wt;
		}

	}
	//kruskal
	public static void solve(Edge edges[], int v) {
		Comparator<Edge> rule = (a, b) -> {
			return a.wt - b.wt;
		};
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(rule);
		for (Edge x : edges) {
			pq.add(x);
		}
		DisjointSet dsu = new DisjointSet(v);
		Edge e = pq.remove();
		dsu.union(e.src, e.dest);
		HashSet<Integer> incldedVertex = new HashSet<Integer>();
		if (!incldedVertex.contains(e.src)) {
			incldedVertex.add(e.src);
		}
		if (!incldedVertex.contains(e.dest)) {
			incldedVertex.add(e.dest);
		}
		int ans = e.wt;
		while (incldedVertex.size() != v && !pq.isEmpty()) {
			Edge currentEdge = pq.remove();
			if (!dsu.isconnected(currentEdge.src, currentEdge.dest)) {
				dsu.union(currentEdge.src, currentEdge.dest);
				ans += currentEdge.wt;

				if (!incldedVertex.contains(currentEdge.src)) {
					incldedVertex.add(currentEdge.src);
				}
				if (!incldedVertex.contains(currentEdge.dest)) {
					incldedVertex.add(currentEdge.dest);
				}
			}
		}
		int connectedComponent = 0;
		for (int i = 0; i < v; i++) {
			if (dsu.vertex[i] == i) {
				connectedComponent++;
			}
		}
		if (connectedComponent == 1) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}
	//MST but wont apply if graph is disconnected.
	public static void solvePrims(ArrayList<ArrayList<EdgeTo>> graph, int v) {
		Comparator<Edge> rule = (a, b) -> {
			return a.wt - b.wt;
		};
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(rule);
		for(EdgeTo e:graph.get(0)) {
			pq.add(new Edge(0, e.dest, e.wt));
		}
		ArrayList<Edge> list=new ArrayList<MinimumcosttoConnectallCities.Edge>();
		boolean visited[]=new boolean[v];
		visited[0]=true;
		int ans=0;
		while(!pq.isEmpty()) {
			Edge e=pq.poll();
			int cur_v=e.dest;
			int cost=e.wt;
			if(!visited[cur_v]) {
				for(EdgeTo edge:graph.get(cur_v)) {
					pq.add(new Edge(cur_v, edge.dest, edge.wt));
				}
				visited[cur_v]=true;
				ans+=cost;
				list.add(e);
			}
		}
		System.out.println(list);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Edge graph1[]= {new Edge(0,1,5),new Edge(0,2,6),new Edge(1,2,1)};
		Edge graph2[]= {new Edge(0,1,3),new Edge(2,3,4)};
		
		ArrayList<ArrayList<EdgeTo>> graph=new ArrayList<ArrayList<EdgeTo>>();
		for(int i=0;i<graph1.length;i++) {
			graph.add(new ArrayList<MinimumcosttoConnectallCities.EdgeTo>());
		}
		for(Edge e:graph1) {
			graph.get(e.src).add(new EdgeTo(e.dest, e.wt));
		}
		solvePrims(graph, 4);
	}

}
