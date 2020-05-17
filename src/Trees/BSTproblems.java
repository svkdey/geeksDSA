package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class BSTproblems {
	//floor is last right move in BST
	public static int findFloor(TreeNode root, int val) {
		if (root == null) {
			return -1;
		}
		int floor = -1;
		while (root != null) {
			if (root.data == val) {
				return root.data;
			}
			if (root.data > val) {
				root = root.left;
			} else {
				floor = root.data;
				root = root.right;
			}

		}
		return floor;
	}
	//floor is last left move in BST
	public static int findCiel(TreeNode root, int val) {
		if (root == null) {
			return -1;
		}
		int ciel = -1;
		while (root != null) {
			if (root.data == val) {
				return root.data;
			}
			if (root.data > val) {
				ciel = root.data;
				root = root.left;

			} else {
				root = root.right;
			}

		}
		return ciel;
	}

//	(o(nLog(n)))
	public static void ceilingOnLeftSide(int arr[], int n) {
		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < n; i++) {

			if (ts.ceiling(arr[i]) != null) {
				System.out.print(ts.ceiling(arr[i]) + " ");
			} else {
				System.out.print(-1 + " ");
			}

			ts.add(arr[i]);
		}
	}

	static int count = 0;

	public static void findKthSmallestNode(TreeNode root, int k) {
		if (root == null)
			return;

		findKthSmallestNode(root.left, k);
		count++;
		if (count == k) {
			System.out.println(root.data);
			System.exit(1);
		}
		findKthSmallestNode(root.right, k);

	}

//wrong solution. do not do this
	public static boolean ifBinaryTree(TreeNode root) {
		if (root == null)
			return false;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode n = q.remove();
			boolean lhs = n.left == null ? true : (n.left != null && n.left.data < n.data) ? true : false;
			boolean rhs = n.right == null ? true : (n.right != null && n.right.data > n.data) ? true : false;

			if (!(lhs && rhs)) {
				return false;
			}
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
		return true;
	}

//best and tricky method
	public static boolean ifBSThelper(TreeNode root, int max, int min) {
		if (root == null)
			return true;
		return (root.data > min && root.data < max && ifBSThelper(root.left, root.data, min)
				&& ifBSThelper(root.right, max, root.data));
	}

	public static boolean ifBST(TreeNode root) {
		return ifBSThelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	// 2nd method

	/*
	 * check inorder traversal is sorted or not
	 * 
	 */
	public static void ifBSThelper2(TreeNode root, ArrayList<Integer> res) {
		if (root == null)
			return;
		ifBSThelper2(root.left, res);
		res.add(root.data);
		ifBSThelper2(root.right, res);
	}

	public static boolean ifBST2(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ifBSThelper2(root, result);
		for (int i = 0; i < result.size() - 1; i++) {
			if (result.get(i + 1) > result.get(i)) {

			} else {
				return false;
			}
		}
		return true;
	}

	// vvi problem .. mainly array points finding part
	public static TreeNode fixTheBSTwithSwappedNode(TreeNode root) {
		TreeNode node = root;
		int prev = Integer.MIN_VALUE, first = -1, second = -1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		ifBSThelper2(root, result);

		for (int i : result) {
			if (prev > i) {
				if (first == -1) {
					first = prev;
				}
				second = i;
			}
			prev = i;
		}
		TreeNode nod1 = node, nod2 = node;
		TreeNode firstNode = findATreeNode(nod1, first);
		TreeNode secondNode = findATreeNode(nod2, second);

//		System.out.println(">>>>"+firstNode+" "+secondNode);
		firstNode.data = second;
		secondNode.data = first;

		return node;

	}

	static TreeNode findATreeNode(TreeNode root, int value) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null) {
			return null;
		} else {
			q.add(root);

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = q.remove();
					if (node.data == value) {
						return node;
					}
					if (node.left != null) {
						q.add(node.left);
					}
					if (node.right != null) {
						q.add(node.right);
					}
				}

			}
			return null;
		}

	}

	// (o n*2)
	public static void getSumPair(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		TreeNode nodeRoot = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			TreeNode foundNode = findATreeNode(nodeRoot, sum - node.data);
			if (foundNode != null) {
				System.out.println(node.data + " " + foundNode.data);
				break;
			}
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}

	}

	/*
	 * solution 2 find the in order traversal and get the array.' use two pointer
	 * approach to get the sum
	 * 
	 * solution 3: Hash the-> data:(sum-data) if(hash.containsValues(data)){ //found
	 * code }
	 * 
	 */
	public static void getSumPairTwo(TreeNode root, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ifBSThelper2(root, result);
//		System.out.println(result);
		int i = 0, j = result.size() - 1;
		while (j > i) {
			int sumOfij = result.get(i) + result.get(j);
			if (sumOfij == sum) {
				System.out.println(result.get(i) + " " + result.get(j));
			}
			if (sumOfij == sum) {
				j--;
			} else {
				i++;
			}
		}

	}

	public static void getVerticalSum(TreeNode root, int lvl) {

		if (root == null) {
			return;
		}

		TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>();
		Queue<Pair> q = new LinkedList<Pair>();
		Pair p = new Pair(root, 0);
		q.add(p);

		while (!q.isEmpty()) {
			Pair data = q.remove();
			int level = data.horizontalLevel;
			TreeNode aNode = data.node;
			if (hm.containsKey(level)) {
				hm.put(level, hm.get(level) + aNode.data);
			} else {
				hm.put(level, aNode.data);
			}
			if (aNode.left != null) {
				q.add(new Pair(aNode.left, level - 1));
			}
			if (aNode.right != null) {
				q.add(new Pair(aNode.right, level + 1));
			}
		}
		System.out.println(hm);
	}

	public static void getVerticalSumRecusive(TreeNode root) {

		if (root == null) {
			return;
		}

		TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>();
		getVSumRecusive(root, 0, hm);
		System.out.println(hm);
	}

	public static void getVSumRecusive(TreeNode root, int lvl, TreeMap<Integer, Integer> hm) {
		if (root == null)
			return;
		if (hm.containsKey(lvl)) {
			hm.put(lvl, hm.get(lvl) + root.data);
		} else {
			hm.put(lvl, root.data);
		}
		getVSumRecusive(root.left, lvl - 1, hm);
		getVSumRecusive(root.right, lvl + 1, hm);

	}

}
