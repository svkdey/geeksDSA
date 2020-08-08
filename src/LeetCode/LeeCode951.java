package LeetCode;



public class LeeCode951 {
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
	 public boolean flipEquiv(TreeNode p, TreeNode q) {
	       if(p==null&&q==null) {
	    	   return true;
	       }
	       if(p==null||q==null) {
	    	   return false;
	       }
	       if(p.val==q.val) {
	    	   boolean leftOK=flipEquiv(p.left, q.left);
	    	   boolean rightOK=flipEquiv(p.right, q.right);
	    	   
	    	   if(!leftOK&&!rightOK) {
	    		    leftOK=flipEquiv(p.left, q.right);
		    	    rightOK=flipEquiv(p.right, q.left);
		    	    
		    	    
	    	   }
	    	   return leftOK&&rightOK;
	    			   
	       }else {
	    	   return false;
	       }
	    }
}
