package LeetCode;

import java.util.HashMap;

public class LeetCode990 {
	class DisJointSet {
		int arr[] = new int[26];

		public DisJointSet() {
			super();
			for (int i = 0; i < 26; i++) {
				arr[i] = i + 1;
			}
		}

		public int find(int x) {
			if (arr[x] == x)
				return x;
			else
				return arr[x] = find(x);
		}

		public void union(int x, int y) {
			int root_x = find(x);
			int root_y = find(y);
			if (root_x != root_y) {
				arr[root_x] = root_y;
			}
		}

		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}

	}

	public boolean equationsPossible(String[] equations) {

		DisJointSet dsu = new DisJointSet();

		for (String eq : equations) {
			if (eq.contains("==")) {
				dsu.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
			}
		}
		for (String eq : equations) {
			if (eq.contains("!=")) {
				if (dsu.isConnected(eq.charAt(0) - 'a', eq.charAt(3) - 'a')) {
					return false;
				}
			}
		}
		return true;

	}
}
