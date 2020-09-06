package LeetCode;

import java.util.*;
import java.util.List;

public class LeetCode802 {
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int n=graph.length;
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < graph.length; i++) {
			g.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < graph.length; i++) {
			for (int x : graph[i]) {
				g.get(i).add(x);
			}
		}
		boolean visited[]=new boolean[n];
        boolean inStack[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
            	solve(g, i, visited,inStack);
                }
            
        }
        System.out.println(Arrays.toString(visited));
        System.out.println(Arrays.toString(inStack));
        return new ArrayList<>();
	}
	  public static boolean solve(ArrayList<ArrayList<Integer>> graph, int src,  boolean visited[],boolean inStack[]) {

	        visited[src] = true;
	        inStack[src]=true;
	        for (int child : graph.get(src)) {
	            if (!visited[child]) {
	                if (solve(graph, child, visited,inStack)) {
	                    return true;
	                }
	            } else if (inStack[child]) {
	                return true;
	            }
	        }
	        inStack[src]=false;
	        return false;
	    }
	static boolean presentNodeIsPartOfCycle=false;
}
