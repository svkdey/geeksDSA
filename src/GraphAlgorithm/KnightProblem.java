package GraphAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class KnightProblem {

	static class MoveByKnight {
		int x;
		int y;
		int dis;

		public MoveByKnight(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public String toString() {
			return "MoveByKnight [x=" + x + ", y=" + y + ", dis=" + dis + "]";
		}

	}

	public static boolean valid(int rr, int cc, int R, int C) {
		if (rr >= 0 && rr <= R && cc >= 0 && cc <= C) {
			return true;
		} else {
			return false;
		}
	}

	public static int KnightProblemImpl(int gridSize, int targetX, int targetY, int startX, int startY) {
		// TODO Auto-generated method stub
		int R = gridSize;
		int C = gridSize;

		boolean visited[][] = new boolean[R + 1][C + 1];

		int dr[] = { -2, -2, 2, 2, 1, 1, -1, -1 };
		int cr[] = { 1, -1, 1, -1, -2, 2, -2, 2 };
		// queues to traverse x and y
		Queue<MoveByKnight> q = new LinkedList<MoveByKnight>();

		q.add(new MoveByKnight(startX, startY, 0));

		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			MoveByKnight move = q.remove();
			// reach target
			if (move.x == targetX && move.y == targetY) {
				return move.dis;
			}
			// traverse coordinate
			for (int i = 0; i < dr.length; i++) {
				int rr = move.x + dr[i];
				int cc = move.y + cr[i];

				if (valid(rr, cc, R, C) && visited[rr][cc] == false) {
					q.add(new MoveByKnight(rr, cc, move.dis + 1));
					visited[rr][cc] = true;
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(sc.readLine());
		while (t-- > 0) {
			int size = Integer.parseInt(sc.readLine());
			String[] start = sc.readLine().split(" ");
			System.out.println(Arrays.toString(start));
			String[] end = sc.readLine().split(" ");
			System.out.println(Arrays.toString(end));
			int ans = KnightProblemImpl(size, Integer.parseInt(end[0]), Integer.parseInt(end[1]),
					Integer.parseInt(start[0]), Integer.parseInt(start[1]));

			System.out.println(ans);

		}
	}
}
