package CrackingTheCodingInterView.TreeAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Data.TreeData;
import LinkedList.LinkedListNode;
import Trees.TreeNode;

public class ListOfDepths {
	private static LinkedListNode createLL(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		LinkedListNode d = new LinkedListNode(-10000);
		LinkedListNode res = d;
		for (int v : list) {
			d.next = new LinkedListNode(v);
			d = d.next;
		}
		return res.next;
	}

	public static void solve(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<LinkedListNode> ans = new ArrayList<LinkedListNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int s = q.size();
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < s; i++) {
				TreeNode r = q.remove();
				l.add(r.data);
				if (r.left != null) {
					q.add(r.left);
				}

				if (r.right != null) {
					q.add(r.right);
				}
			}
			System.out.println(l);
			ans.add(createLL(l));

		}
		System.out.println(ans);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node=TreeData.getATree();
		solve(node);
	}

}
