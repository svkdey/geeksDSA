package LeetCode;

public class LeetCode450 {
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

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;

		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			}
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {

				TreeNode preVal = findSuccessor(root);

				root.val = preVal.val;
				root.right= deleteNode(root.right, preVal.val);

			}
		}
		return root;
	}

	static TreeNode findSuccessor(TreeNode head) {
		TreeNode root = head;
		if (root.right != null) {
			root = root.right;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
}
