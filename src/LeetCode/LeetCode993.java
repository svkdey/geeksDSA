package LeetCode;

import java.util.*;

import Trees.TreeNode;

public class LeetCode993 {
	static class Details {
		int h, parent;

		public Details(int h, int parent) {
			super();
			this.h = h;
			this.parent = parent;
		}

		@Override
		public String toString() {
			return "Details [h=" + h + ", parent=" + parent + "]";
		}

	}

	public boolean isCousins(TreeNode root, int x, int y) {
		HashMap<Integer, Details> map = new HashMap<Integer, Details>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int h = 0;
		q.add(root);
		map.put(root.data, new Details(0, -1));
		while (!q.isEmpty()) {

			int s = q.size();
			h++;
			for (int i = 0; i < s; i++) {
				TreeNode n = q.remove();
				if (n.left != null) {
					q.add(n.left);
					map.put(n.left.data, new Details(h, n.data));
				}
				if (n.right != null) {
					q.add(n.right);
					map.put(n.right.data, new Details(h, n.data));
				}
			}
		}
		boolean result = (map.get(x).h == map.get(y).h) && (map.get(x).parent != map.get(y).parent);
		return result;
	}
}
