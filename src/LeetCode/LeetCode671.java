package LeetCode;

import java.util.TreeSet;

public class LeetCode671 {
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
	public void dfs(TreeNode root,TreeSet<Integer> ts) {
		if(root==null) return;
		ts.add(root.val);
		dfs(root.left, ts);
		dfs(root.right, ts);
		
	}
	   public int findSecondMinimumValue(TreeNode root) {
	       TreeSet<Integer> ts=new TreeSet<>();
	       dfs(root, ts);
	       if(ts.size()>1) {
	    	   int c=2;
	    	   int ans=0;
	    	   for(int x:ts) {
	    		   c--;
	    		   ans=x;
	    		   if(c==0) {
	    			   break;
	    		   };
	    	   }
	    	   return ans;
	       }else {
	    	   return -1;
	       }
	    }
}
