package LeetCode;

public class LeetCode547 {
	static class DisjointSet {
		int arr[] = null;

		public DisjointSet(int n) {
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = i;
			}
		}

		private int find(int x) {
			// TODO Auto-generated method stub
			if (this.arr[x] == x) {
				return x;
			} else
				arr[x] = find(arr[x]);
			return arr[x];
		}

		private boolean isConnected(int x, int y) {
			if (find(x) == find(y)) {
				return true;
			}
			return false;
		}

		private void union(int x, int y) {
			int x_p = find(x);
			int y_p = find(y);
			if (x_p != y_p) {
				arr[x_p] = y_p;
			}
		}
	}

	public static int solve(int M[][]) {
		int numberOfStudent = 0;
		for (int i = 0; i < M.length; i++) {
			if (M[i][i] == 1) {
				numberOfStudent++;
			}
		}

		DisjointSet dsu = new DisjointSet(numberOfStudent);
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				if (i != j) {
					if (M[i][j] == 1 && !dsu.isConnected(i, j)) {
						dsu.union(i, j);
					}
				}
			}
		}
		int circle = 0;
		for (int i = 0; i < dsu.arr.length; i++) {
			if (dsu.arr[i] == i) {
				circle++;
			}
		}
		System.out.println(circle);
		return circle;
	}

	public static void main(String[] args) {
		int frineds[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 1, 1 } };
		solve(frineds);
	}
}
