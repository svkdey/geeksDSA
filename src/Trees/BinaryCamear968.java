package Trees;

import java.util.TreeSet;

import LeetCode.LeetCode671.TreeNode;

public class BinaryCamear968 {
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
	public int dfs(TreeNode root) {
		if(root==null) return 2;
		int l=dfs(root.left);
		int r=dfs(root.right);
		
		if(l==0||r==0) {
			ans++;
			return 1;
		}
		return l==1||r==1?2:0;
		
	}
	int ans=0;
	 public int minCameraCover(TreeNode root) {
	     ans=0;   
		 int res=dfs(root);
		 return res==0?1+ans:ans;
	 }
}
