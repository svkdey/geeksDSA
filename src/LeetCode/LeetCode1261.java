package LeetCode;

import java.util.*;



public class LeetCode1261 {
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
	class FindElements {
	    private TreeNode root=null;
	    private HashSet<Integer> list=null;
	    public FindElements(TreeNode root) {
	        this.root=root;
	        this.list=new HashSet<Integer>();
	        recoverTree();
	    }
	    private void recoverTree() {
	    	
	    }
	    
	    public boolean find(int target) {
	        return this.list.contains(target);
	    }
	}
	void inDFS(TreeNode root) {
		
	}

}
