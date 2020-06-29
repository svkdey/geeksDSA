package Data;

import Trees.TreeNode;

public class TreeData {
	public static TreeNode getATree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.left.right=new TreeNode(100);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(100);
//		root.right.right = new TreeNode(50);
		return root;
	}
	public static TreeNode getATree2() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.left.right=new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(9);
		return root;
	}
	public static TreeNode getSubtree(){
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(70);
		root.right=new TreeNode(500);
		return root;
	}
	public static TreeNode getChildSumPropertyTree() {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.left.left = new TreeNode(6);
//		root.left.right = new TreeNode(7);
		return root;
	}
	public static TreeNode getBinarySearchPropertyTree() {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.right.left = new TreeNode(21);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		return root;
	}

}
