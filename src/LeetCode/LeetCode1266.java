package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1266 {
	public int minTimeToVisitAllPoints(int[][] points) {
		int ans = 0;
		for (int i = 0; i < points.length - 1; i++) {
			//by graph
//			ans += bfs(points[i], points[i + 1]);
			//by math
			ans+=calc(points[i], points[i + 1]);
		}
		return ans;
	}

	public int bfs(int src[], int target[]) {
		int depth = -1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(src);
		int dr[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
		int dc[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
		boolean found = false;
		while (!q.isEmpty()) {
			int s = q.size();
			for (int i = 0; i < s; i++) {
				int point[] = q.remove();
				if (point[0] == target[0] && point[1] == target[1]) {
					found = true;
					break;

				}
				for (int j = 0; j < 8; j++) {
					int nxt[] = { point[0] + dr[j], point[1] + dc[j] };
					q.add(nxt);
				}
			}

			depth++;

			if (found) {
				break;
			}
		}

		return depth;
	}
	public int calc(int src[], int target[]) {
		return Math.max(Math.abs(src[0]-target[0]), Math.abs(src[1]-target[1]));
	}
	

	public static void main(String[] args) {
		LeetCode1266 s = new LeetCode1266();
		int points[][] = {{3,2},{-2,2}};
		System.out.println(s.minTimeToVisitAllPoints(points));

	}
}
