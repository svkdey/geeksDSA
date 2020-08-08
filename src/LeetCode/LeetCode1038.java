package LeetCode;

import LeetCode.LeetCode1261.TreeNode;

public class LeetCode1038 {
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
	int inDFS(TreeNode root,int x) {
		  if (root == null)
				return x;
			x=inDFS(root.right,x);
			root.val+=x;
			x=root.val;
			x=inDFS(root.left,x);
	        	
			return x;
		
		
	}
	public TreeNode bstToGst(TreeNode root) {
	    inDFS(root,0);
        return root;
    }
}
