package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import Trees.TreeNode;

public class BSTIterator {

	PriorityQueue<TreeNode> pq = null;
//	public BSTIterator() {
//		
//	}
	
	public BSTIterator(TreeNode root) {
		Comparator<TreeNode> rule = (a, b) -> {
			return a.data - b.data;
		};
		this.pq = new PriorityQueue<TreeNode>(rule);
		dfs(root);
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		this.pq.add(root);
		dfs(root.left);
		dfs(root.right);
	}
	/** @return the next smallest number */
	public int next() {
		TreeNode n = this.pq.remove();
		return n.data;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (this.pq.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		TreeNode root = Data.TreeData.getATree();
		System.out.println(root);
		BSTIterator bst = new BSTIterator(root);
		System.out.println(bst.next());
		System.out.println(bst.hasNext());

	}

}
