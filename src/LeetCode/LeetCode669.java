package LeetCode;

import LeetCode.LeetCode1372.TreeNode;

public class LeetCode669 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}

	public TreeNode trimBST(TreeNode root, int L, int R) {

		if (root == null)
			return root;
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		if (root.val > R)
			return root.left;
		if (root.val < L)
			return root.right;
		return root;

	}
}
