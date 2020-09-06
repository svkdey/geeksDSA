package LeetCode;



public class LeetCode1372 {
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
	int ans=0;

	void findZigZag(TreeNode root,int l ,int r) {
		if(root==null) return;
		ans=Math.max(Math.max(l, r), ans);
		findZigZag(root.left, r+1, 0);
		findZigZag(root.right, 0, l+1);
		
		
	}
	 public int longestZigZag(TreeNode root) {
	        ans=0;
	        findZigZag(root,0,0);
	        return ans;
	    }
}
