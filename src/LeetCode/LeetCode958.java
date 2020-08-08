package LeetCode;

import java.util.*;

public class LeetCode958 {
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

	public static boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		boolean hitEnd=false;
		while (!q.isEmpty()) {
			int s = q.size();
			
			System.out.println(q);
			for (int i = 0; i < s; i++) {
				
				TreeNode n = q.remove();
				if(hitEnd&&(n.left!=null||n.right!=null)) {
					return false;
				}
				if(n.left==null&&n.right!=null) {
					return false;
				}
				if(n.left!=null&&n.right==null) {
					q.add(n.left);
					hitEnd=true;
				}
				if(n.left!=null&&n.right!=null) {
					q.add(n.left);
					q.add(n.right);
					
				}else {
					hitEnd=true;
				}
				
			}
			
		}
		return true;
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

		System.out.println(isCompleteTree(root));

	}
}
