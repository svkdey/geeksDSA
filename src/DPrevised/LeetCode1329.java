package DPrevised;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode1329 {
	public static int[][] diagonalSort(int[][] mat) {
		HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int diagonal = i - j;
				PriorityQueue<Integer> pq = null;
				if (map.containsKey(diagonal)) {
					pq = map.get(diagonal);
				} else {
					pq = new PriorityQueue<Integer>();
				}
				pq.add(mat[i][j]);
				map.put(diagonal, pq);
			}
		}
		System.out.println(map);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int diagonal = i - j;
				mat[i][j]=map.get(diagonal).remove();
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		return mat;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		diagonalSort(mat);
	}

}
