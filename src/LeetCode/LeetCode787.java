package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode787 {
	static class Vertex {
		int v;
		int wt;

		public Vertex(int v, int wt) {
			super();
			this.v = v;
			this.wt = wt;
		}

	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<Integer, Map<Integer, Integer>>();
		for (int f[] : flights) {
			if (!graph.containsKey(f[0])) {
				graph.put(f[0], new HashMap<Integer, Integer>());
			}
			graph.get(f[0]).put(f[1], f[2]);
		}
		Comparator<int[]> rule = (a, b) -> {
			return a[0] - b[0];
		};
		PriorityQueue<int[]> pq = new PriorityQueue<>(rule);

		pq.add(new int[] { 0, src, K + 1 });

		while (!pq.isEmpty()) {

			int[] node = pq.remove();
			int price = node[0];
			int city = node[1];
			int steps = node[2];
			if (city == dst)
				return price;
			if (steps > 0) {
				Map<Integer, Integer> adj = graph.getOrDefault(city, new HashMap<>());
				for (int a : adj.keySet()) {
					pq.add(new int[] { price + adj.get(a), a, steps - 1 });
				}
			}

		}
		return -1;
	}
}
