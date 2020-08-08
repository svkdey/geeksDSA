package CrackingTheCodingInterView.TreeAndGraphs;

import Trees.TreeNode;

public class IsBst {
	public static boolean isBst(TreeNode node, int max, int min) {
		if (node == null)
			return true;
		else
			return ((node.data > min && node.data < max) && isBst(node.left, node.data, min)
					&& isBst(node, max, node.data));
	}

	public static boolean solve(Trees.TreeNode treeNode) {
		return isBst(treeNode, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solve(Data.TreeData.getBinarySearchPropertyTree()));
	}

}
