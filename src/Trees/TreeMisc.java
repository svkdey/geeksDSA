package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMisc {
	// Check if the level order traversal of a Binary Tree results in a palindrome .

	static boolean checkLevelorderIsPalindromeOrNot(TreeNode root) {
		TreeNode node = root;
		Stack<Integer> s = new Stack<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		// push all element in stack
		while (!q.isEmpty()) {
			TreeNode n = q.remove();
			s.push(n.data);
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
		// pop all and compare while level order traversing
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode n = q.remove();
			if (n.data != s.pop()) {
				return false;
			}
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
		if (s.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

//https://practice.geeksforgeeks.org/problems/foldable-binary-tree/1/?track=PC-W6-T&batchId=154
	boolean IsFoldable(TreeNode node) {
		// your code

		if (node == null)
			return true;

		makeMirror(node.left);

		return isStructureSame(node.left, node.right);

	}

	void makeMirror(TreeNode node) {
		// your code
		if (node == null)
			return;
		makeMirror(node.left);
		makeMirror(node.right);
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	boolean isStructureSame(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 != null && node2 != null && isStructureSame(node1.left, node2.left)
				&& isStructureSame(node1.right, node2.right)) {
			return true;
		}
		return false;
	}

	static class QNode {
		TreeNode node;
		int min, max;

		public QNode(TreeNode node) {
			this.node = node;
			this.min = Integer.MIN_VALUE;
			this.max = Integer.MAX_VALUE;
		}

	}

	public static TreeNode constructBST(int[] arr) {
		TreeNode root = new TreeNode(arr[0]);

		Queue<QNode> q = new LinkedList<>();
		q.add(new QNode(root));

		QNode curr;

		// traverse the array elements and using method of level order traversal
		// to construct BST
		for (int i = 1; i < arr.length;) {
			curr = q.poll();

			if (i < arr.length && arr[i] < curr.node.data && arr[i] > curr.min) {
				TreeNode leftNode = new TreeNode(arr[i]);
				curr.node.left = leftNode;

				QNode newQnode = new QNode(leftNode);
				newQnode.min = curr.min;
				newQnode.max = curr.node.data;

				q.add(newQnode);
				i++;
			}

			if (i < arr.length && arr[i] > curr.node.data && arr[i] < curr.max) {
				TreeNode rightNode = new TreeNode(arr[i]);
				curr.node.right = rightNode;

				QNode newQnode = new QNode(rightNode);
				newQnode.min = curr.node.data;
				newQnode.max = curr.max;

				q.add(newQnode);
				i++;
			}

		}
		return root;
	}

	public static void main(String[] args) {
		int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		System.out.println(constructBST(arr));
	}
}
