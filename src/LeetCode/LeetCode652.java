package LeetCode;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class LeetCode652 {
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
	static HashSet<TreeNode> ans=null;

	public static String dfs(HashMap<String, Integer> map,TreeNode root,String s) {
		if(root==null) return null;
		s+=root.val+" "+dfs(map, root.left, s)+" "+dfs(map, root.right, s);
		if(map.containsKey(s)) {
			map.put(s, map.getOrDefault(s,0)+1);
		}
		if(map.get(s)==2) {
			ans.add(root);
		}
		return s;
	}
	
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			ans=new HashSet<TreeNode>();
			System.out.println(dfs(map,root,""));
			return new ArrayList<TreeNode>(ans);
	}
}
