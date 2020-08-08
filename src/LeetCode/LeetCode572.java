package LeetCode;

import Trees.TreeNode;

public class LeetCode572 {
	static boolean result = false;

	public boolean isSubtree(TreeNode s, TreeNode t) {
		inDFS(s, t);
		boolean ans=result;
		result=false;
		return ans;
	}

	void inDFS(TreeNode s, TreeNode t) {
		if (s == null)
			return;
		if (isSametree(s, t)) {
			result = true;
		}
		inDFS(s.left, t);
		inDFS(s.right, t);
	}

	public boolean isSametree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		return s.data == t.data && isSametree(s.left, t.left) && isSametree(s.right, t.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
