package Playground.Graph;

import java.util.Arrays;

public class McoloringProblemSpoj {
	static class DisJointSet {
		int set[] = null;

		public DisJointSet(int n) {
			super();
			this.set = new int[n];

			for (int i = 0; i < n; i++) {
				set[i] = i;
			}
		}

		public int find(int x) {
			if (x == set[x]) {
				return x;
			}
			return set[x] = find(set[x]);
		}

		public void union(int v1, int v2) {
			int v1_root = find(v1);
			int v2_root = find(v2);
			if (v1_root == v2_root)
				return;
			else {
				set[v1_root] = Math.max(set[v1_root], set[v2_root]);
				set[v2_root] = Math.max(set[v1_root], set[v2_root]);
			}
		}

		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}

		@Override
		public String toString() {
			return "DisJointSet [set=" + Arrays.toString(set) + "]";
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4, q = 3;
		int l[] = { 1, 2, 2 };
		int r[] = { 3, 4, 3 };
		int c[] = { 2, 6, 7 };

		DisJointSet dsu = new DisJointSet(n + 2);
		int res[] = new int[n + 2];
		System.out.println(dsu);
		for (int i = q - 1; i >= 0; i--) {
			int idx = dsu.find(l[i]);
			while (idx <= r[i]) {
				res[idx] = c[i];
				dsu.union(idx, idx + 1);
				idx = dsu.find(idx);
			}
		}
		for(int x:res) {
			System.out.print(x+" ");
		}
	}

}
