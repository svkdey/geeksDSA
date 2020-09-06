package LeetCode;

import java.util.Arrays;

public class LeetCode108 {
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

	public TreeNode sortedArrayToBST(int[] nums) {

		return dfs(nums,0,nums.length-1);
	}
	
	public TreeNode dfs(int[] nums,int i,int j) {
		if(i>j) {
			return null;
		}
		int mid=i+(j-i)/2;
		TreeNode root=new TreeNode(nums[mid]);
		root.left=dfs(nums, i, mid-1);
		root.right=dfs(nums, mid+1, j);
		return root;
		
	}
}
