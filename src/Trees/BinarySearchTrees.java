package Trees;

import Data.TreeData;

public class BinarySearchTrees {
	public static void insertIntoBinaryTree(TreeNode root, int value) {
		TreeNode node = root;
		TreeNode current = null;
		boolean nodeExists = false;
		while (node != null) {
			if (node.data == value) {
				nodeExists = true;
				break;
			} else if (node.data > value) {
				current = node;
				node = node.left;
			} else {
				current = node;
				node = node.right;
			}
		}
		if (!nodeExists && current == null) {
			return;
		}
		if (current.data > value) {
			current.left = new TreeNode(value);
		} else {
			current.right = new TreeNode(value);
		}
		System.out.println(root);
	}

	public static TreeNode insertIntoBinaryTreeRecusive(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
		}
		if (root.data == value) {
			return root;
		} else if (root.data > value) {
			root.left = insertIntoBinaryTreeRecusive(root.left, value);
		} else {
			root.right = insertIntoBinaryTreeRecusive(root.right, value);
		}

		return root;
	}

//	o(h) o(h)
	public static TreeNode deleteIntoBinaryTree(TreeNode root, int value) {
		if (root == null)
			return null;

		// find the node;
		if (root.data > value) {
			root.left = deleteIntoBinaryTree(root.left, value);
		} else if (root.data < value) {
			root.right = deleteIntoBinaryTree(root.right, value);
		}
		// node found
		else {
			// if node is leaf
			if (root.left == null && root.right == null)
				return null;
			// not leaf
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			// internal node
			else {
				TreeNode successor = findSuccessor(root);
				// replace data
				root.data = successor.data;

				// delete successor
				deleteIntoBinaryTree(root.right, successor.data);
			}
		}
		return root;
	}

	// not proper successor function
	static TreeNode findSuccessor(TreeNode root) {
		TreeNode cur = root;
		cur = cur.right;
		while (cur != null && cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TreeData.getBinarySearchPropertyTree());
//		TreeDSAmethods.LVLOrderLineBylineSolutionTwo(TreeData.getBinarySearchPropertyTree());
//		System.out.println(insertIntoBinaryTreeRecusive(TreeData.getBinarySearchPropertyTree(), 3));
//		BSTproblems.findKthSmallestNode(TreeData.getBinarySearchPropertyTree(),3);
//		int arr[]= {2,8,30,15,25,12};
//		BTSproblems.ceilingOnLeftSide(arr, arr.length);
//		System.out.println("Solution "+BSTproblems.fixTheBSTwithSwappedNode(TreeData.getBinarySearchPropertyTree()));
//		BSTproblems.getSumPairTwo(TreeData.getBinarySearchPropertyTree(), 30);
		BSTproblems.getVerticalSumRecusive(TreeData.getBinarySearchPropertyTree());
	}

}
