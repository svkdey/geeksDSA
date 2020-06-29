package Playground.Trees;

import Trees.TreeNode;

public class TreePractiseSeasonWithDoubleNode {
	// idea get height of left subtree right subtree.
	// get present diameter = (lH+rH+1)
	// call getDiameter(root.left),getDiameter(root.right) ..and if
	// root==null return 0;
	static int getDiameter(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = TreePracticeSession.heightOfTree(root.left);
		int rightHeight = TreePracticeSession.heightOfTree(root.right);

		int diameterAtPresetNode = 1 + leftHeight + rightHeight;

		return Math.max(diameterAtPresetNode, Math.max(getDiameter(root.left), getDiameter(root.right))) - 1;

	}

	// o(n) solution
	int ans = 1;

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.left);
		ans = Math.max(leftHeight + rightHeight + 1, ans);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public int diameterOfBinaryTree(TreeNode root) {
		height(root);
		return ans - 1;
	}

	// idea get height of left subtree and right subtree.
	// find abs(lH-rH)
	// call isHeightBalance(root.left),isHeightBalance(root.right) ..and if
	// root==null true;
	static boolean isHeightBalanced(TreeNode root) {
		if (root == null)
			return true;
		int leftHeight = TreePracticeSession.heightOfTree(root.left);
		int rightHeight = TreePracticeSession.heightOfTree(root.right);

		return ((Math.abs(leftHeight - rightHeight) <= 1) && isHeightBalanced(root.left)
				&& isHeightBalanced(root.right));

	}

	// very important
	static boolean isIdentical(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 == null)
			return false;
		if (root1 == null && root2 != null)
			return false;
		return (root1.data == root2.data && isIdentical(root1.left, root2.left)
				&& isIdentical(root1.right, root2.right));
	}

	static boolean isFoldable(TreeNode root) {
		TreeNode leftTree = rotateTree(root.right);
		return isSymmetricStructure(root.left, leftTree);
	}

	static boolean isSymmetricStructure(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 == null)
			return false;
		if (root1 == null && root2 != null)
			return false;
		return (isSymmetricStructure(root1.left, root2.left) && isSymmetricStructure(root1.right, root2.right));
	}

	// idea is : if a tree is symmetric if tree and mirror tree is identical
	static boolean isSymetric(TreeNode root) {

		return isSymetricUtil(root, root);
	}

	static boolean isSymetricUtil(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 == null)
			return false;
		if (root1 == null && root2 != null)
			return false;
		return (root1.data == root2.data) && (isSymetricUtil(root1.left, root2.right))
				&& (isSymetricUtil(root1.right, root2.left));
	}

	// is inverted is same is mirror tree
	// a tree is mirror tree if it's mirror is identical
	static boolean isMirror(TreeNode root1, TreeNode root2) {
//		TreePracticeSession.LevelordertraversalLinebyLine(root1);

		TreeNode invertedTreeNode = rotateTree(root2);

		return isIdentical(root1, invertedTreeNode);
	}

	// idea get leftData and rightData is valid or not
	// find leftValue&&rightValue
	// call isBST(root.left)&&isBST(root.right) ..and if
	// root==null true;
	public boolean isValidBST(TreeNode root) {

		return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBSTHelper(TreeNode root, long min, long max) {
		if (root == null)
			return true;

		return ((long) root.data > min && (long) root.data < max) && isValidBSTHelper(root.left, min, (long) root.data)
				&& isValidBSTHelper(root.right, (long) root.data, max);

	}

	static boolean isSubTree(TreeNode root1, TreeNode root2) {
		if (root1 == null)
			return false;
		boolean value = isIdentical(root1, root2);
		System.out.println(value);
		if (value) {
			return true;
		}
		return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);

	}

	// very important
	static TreeNode rotateTree(TreeNode root) {
		if (root == null)
			return root;
		// go down to left and start reversing
		TreeNode l = rotateTree(root.left);
		TreeNode r = rotateTree(root.right);

		TreeNode temp = l;
		root.left = r;
		root.right = temp;
		return root;
	}

	static boolean perfectTree(TreeNode root) {
		int lvl = TreePracticeSession.heightOfTree(root);
		return perfectTreeHelper(root, lvl, 0);
	}

	static boolean perfectTreeHelper(TreeNode root, int lvl, int h) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null) {
			return lvl == h + 1;
		}
		if (root.left != null && root.right == null)
			return false;
		if (root.left == null && root.right != null)
			return false;

		return perfectTreeHelper(root.left, lvl, h + 1) && perfectTreeHelper(root.right, lvl, h + 1);
	}

	/***
	 * 
	 * problems on subTree has general pattern
	 * 
	 * dfsHelperfuntion(root){ anotherFuctionTodosometh(root); some condition..
	 * dfsHelperfuntion(root.left); dfsHelperfuntion(root.right);
	 * 
	 * }
	 ***/

	/***
	 * problems on mirror/symmetric/foldable has general pattern
	 * 
	 * 1.rotate(root1); return isIdential(root1,root2)
	 *
	 ***/

	/**
	 * problems on isHeight/isBinary has general pattern
	 * 
	 * function(){ //base case //some condition return (rootCondition is
	 * true/false)&& function(leftSubTree) &&function(rightSubTree)) }
	 * 
	 */
	static int count = 0;

	static void countSubtreesWithSumX(TreeNode root, int target) {

		countSubtreesWithSumXHelper(root, target);
		System.out.println(count);
	}

	static void countSubtreesWithSumXHelper(TreeNode root, int target) {
		if (root == null)
			return;
		if (sumOfAllNodes(root) == target) {
			count++;
		}
		countSubtreesWithSumXHelper(root.left, target);
		countSubtreesWithSumXHelper(root.right, target);
	}

	static void childSumProperty(TreeNode root) {
		System.out.println(childSumPropertyUtil(root));
	}

	static boolean childSumPropertyUtil(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.right == null && root.left == null) {
			return true;
		}
		int lf = sumOfAllNodes(root.left);
		int rt = sumOfAllNodes(root.right);
		System.out.println(root.data + "--->" + lf + "    " + rt);
		return (root.data == (lf + rt) && childSumPropertyUtil(root.left) && childSumPropertyUtil(root.right));
	}

	static int sumOfAllNodes(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
	}

	public static void main(String[] args) {
		TreeNode root1 = Data.TreeData.getATree();
		TreeNode root2 = Data.TreeData.getATree2();
		TreeNode root3 = Data.TreeData.getBinarySearchPropertyTree();
		TreeNode root4 = Data.TreeData.getSubtree();
		System.out.println();
		TreePracticeSession.LevelordertraversalLinebyLine(root2);

		TreePracticeSession.LevelordertraversalLinebyLine(root4);
//		rotateTree(root2);
		// so
		System.out.println(isSubTree(root2, root4));
		System.out.println();
		System.out.println();

	}
}
