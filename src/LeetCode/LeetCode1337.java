package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode1337 {
	static class Makings {
		int row, occ;

		public Makings(int row, int occ) {
			super();
			this.row = row;
			this.occ = occ;
		}

		@Override
		public String toString() {
			return "Makings [row=" + row + ", occ=" + occ + "]";
		}
		

	}

	public int[] kWeakestRows(int[][] mat, int k) {
		Comparator<Makings> rule = (a, b) -> {
			if(a.occ==b.occ) {
				return a.row-b.row;
			}
			return a.occ - b.occ;
		};
		PriorityQueue<Makings> pq = new PriorityQueue<Makings>(rule);
		int ans[] = new int[k];
		for (int i = 0; i < mat.length; i++) {
			int idx = bs(mat[i]);
			if (idx == -1) {
				pq.add(new Makings(i, 0));
			} else {
				pq.add(new Makings(i, idx + 1));
			}

		}
		System.out.println(pq);
		int i=0;
		while(!pq.isEmpty()&&k!=0) {
			k--;
			ans[i++]=pq.remove().row;
		}
		return ans;
	}

	public int bs(int arr[]) {
		int i = 0, j = arr.length - 1;
		int ans = -1;
		while (j >= i) {
			int mid = i + (j - i) / 2;
			if (arr[mid] == 1) {
				ans = mid;
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return ans;
	}
}
