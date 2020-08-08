package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import LeetCode.LeetCode1022.TreeNode;

public class LeetCode654 {
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
	public TreeNode constructMaximumBinaryTree(int[] nums) {
     
       return construct(nums,0,nums.length-1);
        
    }
	public TreeNode construct(int[] nums,int start,int end) {
       if(start>end) {
    	   return null;
       }
		
    	if(start<0) {
    		return null;
    	}
	int maxIdx=start;
	int maxVal=nums[start];
	for(int i=start;i<=end;i++) {
		if(nums[i]>maxVal) {
			maxVal=nums[i];
			maxIdx=i;
		}
	}
	TreeNode root=new TreeNode(maxVal);
	root.left=construct(nums, start,maxIdx-1);
	root.right=construct(nums, maxIdx+1, end);
	return root;
	
	
		
		
    }
}
