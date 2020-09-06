package LeetCode;



public class LeetCode814 {
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
	private boolean dfs(TreeNode root) {
		if(root==null) return false;
		boolean l=dfs(root.left);
		boolean r=dfs(root.right);
		if(l==false) root.left=null;
		if(r==false) root.right=null;
		if( root.val==1||r||l) return true;
		else return false;

	}
	 public TreeNode pruneTree(TreeNode root) {
	         dfs(root);
	         return root;
	    }
}
