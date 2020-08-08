package LeetCode;

import java.util.*;

public class LeetCode863 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private void dfs(TreeNode root,ArrayList<ArrayList<Integer>> graph) {
		if(root==null) return;
		if(root.left!=null) {
			graph.get(root.val).add(root.left.val);
			graph.get(root.left.val).add(root.val);
		}
		if(root.right!=null) {
			graph.get(root.val).add(root.right.val);
			graph.get(root.right.val).add(root.val);
		}
		dfs(root.left, graph);
		dfs(root.right, graph);
	}
	private void BFS(ArrayList<ArrayList<Integer>> graph,int src,int K,List<Integer> ans) {
        if(K==0) {
            ans.add(src);
            return;
        }
		Queue<Integer> q = new LinkedList<Integer>();
        boolean v[]=new boolean[graph.size()];
		q.add(src);
        v[src]=true;
		int h=0;
        
		while(!q.isEmpty()) {
			int n=q.size();
	    //    System.out.println("at "+ h + q);
			
			for(int i=0;i<n;i++) {
				int vertex=q.remove();
				for(int child:graph.get(vertex)) {
                    if(!v[child]){
                        q.add(child);
                        v[child]=true;
                    }
				}
			}
            h++;
            if(h==K) {
				break;
			}
		}
    //    System.out.println(q);
		while(!q.isEmpty()) {
			    ans.add(q.remove());
		}
	}
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=500;i++) {
			graph.add(new ArrayList<Integer>());
		}
       
		dfs(root, graph);
         // System.out.print(graph);
		List<Integer> ans=new ArrayList<Integer>();
		BFS(graph,target.val,K,ans);
		return ans;
    }
}
