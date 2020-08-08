package LeetCode;

import java.util.*;

public class LeetCode404 {
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
	
	public int sumOfLeftLeaves(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int sum = 0;
		while (!q.isEmpty()) {
			
				TreeNode node = q.remove();
				if (node.left!=null) {
                    q.add(node.left);
					if (node.left.left == null && node.left.right == null) {
						System.out.println(node.left.val+"-->"+sum);
						sum += node.left.val;
					}
				}
				if (node.right != null) {
					q.add(node.right);
				}
			

		}
		return sum;
	}
}
