package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

import LeetCode.LeetCode108.TreeNode;

public class LeetCode508 {
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

	static int maxFrequency = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		maxFrequency = 0;
		ArrayList<Integer> l = new ArrayList<Integer>();

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		dfs(root, map);
		for (int x : map.keySet()) {
			if (map.get(x) == maxFrequency) {
				l.add(x);
			}
		}

		return l.stream().mapToInt(i -> i).toArray();
	}

	public int dfs(TreeNode root, HashMap<Integer, Integer> map) {
		if (root == null)
			return 0;
		int l = dfs(root.left, map);
		int r = dfs(root.right, map);
		int nodeGetSum = l + r + root.val;
		map.put(nodeGetSum, map.getOrDefault(nodeGetSum, 0) + 1);
		maxFrequency = Math.max(maxFrequency, map.get(nodeGetSum));
		return nodeGetSum;

	}
}
