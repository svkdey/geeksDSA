package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode113 {
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

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		int path[] = new int[1000000];
		int pathLen = 0;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		dfs(root, sum, ans, path, pathLen);
		return ans;
	}

	public void dfs(TreeNode root, int target, List<List<Integer>> ans, int path[], int pathLen) {
		if (root == null) {
			return;
		}
		path[pathLen++] = root.val;

		if (target - root.val == 0 && root.left == null && root.right == null) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < pathLen; i++) {
				l.add(path[i]);
			}
			ans.add(l);
			return;
		}

		dfs(root.left, target - root.val, ans, path, pathLen);
		dfs(root.right, target - root.val, ans, path, pathLen);
	}
}
