package Trees;

import LeetCode.LeetCode508.TreeNode;

public class LeetCode1008 {
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

	public TreeNode bstFromPreorder(int[] preorder) {

		return dfs(preorder, 0);
	}

	public TreeNode dfs(int[] nums, int i) {
		if (i == nums.length) {
			return null;
		}

		TreeNode root = new TreeNode(nums[i]);

		if (nums[i + 1] > nums[i]) {
			root.right = dfs(nums, i + 1);
		} else {
			root.left = dfs(nums, i + 1);
		}

		return root;

	}
}
