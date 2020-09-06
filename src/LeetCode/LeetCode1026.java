package LeetCode;

import java.util.Arrays;

public class LeetCode1026 {
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
	
	static int ans = -1;

	public int maxAncestorDiff(TreeNode root) {
		ans = -1;
		int pathLen = 0;
		int path[] = new int[100000];
		dfs(root, pathLen, path);
		return ans;
	}

	public void dfs(TreeNode root, int pathLen, int path[]) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			path[pathLen++] = root.val;
			int maxVal=Integer.MIN_VALUE;
			int minVal=Integer.MAX_VALUE;
			for (int i = 0; i < pathLen; i++) {
				maxVal=Math.max(maxVal, path[i]);
				minVal=Math.min(minVal, path[i]);
			}
			ans=Math.max(ans, Math.abs(maxVal-minVal));
			return;
		}
		path[pathLen++] = root.val;
		dfs(root.left, pathLen, path);
		dfs(root.right, pathLen, path);

	}
}
