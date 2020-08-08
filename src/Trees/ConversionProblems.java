package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Data.TreeData;
import LinkedList.LinkedListNode;

public class ConversionProblems {
	public static TreeNode convert(LinkedListNode head, TreeNode node) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (head == null) {
			node = null;
			return null;
		}
		node = new TreeNode(head.data);
		q.add(node);
		head = head.next;
		while (head != null) {
			TreeNode parent = q.poll();

			TreeNode leftChild = null, rightChild = null;
			leftChild = new TreeNode(head.data);
			q.add(leftChild);
			head = head.next;
			if (head != null) {
				rightChild = new TreeNode(head.data);
				q.add(rightChild);
				head = head.next;
			}
			parent.left = leftChild;
			parent.right = rightChild;
		}
		return node;
	}

	/*
	 * //https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-
	 * parent-array/1/?track=PC-W6-T&batchId=154 Given an array of size N that
	 * represents a Tree in such a way that array indexes are values in tree nodes
	 * and array values give the parent node of that particular index (or node). The
	 * value of the root node index would always be -1 as there is no parent for
	 * root. Construct the standard linked representation of Binary Tree from this
	 * array representation.
	 * 
	 * Input: The first line of the input contains an integer 'T' denoting the
	 * number of test cases. Then 'T' test cases follow. Each test case consists of
	 * two lines. First line of each test case contains an integer N denoting the
	 * size of the tree array . Second line of each test case consists of 'N' space
	 * separated integers denoting the elements of the array .
	 * 
	 * Output: The Output will be the sorted level order traversal of the tree.
	 * 
	 * User Task: The task is complete the function
	 * 
	 * Constraints: 1 <= T <= 1000 1 <= N <= 103
	 */
	public static TreeNode createTree(int arr[], int n) {
		// Your code here
		HashMap<Integer, TreeNode> hm = new HashMap<Integer, TreeNode>();
		// hm.put(-1, new TreeNode(0));
		for (int i = 0; i < n; i++) {
			hm.put(i, new TreeNode(i));
		}
		int temp = 0;
		for (int i = 0; i < n; i++) {
			TreeNode node = hm.get(arr[i]);
			if (arr[i] == -1) {
				temp = i;
			} else if (node.left == null) {
				node.left = hm.get(i);
			} else {
				node.right = hm.get(i);
			}
		}

		return hm.get(temp);
	}

	/*
	 * take a prev pointer and make it null to keep remember last node visited go
	 * left nad find last left element/right ement make it head. it will head if
	 * prev==null. then make prev to root ie prev=root;
	 * 
	 * now if prev not null then make DDL ie prev.right=root;root.left=prev;
	 * 
	 * go right side same way recusively
	 * 
	 * 
	 */

	// doubly ll
	static TreeNode head;
	static TreeNode prev = null;

	static TreeNode bToDLL(TreeNode root) {
		// Your code here
		bToDLLUtil(root);
//		System.out.println(head.data+ " "+ prev.data);
		return head;
	}

	static void bToDLLUtil(TreeNode root) {
		// Your code here
		if (root == null) {
			return;
		}

		bToDLLUtil(root.left);

		if (prev == null) {
			head = root;
		}

		else {
			root.left = prev;
			prev.right = root;

		}
		prev = root;

		bToDLLUtil(root.right);

	}

	// circular ll
	TreeNode bTreeToClist(TreeNode root) {
		// your code here
		treeToDD(root);
		prevCC.right = head;
		headCC.left = prev;
		TreeNode op = head;
		head = null;
		prev = null;
		return op;

	}

	static TreeNode headCC = null;
	static TreeNode prevCC = null;

	void treeToDD(TreeNode root) {
		if (root == null)
			return;
		treeToDD(root.left);

		if (prevCC == null) {
			headCC = root;
		} else {
			root.left = prevCC;
			prevCC.right = root;
		}

		prevCC = root;
		treeToDD(root.right);
	}

	static TreeNode makeTreeFromTraversals(int in[], int pre[]) {
		return makeTreeFromTraversalsUtil(in, pre, 0, in.length - 1);
	}

	static int preIndex = 0;

	static TreeNode makeTreeFromTraversalsUtil(int in[], int pre[], int iStart, int iEnd) {
		if (iStart > iEnd) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preIndex]);
		preIndex++;
		if (iStart == iEnd)
			return root;
		int inIndex = 0;
		for (int i = iStart; i <= iEnd; i++) {
			if (in[i] == root.data) {
				inIndex = i;
				break;
			}
		}
		root.left = makeTreeFromTraversalsUtil(in, pre, iStart, inIndex - 1);
		root.right = makeTreeFromTraversalsUtil(in, pre, inIndex + 1, iEnd);
		return root;
	}

//only from in order
	static TreeNode makeTreeFromInOrderTraversalOnly(int in[]) {
		return makeTreeFromInOrderTraversalOnlyUtil(in, 0, in.length - 1);
	}

	static TreeNode makeTreeFromInOrderTraversalOnlyUtil(int in[], int start, int end) {
		if (start > end)
			return null;
		int maxIdx = max(in, start, end);

		TreeNode root = new TreeNode(in[maxIdx]);
		if (start == end)
			return root;

		root.left = makeTreeFromInOrderTraversalOnlyUtil(in, start, maxIdx - 1);
		root.right = makeTreeFromInOrderTraversalOnlyUtil(in, maxIdx + 1, end);

		return root;
	}

	static int max(int arr[], int start, int end) {
		int maxELement = arr[start];
		int maxInd = start;
		for (int i = start + 1; i < end; i++) {
			if (arr[i] > maxELement) {
				maxELement = arr[i];
				maxInd = i;
			}
		}
		return maxInd;
	}

//inoder+post order
	static void makeTreeFromPostTraversals(int in[], int post[]) {
		postIndex = post.length - 1;
		TreeNode head = makeTreeFromPostTraversalsUtil(in, post, 0, in.length - 1);
//		inDFS(head);
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

		for (int i = s; i <= e; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { -1, 0, 0, 1, 1, 3, 5 };
		System.out.println(TreeData.getATree());
		System.out.println(bToDLL(TreeData.getATree()));
	}

}
