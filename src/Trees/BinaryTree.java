package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Data.TreeData;

public class BinaryTree {
	TreeNode root;

//Constructor
	public BinaryTree() {
	}

	void insert(int data) {

	}

	void delete(int data) {

	}

//o(n) =>run time
//aux => o(h)
	void inOrderTraversal(TreeNode root, ArrayList<Integer> res) {

		if (root != null) {
			if (root.left != null) {
				inOrderTraversal(root.left, res);
			}
			res.add(root.data);
			if (root.right != null) {
				inOrderTraversal(root.right, res);
			}
		}
	}

	// o(n) ,aux space =>o(h)
	void preOrderTraversal(TreeNode root, ArrayList<Integer> res) {

		if (root != null) {
			res.add(root.data);
			if (root.left != null) {
				preOrderTraversal(root.left, res);
			}
			if (root.right != null) {
				preOrderTraversal(root.right, res);
			}
		}

	}

	void postOrderTraversal(TreeNode root, ArrayList<Integer> res) {

		if (root != null) {

			if (root.left != null) {
				postOrderTraversal(root.left, res);
			}
			if (root.right != null) {
				postOrderTraversal(root.right, res);
			}
			res.add(root.data);
		}

	}

	// time complexity =>o(n)
	// aux =o(width)
	void BFTravarsal(TreeNode root, ArrayList<Integer> res) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null) {
			return;
		} else {
			q.add(root);
			while (!q.isEmpty()) {
				TreeNode node = q.remove();
				res.add(node.data);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}

			}
		}
	}

	
	public static void main(String[] args) {

		System.out.println(TreeData.getATree());
		BinaryTree tree = new BinaryTree();
		ArrayList<Integer> res = new ArrayList<Integer>();
//		TreeDSAmethods.LVLOrderLineBylineSolutionTwo(TreeData.getATree());
//		TreeDSAmethods.printKthLvlInBinaryTreeByRecusion(TreeData.getATree(), 1);
//		TreeDSAmethods.leftHandSideOfTreeItarative(TreeData.getATree());
//		System.out.println(TreeMediumProblems.childSumPropertyRecusive(TreeData.getChildSumPropertyTree()));
		
		
		TreeMediumProblems.spriralOrderTraversal(TreeData.getATree());
	}
}
