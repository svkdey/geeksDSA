package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;;

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

	public static int resOfDiameterProblem = 0;

	public static int diameterOfTreeSolution(TreeNode root) {
		if (root == null)
			return 0;

		int lH = TreeDSAmethods.heightOfBinaryTree(root.left);
		int rH = TreeDSAmethods.heightOfBinaryTree(root.right);
		int dRoot = 1 + lH + rH;

		resOfDiameterProblem = Math.max(resOfDiameterProblem, 1 + lH + rH);
		return 1 + Math.max(lH, rH);
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
//		TreeNode path2[] = new TreeNode[100];
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
	class Pair{
		TreeNode node;
		int horizontalLevel;
		public Pair(TreeNode node, int horizontalLevel) {
			this.node = node;
			this.horizontalLevel = horizontalLevel;
		}
		
	}

	public static TreeMap<Integer, ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
		if(root==null) return null;
		
		TreeMap<Integer, ArrayList<Integer>> hm=new TreeMap<Integer, ArrayList<Integer>>();
		int hLevel=0;
		Queue<Trees.Pair> queue=new LinkedList<Trees.Pair>();
		queue.add(new Trees.Pair(root, hLevel));
		
		while(!queue.isEmpty()) {
			Trees.Pair nodepair=queue.remove();
			hLevel=nodepair.horizontalLevel;
			TreeNode node=nodepair.node;
			
			
			if(hm.containsKey(hLevel)) {
				ArrayList<Integer> listOfNodeInhLevel=hm.get(hLevel);
				listOfNodeInhLevel.add(node.data);
				hm.put(hLevel, listOfNodeInhLevel);
			}else {
				ArrayList<Integer> listOfNodeInhLevel=new ArrayList<Integer>();
				listOfNodeInhLevel.add(node.data);
				hm.put(hLevel, listOfNodeInhLevel);
			}
			
			if(node.left!=null) {
				queue.add(new Trees.Pair(node.left, hLevel-1));
			}
			if(node.right!=null) {
				queue.add(new Trees.Pair(node.right, hLevel+1));
			}
		}
		return hm;
		
	}
	public static void topViewOfBinaryTree(TreeNode root){
		if(root ==null) return ;
		TreeMap<Integer, ArrayList<Integer>> hm=verticalOrderTraversal(root);
		for(Entry<Integer, ArrayList<Integer>> s:hm.entrySet()) {
			System.out.print(s.getValue().get(0)+" ");
		}
	}
	public static void bottomViewOfBinaryTree(TreeNode root){
		if(root ==null) return ;
		TreeMap<Integer, ArrayList<Integer>> hm=verticalOrderTraversal(root);
		for(Entry<Integer, ArrayList<Integer>> s:hm.entrySet()) {
			System.out.print(s.getValue().get(s.getValue().size()-1)+" ");
		}
	}
}
