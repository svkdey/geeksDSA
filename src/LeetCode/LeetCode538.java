package LeetCode;

import LeetCode.LeetCode508.TreeNode;

public class LeetCode538 {
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
	  public TreeNode convertBST(TreeNode root) {
	         dfs(root, 0);
	         return root;
	    }
	  public int dfs(TreeNode root,int l) {
	        if(root==null) return 0;
	        l=dfs(root.right,l);
	        root.val+=l;
	        l=root.val;
	        l=dfs(root.left,l);
	        
	        return l;
	    }
}
