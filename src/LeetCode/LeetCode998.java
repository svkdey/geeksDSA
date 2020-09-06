package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class LeetCode998 {
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

	TreeNode inDFS(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		 if (val > root.val) {
	            TreeNode n = new TreeNode(val);
	            n.left = root;
	            return n;
	        } 
		root.right=inDFS(root, val);
		return root;
		
	}

	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		return inDFS(root, val);
	}
}
