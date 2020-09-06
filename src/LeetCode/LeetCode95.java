package LeetCode;

import java.util.ArrayList;
import java.util.List;

import LeetCode.LeetCode222.TreeNode;

public class LeetCode95 {
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

	public static List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return gen(1, n);
    }
	
	public static List<TreeNode> gen(int s,int e){
		List<TreeNode> res=new ArrayList<TreeNode>();
		if(s>e) {
			res.add(null);
			return res;
		}
		
		for(int i=s;i<=e;i++) {
			List<TreeNode> l=gen(s, i-1);
			List<TreeNode> r=gen(i+1,e);
			
			
			
			for(TreeNode left:l) {
				for(TreeNode right:r) {
					TreeNode root=new TreeNode(i);
					root.left=left;
					root.right=right;
					res.add(root);
				}
			}
		}
		System.out.println(res);
		return res;
	}
	public static void main(String[] args) {
		generateTrees(3);
	}
}
