package Trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMediumProblems {
	public static boolean childSumProperty(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			int left = node.left != null ? node.left.data : 0;
			int right = node.right != null ? node.right.data : 0;
			if (left == 0 && right == 0) {

			} else {
				if (node.data != left + right) {
					return false;
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
		return true;
	}

	// tough thinking
	public static boolean childSumPropertyRecusive(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null || root.right == null) {
			return true;
		}

		int left = root.left != null ? root.left.data : 0;
		int right = root.right != null ? root.right.data : 0;
		return (root.data == (left + right) && childSumProperty(root.left) && childSumProperty(root.right));
	}

//o (n*n-1) solution
	public static boolean ifHeightBalancedTree(TreeNode root) {
		if (root == null)
			return true;
		int leftHeight = TreeDSAmethods.heightOfBinaryTree(root.left);
		int rightHeight = TreeDSAmethods.heightOfBinaryTree(root.right);

		return (Math.abs(leftHeight - rightHeight) <= 1 && ifHeightBalancedTree(root.left)
				&& ifHeightBalancedTree(root.right));
	}

	// o(n) by tricking result of left and right hand tree
	public static int ifHeightBalancedTreeSolTwo(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = ifHeightBalancedTreeSolTwo(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = ifHeightBalancedTreeSolTwo(root.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		else
			return (Math.max(leftHeight, rightHeight)) + 1;
	}

	public static void spriralOrderTraversal(TreeNode root) {

		Deque<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null) {
			return;
		} else {
			q.add(root);
			int i = 1;
			while (!q.isEmpty()) {
				int size = q.size();
				if (i % 2 != 0) {
					for (int j = 0; j < size; j++) {
						TreeNode node = q.removeFirst();
						System.out.print(node.data + " ");
						if (node.left != null) {
							q.addLast(node.left);
						}
						if (node.right != null) {
							q.addLast(node.right);
						}
					}
				} else {
					for (int j = 0; j < size; j++) {
						TreeNode node = q.removeLast();
						System.out.print(node.data + " ");
						if (node.right != null) {
							q.addFirst(node.right);
						}
						if (node.left != null) {
							q.addFirst(node.left);
						}
					}
				}
				i++;
			}
		}

	}

}
