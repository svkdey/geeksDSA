package LeetCode;

public class LeetCode1325 {
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

	public static TreeNode inDFS(TreeNode root, int target) {
		if (root == null)
			return null;
	

		root.left = inDFS(root.left, target);

		root.right = inDFS(root.right, target);
		if (root.left == null && root.right == null) {
			if (root.val == target) {
				return null;
			}
			
		}
		return root;
	}

	public TreeNode removeLeafNodes(TreeNode root, int target) {
		
	    return inDFS(root, target);
	}
}
