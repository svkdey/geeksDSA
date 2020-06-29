package Playground.Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import Trees.TreeNode;

public class TreePracticeSession {
	static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	static void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	static void postorder(TreeNode root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	static int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.left);

		return 1 + Math.max(leftHeight, rightHeight);

	}

	static void levelOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.println(node.data + " ");

			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);

		}
	}

	static void LevelordertraversalLinebyLine(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				TreeNode node = q.poll();
				System.out.print(node.data + " ");

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			System.out.println();
		}
	}

	static void maxWidth(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		int width = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			int qsize = q.size();
			width = Math.max(width, qsize);
			for (int i = 0; i < qsize; i++) {
				TreeNode node = q.poll();
				System.out.println(node.data + " ");

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			System.out.println();
		}

		System.out.println("width Of tree : " + width);
	}

	static void LeftViewofBinaryTree(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				TreeNode node = q.poll();
				// checking leftHand size
				if (i == 0) {
					System.out.println(node.data + " ");
				}
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			System.out.println();
		}

	}

	static void RightViewofBinaryTree(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		
		while (!q.isEmpty()) {
			int qsize = q.size();

			for (int i = 0; i < qsize; i++) {
				TreeNode node = q.poll();
				// checking leftHand size
				if (i == qsize - 1) {
					System.out.println(node.data + " ");
				}
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			System.out.println();
		}

	}

	static void verticalProblemsOfTree(TreeNode root) {
		if (root == null)
			return;
		TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<Integer, ArrayList<Integer>>();
		dfsHelper(root, hm, 0);
		System.out.println("vertical height of tree :" + hm.size());
		System.out.println("Top view of tree :");
		System.out.println(hm);
		for (Map.Entry<Integer, ArrayList<Integer>> item : hm.entrySet()) {
			System.out.print(item.getValue().get(0) + "   ");
		}

		System.out.println("bottom view of tree :");
		for (Map.Entry<Integer, ArrayList<Integer>> item : hm.entrySet()) {
			System.out.print(item.getValue().get(item.getValue().size() - 1) + "       ");
		}
	}

	static void dfsHelper(TreeNode root, TreeMap<Integer, ArrayList<Integer>> hm, int lvl) {
		if (root == null)
			return;
		if (hm.containsKey(lvl)) {
			hm.get(lvl).add(root.data);
		} else {
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(root.data);
			hm.put(lvl, l);
		}
		dfsHelper(root.left, hm, lvl - 1);
		dfsHelper(root.right, hm, lvl + 1);

	}

	static void printTreeSpiralForm(TreeNode root) {
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		// u have take root as 1th level
		int i = 1;

		while (!q.isEmpty()) {
			// when even
			int size = q.size();
			//System.out.println(dq);
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
			System.out.println();
		}

	}

	static void insertElementIntoTree(TreeNode root, int value) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node.left != null) {
				q.add(node.left);
			} else {
				node.left = new TreeNode(value);
				break;
			}
			if (node.right != null)
				q.add(node.right);

		}

	}

	static void deleteElementIntoTree(TreeNode root, int value) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		TreeNode NodeThatToBeDeleted = null;
		TreeNode lastNode = null;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.data == value) {
				NodeThatToBeDeleted = node;
			}
			if (node.left != null) {
				if (node.left.left == null && node.left.right == null) {
					lastNode = node;
				}
				q.add(node.left);
			}
			if (node.right != null) {
				if (node.right.left == null && node.right.right == null) {
					lastNode = node;
				}
				q.add(node.right);
			}

		}
		if (lastNode.left != null) {
			NodeThatToBeDeleted.data = lastNode.left.data;
			lastNode.left = null;

		} else {
			NodeThatToBeDeleted.data = lastNode.right.data;
			lastNode.right = null;
		}
	}

	static void countElementIntoTree(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			count++;
			System.out.println(node.data + " ");

			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);

		}
		System.out.println(count);
	}

	static int maxElementIntoTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(root.data, Math.max(maxElementIntoTree(root.left), maxElementIntoTree(root.right)));
	}

	static void printKthLvlIntheTree(TreeNode root, int lvl_K) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		int lvl = 0;
		while (!q.isEmpty()) {
			int qsize = q.size();

			for (int i = 0; i < qsize; i++) {
				TreeNode node = q.poll();
				// checking leftHand size
				if (lvl == (lvl_K - 1)) {
					System.out.println(node.data + " ");
				}
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			lvl++;

		}

	}

	
	static boolean checkLevelorderIsPalindromeOrNot(TreeNode root) {
		if (root == null)
			return false;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<Integer> s = new Stack<Integer>();
		Queue<Integer> q_help = new LinkedList<Integer>();
		q.add(root);
		s.push(root.data);
		q_help.add(root.data);

		while (!q.isEmpty()) {
			int qsize = q.size();

			for (int i = 0; i < qsize; i++) {
				TreeNode node = q.poll();
				// checking leftHand size
				s.push(node.data);
				q_help.add(node.data);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null)
					q.add(node.right);
			}
		}
		if (q_help.size() == s.size()) {
			while (!s.isEmpty()) {
				if (s.pop() != q_help.remove()) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = Data.TreeData.getATree();
		System.out.println(root);
//		maxWidth(root);
//		insertElementIntoTree(root, 30);
//		insertElementIntoTree(root, 700);
//		
//		deleteElementIntoTree(root, 10);
//		LevelordertraversalLinebyLine(root);
		printKthLvlIntheTree(root, 4);
		System.out.println(checkLevelorderIsPalindromeOrNot(root));
		System.out.println();

	}

}
