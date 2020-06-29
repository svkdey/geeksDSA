package Playground.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MiniMumCycleLength {
	public static void solve(int V, ArrayList<ArrayList<Integer>> adjList, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		int visited[] = new int[V];
		q.add(src);
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[src] = 0;

		int ans = Integer.MAX_VALUE;
		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) { // each level of burning
				int source = q.remove();
				ArrayList<Integer> nbr_list = adjList.get(source);

				for (int nbr : nbr_list) {
					if (visited[nbr] == Integer.MAX_VALUE) {
						visited[nbr] = visited[source] + 1;
						q.add(nbr);
					} else if (visited[nbr] >= visited[source]) {
						ans = Math.min(ans, visited[nbr] + visited[source] + 1);
					}
				}
			}
		}
		System.out.println(ans);
	}

}
