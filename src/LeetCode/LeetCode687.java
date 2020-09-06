package LeetCode;

import Trees.TreeNode;

public class LeetCode687 {
	public class TreeNode {
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
	}

	static int count = Integer.MIN_VALUE;

	public int dfs(TreeNode node) {
		if (node == null)
			return 0;

		int l = dfs(node.left);
		int r = dfs(node.right);
		l = (node.left != null && node.val == node.left.val) ? l + 1 : 0;
		r = (node.right != null && node.val == node.right.val) ? r + 1 : 0;
		int ans = r + l;
		count = Math.max(count, ans);
		return Math.max(l, r);
	}

	public int longestUnivaluePath(TreeNode root) {
		count = Integer.MIN_VALUE;
		dfs(root);
		return count;
	}
}
