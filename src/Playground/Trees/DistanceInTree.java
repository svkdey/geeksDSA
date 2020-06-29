package Playground.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Trees.TreeNode;

public class DistanceInTree {
	static ArrayList<ArrayList<Integer>> rootToleafPaths = new ArrayList<ArrayList<Integer>>();

	static void printRootToLeafPath(TreeNode root) {
		Integer[] paths = new Integer[100000];
		int pathLen = 0;
		printRootToLeafPathDFS(root, paths, pathLen);
		System.out.println(rootToleafPaths);
	}

	static void printRootToLeafPathDFS(TreeNode root, Integer paths[], int pathLen) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			paths[pathLen++] = root.data;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < pathLen; i++) {
				list.add(paths[i]);
			}
			rootToleafPaths.add(list);
			return;
		}
		paths[pathLen++] = root.data;
		printRootToLeafPathDFS(root.left, paths, pathLen);

		printRootToLeafPathDFS(root.right, paths, pathLen);

		return;
	}

	static void printPathWithSumX() {

	}

	static void printAllrootToLeafSum(TreeNode root) {
		int paths[] = new int[1000];
		int pathLen = 0;
		rootToleafSumDFS(root, paths, pathLen);
	}

	private static int sum(int arr[], int k) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static void rootToleafSumDFS(TreeNode root, int paths[], int pathLen) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			paths[pathLen++] = root.data;
			System.out.print(sum(paths, pathLen) + "    ");
			return;
		}
		paths[pathLen++] = root.data;
		rootToleafSumDFS(root.left, paths, pathLen);
		rootToleafSumDFS(root.right, paths, pathLen);
		return;
	}

	static void printPathToAnElement(TreeNode root, int element) {
		int arr[] = new int[100];
		int pathLen = 0;
		ArrayList<Integer> pathToElementSolution = new ArrayList<Integer>();
		printPathToAnElementUtil(root, arr, pathLen, element, pathToElementSolution);
		System.out.println(pathToElementSolution);
	}

	static void printPathToAnElementUtil(TreeNode root, int paths[], int pathLen, int element,
			ArrayList<Integer> pathToElementSolution) {
		if (root == null)
			return;

		if (root.data == element) {
			paths[pathLen++] = root.data;
			for (int i = 0; i < pathLen; i++) {
				pathToElementSolution.add(paths[i]);
			}
			return;
		}
		paths[pathLen++] = root.data;

		printPathToAnElementUtil(root.left, paths, pathLen, element, pathToElementSolution);
		printPathToAnElementUtil(root.right, paths, pathLen, element, pathToElementSolution);
	}

	static int lowestCommonAnsestor(TreeNode root, int x1, int x2) {
		int path1[] = new int[100];
		int pathLen1 = 0;

		int path2[] = new int[100];
		int pathLen2 = 0;

		ArrayList<Integer> pathToElement1 = new ArrayList<Integer>();
		ArrayList<Integer> pathToElement2 = new ArrayList<Integer>();

		printPathToAnElementUtil(root, path1, pathLen1, x1, pathToElement1);
		printPathToAnElementUtil(root, path2, pathLen2, x2, pathToElement2);

		System.out.println(pathToElement1);
		System.out.println(pathToElement2);

		int element = -1;
		for (int i = 0; i < pathToElement1.size() && i < pathToElement2.size(); i++) {
			if (pathToElement1.get(i) != pathToElement2.get(i)) {
				element = pathToElement1.get(i - 1);
				break;
			}
		}
		return element;
	}

	static ArrayList<Integer> pathBtwnTwoNodes(TreeNode root, int x1, int x2) {
		int path1[] = new int[100];
		int pathLen1 = 0;

		int path2[] = new int[100];
		int pathLen2 = 0;

		ArrayList<Integer> pathToElement1 = new ArrayList<Integer>();
		ArrayList<Integer> pathToElement2 = new ArrayList<Integer>();

		printPathToAnElementUtil(root, path1, pathLen1, x1, pathToElement1);
		printPathToAnElementUtil(root, path2, pathLen2, x2, pathToElement2);

		System.out.println(pathToElement1);
		System.out.println(pathToElement2);

		int i = 0;
		for (i = 0; i < pathToElement1.size() && i < pathToElement2.size(); i++) {
			if (pathToElement1.get(i) != pathToElement2.get(i)) {
				break;
			}
		}
		i = i - 1; // last common idx
		System.out.println(i);
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int k = pathToElement1.size() - 1; k >= i; k--) {
			result.add(pathToElement1.get(k));
		}
		for (int k = i + 1; k < pathToElement2.size(); k++) {
			result.add(pathToElement2.get(k));
		}

		return result;
	}

	/*
	 * 1. find the root path btw x and y by LCA 2. 
	 * 2. sum all the nodes.
	 */
	static void maxSumBtwnTwoNodesInTree(TreeNode root, int x, int y) {
		ArrayList<Integer> allTheNodeBtwnXY = pathBtwnTwoNodes(root, x, y);
		int sum = 0;
		for (int node : allTheNodeBtwnXY) {
			sum += node;
		}
		System.out.println(sum);

	}
	/**
	 * 1.convert the tree into graph.
	 * 2. do level by level BFS on graph
	 * 3. AT GIVEN LEVEL GET ALL NODE IN QUEUE
	 * 
	 * **/

	static void printNodesAtKDistancefromLeaf(TreeNode root, int n, int lvl) {
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 16; i++) {
			g.add(new ArrayList<Integer>());
		}
		treeToGraph(g, root);

		BFStimeToDistance(g, n, lvl);
	}
	
	
	/**
	 * 1.convert the tree into graph.
	 * 2. do level by level BFS on graph
	 * 3. during the that count at which time it visits all nodes
	 * 
	 * */
	static void BurnTheTree(TreeNode root, int x) {
		// tree to graph.
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 16; i++) {
			g.add(new ArrayList<Integer>());
		}
		treeToGraph(g, root);
		BFStime(g, x);

	}

	static void BFStimeToDistance(ArrayList<ArrayList<Integer>> g, int x, int lvl) {
		// tree to graph.

		Queue<Integer> q = new LinkedList<Integer>();
		int time = -1;
		boolean visited[] = new boolean[g.size()];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		q.add(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			int s = q.size();
			time++;

			if (time == lvl) {
				while (!q.isEmpty()) {
					ans.add(q.remove());
				}
				break;
			}
			for (int i = 0; i < s; i++) {
				int v = q.remove();
				for (int child : g.get(v)) {
					if (!visited[child]) {
						visited[child] = true;
						q.add(child);
					}
				}
			}

		}

		System.out.println(ans);

	}

	static int BFStime(ArrayList<ArrayList<Integer>> g, int x) {
		// tree to graph.
		Queue<Integer> q = new LinkedList<Integer>();
		int time = 0;
		boolean visited[] = new boolean[g.size()];

		q.add(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			int s = q.size();
			for (int i = 0; i < s; i++) {
				int v = q.remove();
				for (int child : g.get(v)) {
					if (!visited[child]) {
						visited[child] = true;
						q.add(child);
					}
				}
			}
			time++;
		}

		System.out.println(time - 1);
		return time - 1;

	}

	static void treeToGraph(ArrayList<ArrayList<Integer>> g, TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			g.get(root.data).add(root.left.data);
			g.get(root.left.data).add(root.data);
		}
		if (root.right != null) {
			g.get(root.data).add(root.right.data);
			g.get(root.right.data).add(root.data);
		}
		treeToGraph(g, root.left);
		treeToGraph(g, root.right);

	}

	public static void main(String[] args) {
		TreeNode root = Data.TreeData.getATree2();
//		TreePracticeSession.LevelordertraversalLinebyLine(root);
		System.out.println(root);
//		pathBtwnTwoNodes(root, 70, 50);
		maxSumBtwnTwoNodesInTree(root,1 , 2);
	}

}
