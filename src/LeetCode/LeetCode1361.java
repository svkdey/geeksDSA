package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class LeetCode1361 {
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> indegree=new HashMap<Integer, Integer>();
		indegree.put(0,0);
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < leftChild.length; i++) {
			if (leftChild[i] != -1) {
				graph.get(i).add(leftChild[i]);
				indegree.put(i, indegree.getOrDefault(i,0)+1);
			}
		}
		for (int i = 0; i < rightChild.length; i++) {
			if (rightChild[i] != -1) {
				graph.get(i).add(rightChild[i]);
				indegree.put(i, indegree.getOrDefault(i,0)+1);
			}
		}
		System.out.println(graph);
		System.out.println(indegree);
		for(int i=0;i<n;i++) {
			if(i==0) {
				if(indegree.get(0)!=0||graph.get(0).size()>2) return false;
			}else {
				
				if(indegree.get(i)!=1||graph.get(i).size()>2) {
					return false;
				}
			}
		}
		return true;
		
	}

	public boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], int src, int parent, Queue<Integer> s) {

		visited[src] = true;
		
		for (int child : graph.get(src)) {
			if (!visited[child]) {
				if(dfs(graph, visited, child, src, s)) {
					return true;
				}
			}
			else if (parent != child) {
				return true;
			}
		}
		
		return false;

	}
}
