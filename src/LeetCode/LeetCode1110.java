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
	 public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		 HashSet<Integer> set=new HashSet<Integer>();
		 for(int node:to_delete) {
			 set.add(node);
		 }
		 List<TreeNode> ans=new ArrayList<TreeNode>();
		 if(root==null) return ans;
		 
		 
	     Queue<TreeNode> q = new LinkedList<TreeNode>();
	     TreeNode dummy=new TreeNode(-999);
	     dummy.left=root;
	     q.add(dummy);
	  
	     while(!q.isEmpty()) {
	    	 int s=q.size();
	    	 for(int i=0;i<s;i++) {
	    		 TreeNode n=q.remove();
	    		 if(n.left!=null) {
	    			 if(set.contains(root.left.val)) {
	    				 if(n.left.left!=null) {
	    					 q.add(n.left.left);
	    					 if(!set.contains(n.left.left.val))ans.add(n.left.left);
	    				 }
	    				 if(n.left.right!=null) {
	    					 q.add(n.left.right);
	    					 if(!set.contains(n.left.right.val)) ans.add(n.left.right);
	    				 }
	    				 n.left=null;
	    			 }else {
	    				 q.add(n.left);
	    			 }
	    		 }
	    		 if(n.right!=null) {
	    			 if(set.contains(root.right.val)) {
	    				 if(n.right.left!=null) {
	    					 q.add(n.right.left);
	    					 if(!set.contains(n.right.left.val))ans.add(n.right.left);
	    				 }
	    				 if(n.right.right!=null) {
	    					 q.add(n.right.right);
	    					 if(!set.contains(n.right.right.val))ans.add(n.right.right);
	    				 }
	    				 n.right=null;
	    			 }else {
	    				 q.add(n.right);
	    			 }
	    		 }
	    	 }
	     }
	     if(dummy.left!=null) {
	    	 ans.add(dummy.left);
	     }
	     System.out.println(ans);
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

			System.out.println(delNodes(root,new int[] {2,3}));

		}
}
