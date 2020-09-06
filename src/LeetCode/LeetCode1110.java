package LeetCode;

import java.util.*;

import LeetCode.LeetCode958.TreeNode;

public class LeetCode1110 {
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

	private static boolean dfs(TreeNode root, HashSet<Integer> set, List<TreeNode> ans) {
		if (root == null) {
			return false;
		}
		boolean l = dfs(root.left, set, ans);
		boolean r = dfs(root.right, set, ans);
		if (l == true) {
			if (root.left.left != null) {
				ans.add(root.left.left);
			}
			if (root.left.right != null) {
				ans.add(root.left.right);
			}
		}
		if (r == true) {
			if (root.right.left != null) {
				ans.add(root.right.left);
			}
			if (root.left.right != null) {
				ans.add(root.left.right);
			}
		}
		return set.contains(root.val);

	}

	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int x : to_delete) {
			set.add(x);
		}
		List<TreeNode> ans = new ArrayList<TreeNode>();
		TreeNode dummy = new TreeNode(-999);
		TreeNode head = dummy;
		dummy.left = root;
		dfs(dummy, set, ans);
		if (head.left != null) {
			ans.add(head.left);
		}
		return ans;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);

		TreeNode e = new TreeNode(6);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;

		b.left = e;

		System.out.println(delNodes(root, new int[] { 2, 3 }));

	}
}
