package GraphAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceFromNearestBinarycll {
	public static boolean isValid(int c, int r, int N, int M) {
		// System.out.print(c+" "+r+" "+N+" "+M);
		if (c >= 0 && c < M && r >= 0 && r < N) {
			return true;
		} else {
			return false;
		}
	}

	static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int N, int M) {
		// java code added
		int grid[][] = new int[N][M];
		int n = 4;
		int[] rDir = { -1, 0, 0, 1 };
		int[] cDir = { 0, -1, 1, 0 };
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat.get(i).get(j) == 1) {
					grid[i][j] = 0;
					q1.add(i);
					q2.add(j);
				} else {
					grid[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		
		System.out.println(q1+ " "+q2);	
		while (!q1.isEmpty()) {
			System.out.println(q1+ " "+q2);
			int r = q1.remove();
			int c = q2.remove();
			for (int i = 0; i < n; i++) {
				int rNew = r + rDir[i];
				int cNew = c + cDir[i];
//				
				if (isValid(cNew, rNew, N, M) && (grid[rNew][cNew] > grid[r][c] + 1)) {
					grid[rNew][cNew] = grid[r][c] + 1;
					q1.add(rNew);
					q2.add(cNew);
				}
			}

		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int j = 0; j < M; j++) {
				if (grid[i][j] != Integer.MAX_VALUE) {
					l.add(grid[i][j]);
				}
			}
			res.add(l);
		}
		return res;

	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(1);
//			l2.add(0);
//			l2.add(1);

		res.add(l1);
//			res.add(l2);
		nearest(res, 1, 2);
		System.out.println(isValid(0,1,1,2));
	}

}
