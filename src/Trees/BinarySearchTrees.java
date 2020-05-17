package Trees;

import java.util.Stack;

import Data.TreeData;

public class BinarySearchTrees {
	public static void insertIntoBinaryTree(TreeNode root, int value) {
		TreeNode node = root;
		TreeNode current = null;
		boolean nodeExists = false;
		while (node != null) {
			if (node.data == value) {
				nodeExists = true;
				break;
			} else if (node.data > value) {
				current = node;
				node = node.left;
			} else {
				current = node;
				node = node.right;
			}
		}
		if (!nodeExists && current == null) {
			return;
		}
		if (current.data > value) {
			current.left = new TreeNode(value);
		} else {
			current.right = new TreeNode(value);
		}
		System.out.println(root);
	}

	public static TreeNode insertIntoBinaryTreeRecusive(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
		}
		if (root.data == value) {
			return root;
		} else if (root.data > value) {
			root.left = insertIntoBinaryTreeRecusive(root.left, value);
		} else {
			root.right = insertIntoBinaryTreeRecusive(root.right, value);
		}

		return root;
	}

//	o(h) o(h)
	public static TreeNode deleteIntoBinaryTree(TreeNode root, int value) {
		if (root == null)
			return null;

		// find the node;
		
		//this connection are important btw nodes as it recusively connection
		if (root.data > value) {
			root.left = deleteIntoBinaryTree(root.left, value);
		} else if (root.data < value) {
			root.right = deleteIntoBinaryTree(root.right, value);
		}
		// node found
		else {
			// if node is leaf
			if (root.left == null && root.right == null)
				return null;
			// not leaf
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			// internal node
			else {
				TreeNode successor = findSuccessor(root);
				// replace data
				root.data = successor.data;

				// delete successor
				deleteIntoBinaryTree(root.right, successor.data);
			}
		}
		return root;
	}

	// not proper successor function
	static TreeNode findSuccessor(TreeNode root) {
		TreeNode cur = root;
		cur = cur.right;
		while (cur != null && cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}
	static void printCommon(TreeNode root1, TreeNode root2)  
    {
        Stack<TreeNode> stack1 = new Stack<TreeNode> (); 
        Stack<TreeNode> s1 = new Stack<TreeNode> ();  
        Stack<TreeNode> s2 = new Stack<TreeNode> (); 

        while (true)
        {  
            // push the Nodes of first tree in stack s1  
            if (root1 != null)  
            {  
                s1.push(root1);  
                root1 = root1.left;  
            }  
      
            // push the Nodes of second tree in stack s2  
            else if (root2 != null)  
            {  
                s2.push(root2);  
                root2 = root2.left;  
            }  
      
            // Both root1 and root2 are NULL here  
            else if (!s1.isEmpty() && !s2.isEmpty())  
            {  
                root1 = s1.peek();  
                root2 = s2.peek();  
      
                // If current keys in two trees are same  
                if (root1.data == root2.data)  
                {  
                    System.out.print(root1.data + " ");  
                    s1.pop();  
                    s2.pop();  
      
                    // move to the inorder successor  
                    root1 = root1.right;  
                    root2 = root2.right;  
                }  
      
                else if (root1.data < root2.data)  
                {  
                    // If Node of first tree is smaller, than that of  
                    // second tree, then its obvious that the inorder  
                    // successors of current Node can have same value  
                    // as that of the second tree Node. Thus, we pop  
                    // from s1
                    s1.pop();  
                    root1 = root1.right;  
      
                    // root2 is set to NULL, because we need  
                    // new Nodes of tree 1  
                    root2 = null;  
                }  
                else if (root1.data > root2.data)  
                {  
                    s2.pop();  
                    root2 = root2.right;  
                    root1 = null;  
                }  
            }  
      
            // Both roots and both stacks are empty  
            else break;  
        }  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TreeData.getBinarySearchPropertyTree());
//		TreeDSAmethods.LVLOrderLineBylineSolutionTwo(TreeData.getBinarySearchPropertyTree());
//		System.out.println(insertIntoBinaryTreeRecusive(TreeData.getBinarySearchPropertyTree(), 3));
//		BSTproblems.findKthSmallestNode(TreeData.getBinarySearchPropertyTree(),3);
//		int arr[]= {2,8,30,15,25,12};
//		BTSproblems.ceilingOnLeftSide(arr, arr.length);
//		System.out.println("Solution "+BSTproblems.fixTheBSTwithSwappedNode(TreeData.getBinarySearchPropertyTree()));
//		BSTproblems.getSumPairTwo(TreeData.getBinarySearchPropertyTree(), 30);
		BSTproblems.getVerticalSumRecusive(TreeData.getBinarySearchPropertyTree());
	}

}
