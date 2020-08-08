package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode743 {
	class Vertex {
		int to;
		int wt;

		public Vertex(int to, int wt) {
			super();
			this.to = to;
			this.wt = wt;
		}

		@Override
		public String toString() {
			return "Vertex [to=" + to + ", wt=" + wt + "]";
		}

	}

	class Delay {
		int v;
		int time;

		@Override
		public String toString() {
			return "Delay [v=" + v + ", time=" + time + "]";
		}

		public Delay(int v, int time) {
			super();
			this.v = v;
			this.time = time;
		}

	}

	static int visited[] = null;

	public int networkDelayTime(int[][] times, int N, int K) {
		ArrayList<ArrayList<Vertex>> list = new ArrayList<ArrayList<Vertex>>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Vertex>());
		}
		for (int v[] : times) {
			list.get(v[0]).add(new Vertex(v[1], v[2]));
		}
		System.out.println(list);
		visited = new int[N + 1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		int ans = -1;
		bfs(list, K, N);
		System.out.println(Arrays.toString(visited));
		for (int i = 1; i <= N; i++) {
			if (visited[i] == Integer.MAX_VALUE) {
				return -1;
			}
			ans = Math.max(ans, visited[i]);
		}

		return ans;
	}

	public void bfs(ArrayList<ArrayList<Vertex>> list, int src, int N) {
		Comparator<Delay> rule = (a, b) -> {
			return a.time - b.time;
		};
		boolean[] vist = new boolean[N + 1];
		PriorityQueue<Delay> pq = new PriorityQueue<Delay>(rule);
		pq.add(new Delay(src, 0));
		visited[src] = 0;
		while (!pq.isEmpty()) {
			Delay vertex = pq.remove();
			if (!vist[vertex.v]) {
				vist[vertex.v] = true;

				for (Vertex p : list.get(vertex.v)) {
					if (!vist[p.to]) {
						int currWt = vertex.time + p.wt;
						int prevWt = visited[p.to];

						if (prevWt > currWt) {
							visited[p.to] = currWt;
							pq.add(new Delay(p.to, currWt));
						}
					}
				}

			}

		}

	}

	public static void main(String[] args) {
		int times[][] = { { 1, 2, 1 }, { 1, 3, 3 }, { 3, 4, 1 }, { 2, 3, 1 } };
		int N = 4;
		int K = 1;
		LeetCode743 s = new LeetCode743();
		System.out.println(s.networkDelayTime(times, N, K));
	}

}
