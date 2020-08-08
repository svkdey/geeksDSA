package LeetCode;

import java.util.*;

import org.w3c.dom.Node;

import LeetCode.LeetCode623.TreeNode;

public class LeetCode623 {
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

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if(d==1) {
			TreeNode n=new TreeNode(v);
			n.left=root;
			return n;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int h=1;
		while(h!=d-1&!q.isEmpty()) {
		
			int s=q.size();
			for(int i=0;i<s;i++) {
			
					TreeNode n=q.remove();
					if(n.left!=null) {
						q.add(n.left);
					}
					if(n.right!=null) {
						q.add(n.right);
					}
				}
			h++;
			
		}
		while(!q.isEmpty()) {
			TreeNode n=q.remove();
			if(n.left==null&&n.right==null) {
				n.left=new TreeNode(v);
				n.right=new TreeNode(v);
			}
			else if(n.left!=null) {
				TreeNode tmp=n.left;
				TreeNode nNode=new TreeNode(v);
				n.left=nNode;
				nNode.left=tmp;
				//q.add(nNode.left);
			}
			else if(n.right!=null) {
				TreeNode tmp=n.right;
				TreeNode nNode=new TreeNode(v);
				n.right=nNode;
				nNode.right=tmp;
			//	q.add(nNode.right);
			}
		}
		return root;
	}
}
