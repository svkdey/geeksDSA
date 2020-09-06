package LeetCode;

public class LeetCode979 {
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

	int moves = 0;

	int inDFS(TreeNode root) {
		if (root == null)
			return 0;

		int l = inDFS(root.left);

		int r = inDFS(root.right);
		moves += Math.abs(l) + Math.abs(r);
		return root.val + r + l - 1;
	}

	public int distributeCoins(TreeNode root) {
		moves = 0;
		inDFS(root);
		return moves;
	}
}
