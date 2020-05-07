package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDSAmethods {
	private static int maxLvl = 0;

	public static void LVLOrderLineByline(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null) {
			return;
		} else {
			q.add(root);
			q.add(null);
			while (q.size() > 1) // in last null will be in queue
			{
				TreeNode node = q.remove();
				if (node == null) {
					System.out.println();
					q.add(null);

				} else {
					System.out.print(node.data + " ");
					if (node.left != null) {
						q.add(node.left);
					}
					if (node.right != null) {
						q.add(node.right);
					}
				}
			}
		}

	}

	public static void LVLOrderLineBylineSolutionTwo(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null) {
			return;
		} else {
			q.add(root);

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = q.remove();
					System.out.print(node.data + " ");
					if (node.left != null) {
						q.add(node.left);
					}
					if (node.right != null) {
						q.add(node.right);
					}
				}
				System.out.println();
			}
		}

	}

	// number of node =size
	// S:o(h) T:o(n)
	public static int sizeOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
	}

	// o(n) o(w)
	public static int maxInTree(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int maxVal = root.data;
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			maxVal = Math.max(maxVal, node.data);
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}

		}
		return maxVal;
	}

	// o(n) o(h)
	public static int maxInTreeRecusiveSoultion(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		// return max (parent,child) recursively
		else
			return Math.max(root.data, Math.max(maxInTreeRecusiveSoultion(root.left), maxInTreeRecusiveSoultion(root.right)));
	}

	// o(n) o(h)
	public static int heightOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		// return max (parent,child) recursively
		else
			return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
	}

	public static void printKthLvlInBinaryTree(TreeNode root, int lvl) {
		if (root == null)
			System.out.println("tree doesnot exist"); // return max (parent,child) recursively
		else {
			int j = 0;
			Queue<TreeNode> s = new LinkedList<TreeNode>();
			s.add(root);
			while (!s.isEmpty() && j < lvl) {

				int size = s.size();
				for (int i = 0; i < size; i++) {
					TreeNode temp = s.remove();
					if (temp.left != null) {
						s.add(temp.left);
					}
					if (temp.right != null) {
						s.add(temp.right);
					}
				}
				j++;
			}
			while (!s.isEmpty()) {
				TreeNode temp = s.remove();
				System.out.print(temp.data + " ");
			}
		}
	}

	public static void printKthLvlInBinaryTreeByRecusion(TreeNode root, int lvl) {
		if (root == null)
			return;
		// return max (parent,child) recursively
		if (lvl == 0) {
			System.out.print(root.data + " ");
		} else {
			printKthLvlInBinaryTreeByRecusion(root.left, lvl - 1);
			printKthLvlInBinaryTreeByRecusion(root.right, lvl - 1);
		}

	}

	public static void leftHandSideOfTree(TreeNode root, int lvl) {

		if (root == null)
			return;
		if (lvl > maxLvl) {
			System.out.print(root.data + " ");
			maxLvl = lvl;
		}
		leftHandSideOfTree(root.left, lvl + 1);
		leftHandSideOfTree(root.right, lvl + 1);
	}

	public static void leftHandSideOfTreeItarative(TreeNode root) {

		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			boolean printFlag = true;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.remove();
				if (printFlag) {
					System.out.print(node.data + " ");
					printFlag = false;
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
	}

	public static void printLeftSideOnly(TreeNode root) {
		leftHandSideOfTree(root, 1);
	}

}
