package LeetCode;

public class LeetCode124 {
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

	static int ans=Integer.MIN_VALUE;
	int inDFS(TreeNode root) {
		if (root == null)
			return 0;

		int l=inDFS(root.left);
		//node logic
		int r=inDFS(root.right);
		int subtreeMax=root.val+Math.max(r,l);
		int currentNodeMax=root.val+l+r;
		ans=Math.max(ans, Math.max(subtreeMax, currentNodeMax));
		return Math.max(subtreeMax, root.val);
	}
	
	public int maxPathSum(TreeNode root) {
		ans=Integer.MIN_VALUE;
		inDFS(root);
		return ans;
		
    }
}
