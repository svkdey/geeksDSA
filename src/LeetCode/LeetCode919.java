package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode919 {
	class CBTInserter {
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
		TreeNode root=null;
		
	    public CBTInserter(TreeNode n) {
	        root=n;
	    }
	    
	    public int insert(int v) {
	        Queue<TreeNode> q=new LinkedList<TreeNode>();
	        q.add(root);
	        while(!q.isEmpty()) {
	        	TreeNode node=q.remove();
	        	if(node.left==null) {
	        		node.left=new TreeNode(v);
	        		return node.val;
	        	}else {
	        		q.add(node.left);
	        	}
	        	
	        	if(node.right==null) {
	        		node.right=new TreeNode(v);
	        		return node.val;
	        	}else {
	        		q.add(node.right);
	        	}
	        }
	        return root.val;
	    }
	    
	    public TreeNode get_root() {
	        return root;
	    }
	}

}
