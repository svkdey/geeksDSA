package Playground.Trees;

import java.util.ArrayList;

import Trees.TreeNode;

public class SerializeAndDeserializeTree {
	private static void serialize(TreeNode root,ArrayList<Integer> l) {
		if(root==null) {
			l.add(-1);
			return;
		}
		l.add(root.data);
		serialize(root.left,l);
		serialize(root.right,l);

	}
	static int idx=-1;
	private static TreeNode deserialize(ArrayList<Integer> l) {
		// TODO Auto-generated method stub
		if(idx>=l.size()) {
			return null;
		}
		idx++;
		if(l.get(idx)==-1) {
			return null;
		}

		TreeNode root=new TreeNode(l.get(idx));
		root.left=deserialize(l);
		root.right=deserialize(l);
		return root;
		
	}
	static void inDFS(TreeNode root) {
		if (root == null)
			return;

		inDFS(root.left);
		// node logic
		System.out.print(root.data + " ");
		inDFS(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeNode root=Data.TreeData.getATree2();
		inDFS(root);
		System.out.println();
		serialize(root, list);
		System.out.println(list);
		TreeNode res=deserialize(list);
		inDFS(res);
		
		
	}

}
