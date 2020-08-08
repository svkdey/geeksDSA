package CrackingTheCodingInterView.TreeAndGraphs;

import Trees.TreeNode;

public class CheckBalanced {
	private static int height(TreeNode node) {

		if (node == null)
			return 0;
		else
			return 1 + Math.max(height(node.left), height(node.right));

	}

	public static boolean solve(TreeNode root) {
		if (root == null) {
			return true;
		}
		int lH = height(root.left);
		int rH = height(root.right);

		return Math.abs(lH - rH) == 1 && solve(root.left) && solve(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
