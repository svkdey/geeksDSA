package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Data.TreeData;

public class TreePathProblems {
	static ArrayList<ArrayList<Integer>> printPathResult = new ArrayList<ArrayList<Integer>>();

	static void printPath(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int pathLength = 0;

		printPathUtil(root, arr, pathLength);
		System.out.println(printPathResult);

	}

	static void printPathUtil(TreeNode root, ArrayList<Integer> arr, int pathLength) {
		if (root == null) {
			return;
		}
		if (arr.size() > pathLength) {
			arr.set(pathLength, root.data);
		} else {
			arr.add(pathLength, root.data);
		}
		pathLength++;

		// we reached to leaf
		if (root.left == null && root.right == null) {
			ArrayList<Integer> res = new ArrayList<Integer>(arr);

			printPathResult.add(res);
			return;
		}
		printPathUtil(root.left, arr, pathLength);
		printPathUtil(root.right, arr, pathLength);
	}

	static int maxSum = Integer.MIN_VALUE;
	static List<Integer> res = new ArrayList<Integer>();

	static void findMaxrootToLeafPathWhereSumIsMax(TreeNode node) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int pathLength = 0;
		pathSumMaxUtil(node, list, pathLength);
		System.out.println(res);
		int sum = maxSum;
		maxSum = 0;
		System.out.println(sum);

	}

	static void pathSumMaxUtil(TreeNode root, ArrayList<Integer> list, int pathLength) {
		if (root == null) {
			return;
		}

		if (list.size() > pathLength) {
			list.set(pathLength, root.data);
		} else {
			list.add(pathLength, root.data);
		}
		pathLength++;
		if (root.left == null && root.right == null) {

			int s = calculateSum(list, pathLength);

			int sum = Math.max(maxSum, s);

			if (sum > maxSum) {
				maxSum = sum;
				res = list;

			}
			return;
		}
		pathSumMaxUtil(root.left, list, pathLength);
		pathSumMaxUtil(root.right, list, pathLength);
	}

	static int calculateSum(ArrayList<Integer> list, int size) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += list.get(i);
		}
		return sum;
	}

	static void rootToNodePath(TreeNode node, int key) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		if (findThePath(node, key, path)) {
			System.out.println(path);
		} else {
			System.out.println("no path exists");
		}
	}

	static boolean findThePath(TreeNode node, int key, ArrayList<Integer> path) {
		// if null return no path
		if (node == null)
			return false;

		// add key in path

		path.add(node.data);
		// if key found return

		if (node.data == key) {
			return true;
		}
		// not found check if it is in left or right sub tree
		if (findThePath(node.left, key, path) || findThePath(node.right, key, path)) {
			return true;
		}
		// remove the last added node as it not in path
		path.remove(path.size() - 1);
		return false;
	}

	static int lowestCommonAnsestor(TreeNode node, int key1, int key2) {
		ArrayList<Integer> path1 = new ArrayList<Integer>();
		TreeNode node1 = node;
		TreeNode node2 = node;
		findThePath(node1, key1, path1);
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		findThePath(node2, key2, path2);
//		System.out.println(path1+" " +path2);
		for (int i = 0; i < path2.size() && i < path2.size(); i++) {
			if (path1.get(i + 1) != path2.get(i + 1)) {
				return path1.get(i);
			}
		}
		return -1;

	}

	static void pathFromOneNodeToAnother(TreeNode node, int key1, int key2) {
		ArrayList<Integer> path1 = new ArrayList<Integer>();
		TreeNode node1 = node;
		TreeNode node2 = node;
		findThePath(node1, key1, path1);
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		findThePath(node2, key2, path2);
//		System.out.println(path1+" " +path2);
		int i = 0;
		for (i = 0; i < path2.size() && i < path2.size(); i++) {
			if (path1.get(i + 1) != path2.get(i + 1)) {
				break;
			}
		}
		for (int j = path1.size() - 1; j >= i; j--) {
			System.out.print(path1.get(j) + " ");
		}
		for (int j = i + 1; j < path2.size(); j++) {
			System.out.print(path2.get(j) + " ");
		}
		Deque<Integer> a = new LinkedList<>();
	}

//max value btwn two nodes
	static int maxSumBtwNodeValues = Integer.MIN_VALUE;

	int findMaxUtil(TreeNode node) {
		// Base Case
		if (node == null)
			return 0;

		// l and r store maximum path sum going through left and
		// right child of root respectively
		int l = findMaxUtil(node.left);
		int r = findMaxUtil(node.right);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + node.data, node.data);

		// Max Top represents the sum when the Node under
		// consideration is the root of the maxsum path and no
		// ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + node.data);

		// Store the Maximum Result.
		maxSumBtwNodeValues = Math.max(maxSumBtwNodeValues, max_top);

		return max_single;
	}

	int findMaxSum(TreeNode node) {

		findMaxUtil(node);
		return maxSumBtwNodeValues;
	}

	// Print all nodes at distance k from a given node
	static int count = 0;

	static int printKDistantfromLeaf(TreeNode node, int k) {
		// Write your code here
		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		kDistantFromLeafUtil(node, path, visited, 0, k);
		int res = count;
		count = 0;
		return res;

	}

	static void kDistantFromLeafUtil(TreeNode node, int path[], boolean visited[], int pathLen, int k) {
		// Base case
		if (node == null)
			return;

		/* append this Node to the path array */
		path[pathLen] = node.data;
		visited[pathLen] = false;
		pathLen++;

		/*
		 * it's a leaf, so print the ancestor at distance k only if the ancestor is not
		 * already printed
		 */
		if (node.left == null && node.right == null && pathLen - k - 1 >= 0 && visited[pathLen - k - 1] == false) {
			count++;
			visited[pathLen - k - 1] = true;
			return;
		}

		/* If not leaf node, recur for left and right subtrees */
		kDistantFromLeafUtil(node.left, path, visited, pathLen, k);
		kDistantFromLeafUtil(node.right, path, visited, pathLen, k);
	}

	public static void main(String[] args) {
		System.out.println(TreeData.getATree());
//		findMaxrootToLeafPathWhereSumIsMax(TreeData.getChildSumPropertyTree());
//		System.out.println(lowestCommonAnsestor(TreeData.getATree(),70,50));
		System.out.println(printKDistantfromLeaf(TreeData.getATree(),2));
	}

}
