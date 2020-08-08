package LeetCode;

public class LeetCode437 {
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

	static int count = 0;

	public int pathSum(TreeNode root, int sum) {
		count = 0;
		pathSumUtil(root, sum);
	
		
		return count;
	}

	public void pathSumUtil(TreeNode root, int sum) {
		if (root == null)
			return;
		dfs(root, sum);
		pathSumUtil(root.left, sum);
		pathSumUtil(root.right, sum);
	}

	public void dfs(TreeNode root, int s) {
		if (root == null) {
			return;
		}
		if (root.val == s) {
			count++;
		}

		dfs(root.left, s - root.val);
		dfs(root.right, s - root.val);

	}
}
