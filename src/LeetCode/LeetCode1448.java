package LeetCode;

public class LeetCode1448 {
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

	static int ans = 0;

	void inDFS(TreeNode root, int parentVal) {
		if (root == null)
			return;
		if (root.val >= parentVal) {
			ans++;
		}
		inDFS(root.left, Math.max(root.val,parentVal));

		inDFS(root.right, Math.max(root.val,parentVal));
	}
	public int goodNodes(TreeNode root) {
		ans = 0;
		inDFS(root, -1000000);
		return ans;
	}
}
