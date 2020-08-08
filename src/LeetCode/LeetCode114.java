package LeetCode;

import java.util.ArrayList;

import Trees.TreeNode;

public class LeetCode114 {
	static void inDFS(TreeNode root,ArrayList<Integer> al) {
		if (root == null)
			return;
		al.add(root.data);
		inDFS(root.left,al);
		
	
		inDFS(root.right,al);
	}
	static TreeNode root;	
	public static void solve(TreeNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		inDFS(head,list);
		 head=new TreeNode(list.get(0));
		TreeNode temp=head;
		for(int i=1;i<list.size();i++) {
			head.right=new TreeNode(list.get(i));
			head.left=null;
			head=head.right;
		
		}
		
		System.out.println(temp);
	}
	public static void main(String[] args) {
		TreeNode root=Data.TreeData.getATree();
		System.out.println(root);
		solve(root);
		System.out.println(root);
	}
}
