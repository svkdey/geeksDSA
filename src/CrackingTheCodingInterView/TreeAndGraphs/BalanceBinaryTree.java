package CrackingTheCodingInterView.TreeAndGraphs;

public class BalanceBinaryTree {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int d) {
			this.data = d;
		}

		@Override
		public String toString() {
			return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		}

	}

	public static boolean solve(Trees.TreeNode treeNode) {
		if (treeNode == null)
			return true;

		int leftHeight = height(treeNode.left);
		int rightHeight = height(treeNode.right);
		return (Math.abs(leftHeight - rightHeight) <= 1 && solve(treeNode.left) && solve(treeNode.right));

	}

	public static int height(Trees.TreeNode root) {
		if (root == null)
			return 0;
		else {
			return 1 + Math.max(height(root.left), height(root.right));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Data.TreeData.getATree2()));
	}

}
