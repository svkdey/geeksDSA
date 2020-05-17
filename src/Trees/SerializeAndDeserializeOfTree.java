package Trees;

import java.util.ArrayList;

import Data.TreeData;
//note marking null as -1 is important
public class SerializeAndDeserializeOfTree {
	static void serialize(TreeNode root, ArrayList<Integer> arr) {
		if (root == null) {
			arr.add(-1);
			return;
		}

		arr.add(root.data);
		serialize(root.left, arr);
		serialize(root.right, arr);
	}

	static int indexForDeserialize = 0;

	static TreeNode deserialize(ArrayList<Integer> arr) {
		if (indexForDeserialize == arr.size())
			return null;
		int val = arr.get(indexForDeserialize);
		indexForDeserialize++;

		if (val == -1) {
			return null;
		}

		TreeNode root = new TreeNode(val);
		root.left = deserialize(arr);
		root.right = deserialize(arr);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree();
		ArrayList<Integer> res = new ArrayList<Integer>();
		SerializeAndDeserializeOfTree.serialize(TreeData.getATree(), res);
		System.out.println(TreeData.getATree());
		System.out.println(SerializeAndDeserializeOfTree.deserialize(res));

	}

}
