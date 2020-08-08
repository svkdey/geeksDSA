package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode501 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	void inDFS(TreeNode root, HashMap<Integer, Integer> map) {
		if (root == null)
			return;

		inDFS(root.left, map);
		// node logic
		map.put(root.val, map.getOrDefault(root.val, 0) + 1);
		maxF=Math.max(maxF, map.get(root.val));
		inDFS(root.right, map);
	}
	static int maxF=-1;
	public int[] findMode(TreeNode root) {
		if (root == null)
			return new int[0];
		maxF=-1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		inDFS(root, map);
		ArrayList<Integer> l=new ArrayList<Integer>();
		
		for(Map.Entry<Integer, Integer> x:map.entrySet()) {
			if(x.getValue()==maxF) {
				l.add(x.getKey());
			}
		}
		int ans[]=new int[l.size()];
		for(int i=0;i<l.size();i++) {
			ans[i]=l.get(i);
		}

		return ans;
	}
}
