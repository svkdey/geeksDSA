package Playground.Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import LinkedList.LinkedListNode;
import Trees.TreeDSAmethods;
import Trees.TreeNode;

public class ConversionProblems {
	private static LinkedListNode generateLinkedList(int arr[]) {

		LinkedListNode head = new LinkedListNode(arr[0]);
		LinkedListNode current = head;

		for (int i = 1; i < arr.length; i++) {
			current.next = new LinkedListNode(arr[i]);
			current = current.next;
		}
		return head;
	}

	public static TreeNode LLtoTree(LinkedListNode head) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(head.data);
		q.add(root);
		head = head.next;
		while (head != null) {
			TreeNode n = q.remove();

			int leftNodeVal = head != null ? head.data : -1;
//			System.out.println("leftNodeVal "+ leftNodeVal);
			if (leftNodeVal != -1) {
				head = head.next;
				n.left = new TreeNode(leftNodeVal);
			} else {
				n.left = null;
			}

			q.add(n.left);
			int rightNodeVal = head != null ? head.data : -1;
//			System.out.println("rightNodeVal "+ rightNodeVal);
			if (rightNodeVal != -1) {
				n.right = new TreeNode(rightNodeVal);
				head = head.next;
			} else {
				n.right = null;
			}
			q.add(n.right);

		}

		return root;
	}

	public static TreeNode constructFormParentArray(int arr[], int n) {
		HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
		for (int i = 0; i < n; i++) {
			map.put(i, new TreeNode(i));
		}
		TreeNode root = null;
		for (int i = 0; i < n; i++) {
			if (arr[i] == -1) {
				root = map.get(i);
			} else if (map.get(arr[i]).left == null) {
				map.get(arr[i]).left = map.get(i);
			} else {
				map.get(arr[i]).right = map.get(i);
			}
		}
		return root;
	}
	// left ->back link //right-> forwardLink

	static TreeNode head = null;
	static TreeNode prev = null;

	public static void flattenToDoublyLL(TreeNode root) {
		head = null;
		prev = null;
		flattenToDoublyLLutil(root);
//		 return head;
	}

	public static void flattenToDoublyLLutil(TreeNode root) {
		if (root == null) {
			return;
		}

		flattenToDoublyLLutil(root.left);
		if (prev == null) {
			head = root;

		} else {
			root.left = prev;
			prev.right = root;

		}
		prev = root;
		flattenToDoublyLLutil(root.right);
	}

	public static void flattenToCircularLL(TreeNode root) {
		head = null;
		prev = null;
		flattenToCircularLLutil(root);
		head.left = prev;
		prev.right = head;
//		 return head;
	}

	public static void flattenToCircularLLutil(TreeNode root) {
		if (root == null) {
			return;
		}

		flattenToDoublyLLutil(root.left);
		if (prev == null) {
			head = root;

		} else {
			root.left = prev;
			prev.right = root;

		}
		prev = root;
		flattenToDoublyLLutil(root.right);
	}

	/**
	 * Given Inorder Traversal of a Special Binary Tree in which key of every node
	 * is greater than keys in left and right children, construct the Binary Tree
	 * and return root.
	 * 
	 **/
	public static void solve(int inorderTraversal[]) {
		TreeNode head = inorderTraversalToTree(inorderTraversal, 0, inorderTraversal.length - 1);
		TreeDSAmethods.LVLOrderLineByline(head);
	}

	public static TreeNode inorderTraversalToTree(int inorderTraversal[], int start, int end) {
		if (start > end)
			return null;
		int maxElemntIdxBtwStartAndEnd = findMaxIndex(inorderTraversal, start, end);
		TreeNode root = new TreeNode(inorderTraversal[maxElemntIdxBtwStartAndEnd]);

		root.left = inorderTraversalToTree(inorderTraversal, start, maxElemntIdxBtwStartAndEnd - 1);
		root.right = inorderTraversalToTree(inorderTraversal, maxElemntIdxBtwStartAndEnd + 1, end);

		return root;

	}

	public static int findMaxIndex(int arr[], int s, int e) {
		int maxElement = arr[s];
		int idx = s;
		for (int i = s; i <= e; i++) {
			int temp = maxElement;
			maxElement = Math.max(maxElement, arr[i]);
			idx = temp == maxElement ? idx : i;
		}
		return idx;
	}

	static void inDFS(TreeNode root) {
		if (root == null)
			return;

		inDFS(root.left);
		// node logic
		System.out.print(root.data + " ");
		inDFS(root.right);
	}

	// algorithm : we are taking data of preorder and taking the construction of
	// inorder
	static void makeTreeFromPreTraversals(int in[], int pre[]) {
		TreeNode head= makeTreeFromPreTraversalsUtil(in, pre, 0, in.length - 1);
		inDFS(head);
	}

	static int preIndex = 0;

	static TreeNode makeTreeFromPreTraversalsUtil(int in[], int pre[], int iStart, int iEnd) {
		if (iStart > iEnd) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preIndex]);
		preIndex++;
		if (iStart == iEnd) 
            return root; 
		int inIndex = search(iStart, iEnd, root.data, in);
		root.left = makeTreeFromPreTraversalsUtil(in, pre, iStart, inIndex - 1);
		root.right = makeTreeFromPreTraversalsUtil(in, pre, inIndex + 1, iEnd);
		return root;
	}
	
	/**********************************************************************************************************/
	
	//same concept. idx is at last. decrement while selection
	static void makeTreeFromPostTraversals(int in[], int post[]) {
		postIndex=post.length-1;
		TreeNode head= makeTreeFromPostTraversalsUtil(in, post, 0, in.length - 1);
		inDFS(head);
	}

	static int postIndex = 0;

	static TreeNode makeTreeFromPostTraversalsUtil(int in[], int pre[], int iStart, int iEnd) {
		if (iStart > iEnd) {
			return null;
		}
		TreeNode root = new TreeNode(pre[postIndex]);
		postIndex--;
		if (iStart == iEnd) 
            return root; 
		int inIndex = search(iStart, iEnd, root.data, in);
		root.right = makeTreeFromPostTraversalsUtil(in, pre, inIndex + 1, iEnd);
		root.left = makeTreeFromPostTraversalsUtil(in, pre, iStart, inIndex - 1);
		
		return root;
	}
	private static int search(int s, int e, int key, int arr[]) {
		// TODO Auto-generated method stub

		for (int i = s; i <= e; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int arr1[] = { 2, 3, 7 };
		int arr2[] = { 1, 5, 5, 2, 2, -1, 3 };
//		LinkedListNode l1 = generateLinkedList(arr1);
//		LinkedListNode l2 = generateLinkedList(arr2);
//		TreeNode root = Data.TreeData.getATree();
//		flattenToDoublyLL(root);
//		System.out.println(head);
//		TreeDSAmethods.LVLOrderLineByline(result);
//		int inorder[] = { 5, 10, 40, 30, 28 };
//		solve(inorder);

		int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
		int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
		
	      int in2[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 }; 
	        int post2[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 }; 

	        makeTreeFromPostTraversals(in2, post2);
	}
}
