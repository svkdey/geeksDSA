package LeetCode;

import java.util.PriorityQueue;

public class LeetCode378 {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				pq.add(matrix[i][j]);
			}
		}
		int ans = -1;
		int i=k;
		System.out.println(pq);
		while (!pq.isEmpty() && k != 0) {
			ans = pq.remove();
			System.out.println(i-k+"--->"+ans);
			k--;
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		LeetCode378 l = new LeetCode378();
		int mat[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, k = 8;
		System.out.println(l.kthSmallest(mat, k));
	}
}
