package LeetCode;

public class LeetCode222 {
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


	int inDFS(TreeNode root) {
		if (root == null)
			return 0;

		return 1+inDFS(root.left);
	}
	public int countNodes(TreeNode root) {
		if(root==null) return 0;
		int l=inDFS(root.left);
		int r=inDFS(root.right);
		if(l==r) {
			return (1<<l)+countNodes(root.right);
		}
		else return (1<<r)+countNodes(root.left); 
	}
}
