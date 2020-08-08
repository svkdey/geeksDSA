package LeetCode;

import java.util.*;

import Trees.TreeNode;

public class LeetCode897 {
	void DFS(TreeNode root,ArrayList<Integer> l) {
		if (root == null)
			return;
		
		DFS(root.left,l);
		//node logic
		l.add(root.data);
		DFS(root.right,l);
	}
	 public TreeNode increasingBST(TreeNode root) {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        DFS(root, list);
	        
	        TreeNode head=new TreeNode(list.get(0));
	        TreeNode result=head;
	        for(int i=1;i<list.size();i++) {
	        	head.right=new TreeNode(list.get(i));
	        	head=head.right;
	        }
	        return result;
	    }
}
