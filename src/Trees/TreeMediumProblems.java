package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import Trees.Pair;

public class TreeMediumProblems {
	public static boolean childSumProperty(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			int left = node.left != null ? node.left.data : 0;
			int right = node.right != null ? node.right.data : 0;
			if (left == 0 && right == 0) {

			} else {
				if (node.data != left + right) {
					return false;
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
		return true;
	}

	// tough thinking
	public static boolean childSumPropertyRecusive(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null || root.right == null) {
			return true;
		}

		int left = root.left != null ? root.left.data : 0;
		int right = root.right != null ? root.right.data : 0;
		return (root.data == (left + right) && childSumProperty(root.left) && childSumProperty(root.right));
	}

//o (n*n-1) solution
	public static boolean ifHeightBalancedTree(TreeNode root) {
		if (root == null)
			return true;
		int leftHeight = TreeDSAmethods.heightOfBinaryTree(root.left);
		int rightHeight = TreeDSAmethods.heightOfBinaryTree(root.right);

		return (Math.abs(leftHeight - rightHeight) <= 1 && ifHeightBalancedTree(root.left)
				&& ifHeightBalancedTree(root.right));
	}

	// o(n) by tricking result of left and right hand tree
	public static int ifHeightBalancedTreeSolTwo(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = ifHeightBalancedTreeSolTwo(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = ifHeightBalancedTreeSolTwo(root.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		else
			return (Math.max(leftHeight, rightHeight)) + 1;
	}

	public static void spriralOrderTraversal(TreeNode root) {

		Deque<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null) {
			return;
		} else {
			q.add(root);
			int i = 1;
			while (!q.isEmpty()) {
				int size = q.size();
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
			}
		}

	}

	public static int maxWidthOfTree(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			count = Math.max(count, size);

			for (int i = 0; i < size; i++) {
				TreeNode node = q.remove();

				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}

		}
		return count;
	}

	// get diameter of root by 1+lh+rh
	// get diameter left and right tree
	// get max of (root,left,right ) diameter

	// observe we compute up then going down to left tree and right tree
	public static int diameterOfTree(TreeNode root) {
		if (root == null)
			return 0;

		int lH = TreeDSAmethods.heightOfBinaryTree(root.left);
		int rH = TreeDSAmethods.heightOfBinaryTree(root.right);
		int dRoot = 1 + lH + rH;
		int dLeft = diameterOfTree(root.left);
		int dRight = diameterOfTree(root.right);
		return Math.max(dRoot, Math.max(dLeft, dRight));
	}

	// efficient solution

	/* Complete the function to get diameter of a binary tree */
	int dia = 0;

	public int util(TreeNode root) {
		if (root == null)
			return 0;

		int l = util(root.left); // height of left subtree
		int r = util(root.right); // height of right subtree

		if (l + r + 1 > dia)
			dia = l + r + 1; // l+r+1 is a possible max dia

		return 1 + Math.max(l, r); // returning height of subtree
	}

	public int maXdiameter(TreeNode root) {
		util(root);
		return dia;
	}

//most important code of tree
	static boolean findPath(TreeNode node, int i, ArrayList<TreeNode> arr) {
		if (node == null) {
			return false;
		}
		arr.add(node);
		if (node.data == i)
			return true;
		if (findPath(node.left, i, arr) || findPath(node.right, i, arr)) {
			return true;
		}
		arr.remove(arr.size() - 1);
		return false;
	}

	public static TreeNode lowestCommonAnsistors(TreeNode root, int n1, int n2) {
		if (root == null)
			return null;
		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();

		if (findPath(root, n1, path1) == false || findPath(root, n2, path2) == false) {
			return null;
		}

		for (int i = 0; i < path1.size() && i < path2.size(); i++) {
			if (path1.get(i + 1) != path2.get(i + 1)) {
				return path1.get(i);
			}
		}
		return null;

	}

	static boolean isIdentical(TreeNode root1, TreeNode root2) {
		// Code Here
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 == null)
			return false;
		if (root1 == null && root2 != null)
			return false;

		return (root1.data == root2.data) && isIdentical(root1.left, root2.left)
				&& isIdentical(root1.right, root2.right);

	}

	class Pair {
		TreeNode node;
		int horizontalLevel;

		public Pair(TreeNode node, int horizontalLevel) {
			this.node = node;
			this.horizontalLevel = horizontalLevel;
		}

	}

	public static TreeMap<Integer, ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
		if (root == null)
			return null;

		TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<Integer, ArrayList<Integer>>();
		int hLevel = 0;
		Queue<Trees.Pair> queue = new LinkedList<Trees.Pair>();
		queue.add(new Trees.Pair(root, hLevel));

		while (!queue.isEmpty()) {
			Trees.Pair nodepair = queue.remove();
			hLevel = nodepair.horizontalLevel;
			TreeNode node = nodepair.node;

			if (hm.containsKey(hLevel)) {
				ArrayList<Integer> listOfNodeInhLevel = hm.get(hLevel);
				listOfNodeInhLevel.add(node.data);
				hm.put(hLevel, listOfNodeInhLevel);
			} else {
				ArrayList<Integer> listOfNodeInhLevel = new ArrayList<Integer>();
				listOfNodeInhLevel.add(node.data);
				hm.put(hLevel, listOfNodeInhLevel);
			}

			if (node.left != null) {
				queue.add(new Trees.Pair(node.left, nodepair.horizontalLevel - 1));
			}
			if (node.right != null) {
				queue.add(new Trees.Pair(node.right, nodepair.horizontalLevel + 1));
			}
		}
		return hm;

	}

	public static void topViewOfBinaryTree(TreeNode root) {
		if (root == null)
			return;
		TreeMap<Integer, ArrayList<Integer>> hm = verticalOrderTraversal(root);
		for (Entry<Integer, ArrayList<Integer>> s : hm.entrySet()) {
			System.out.print(s.getValue().get(0) + " ");
		}
	}

	public static void bottomViewOfBinaryTree(TreeNode root) {
		if (root == null)
			return;
		TreeMap<Integer, ArrayList<Integer>> hm = verticalOrderTraversal(root);
		for (Entry<Integer, ArrayList<Integer>> s : hm.entrySet()) {
			int sizeOfArray = s.getValue().size();
			System.out.print(s.getValue().get(sizeOfArray - 1) + " ");
		}
	}

	void mirror(TreeNode node) {
		// Your code here
		if (node == null)
			return;
		mirror(node.left);
		mirror(node.right);

		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	// find both the tree are identical
	boolean indeticalTree(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 != null && node2 != null) {
			return node1.data == node2.data && indeticalTree(node1.left, node2.left)
					&& indeticalTree(node1.right, node2.right);
		}
		return false;
	}

//if tree is symmtric if two root1.data==root2.data and their leftTree == rightTree and rightTree==leftTree
	boolean isSymetricTree(TreeNode root) {
		return isSymetricTreeHelper(root, root);
	}

	boolean isSymetricTreeHelper(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 != null && root2 != null) {
			return root1.data == root2.data && isSymetricTreeHelper(root1.left, root2.right)
					&& isSymetricTreeHelper(root1.right, root2.left);
		}
		return false;
	}

	public static int verticalWidth(TreeNode root) {
		// Add your code here.
		if (root == null)
			return 0;
		HashSet<Integer> hs = new HashSet<>();

		Queue<Trees.Pair> q = new LinkedList<>();
		q.add(new Trees.Pair(root, 0));
		while (!q.isEmpty()) {
			Trees.Pair p = q.remove();
			TreeNode n = p.node;
			int l = p.horizontalLevel;
			// System.out.print(l);
			hs.add(l);
			if (n.left != null) {
				q.add(new Trees.Pair(n.left, p.horizontalLevel - 1));
			}
			if (n.right != null) {
				q.add(new Trees.Pair(n.right, p.horizontalLevel + 1));
			}

		}
		// System.out.print(hs);
		return hs.size();

	}

	

	public static boolean isSubtree(TreeNode T, TreeNode S) {
		// add code here.

		if (S == null)  
            return true; 
   
        if (T == null) 
            return false; 
   
        /* Check the tree with root as current node */
        if (isSubtreeHelper(T, S))  
            return true; 
   
        /* If the tree with root as current node doesn't match then 
           try left and right subtrees one by one */
        return isSubtree(T.left, S) 
                || isSubtree(T.right, S);
	}



	public static boolean isSubtreeHelper(TreeNode T, TreeNode S) {
		// add code here.
		if (T == null && S == null) {
			return true;
		}
		if (T != null && S != null) {
			return T.data == S.data && isSubtreeHelper(T.left, S.left) && isSubtreeHelper(T.right, S.right);
		}
		return false;

	}
	public static void main(String[] args) {
		System.out.println(childSumProperty(Data.TreeData.getChildSumPropertyTree()));
	}
}
