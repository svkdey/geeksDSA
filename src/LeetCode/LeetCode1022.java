package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode1022 {
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

	 static int ans =0;

		public static void inDFS(TreeNode root, int path[], int start) {
			if (root == null)
				return;
			if (root.left == null && root.right == null) {
	            path[start++] = root.val;
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<start;i++) {
					sb.append(Integer.toString(path[i]));
				}
				ans+=Integer.parseInt(sb.toString(),2);
				return;
			}
			path[start++] = root.val;

			inDFS(root.left, path, start);

			inDFS(root.right, path, start);
		}
	    public int sumRootToLeaf(TreeNode root) {
	        int path[] = new int[10000];
			int start = 0;
	        ans=0;
	        if(root==null) return 0;
			inDFS(root,path,start);
			return ans;
	    }
}
