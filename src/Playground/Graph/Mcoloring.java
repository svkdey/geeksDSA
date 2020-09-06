package Playground.Graph;

import java.util.*;

import GraphAlgorithm.GraphAdjacencyList;

public class Mcoloring {
	 public static void solve(ArrayList<ArrayList<Integer>> graph, int n) {
	        int color[]=new int[n];
	        for(int i=0;i<n;i++) {
	            if(color[i]==0) {
	                backTrack(graph, n, color, 0);
	            }
	        }
	        System.out.println(Arrays.toString(color));
	    }

	    public static boolean backTrack(ArrayList<ArrayList<Integer>> graph, int n, int colors[], int src){
	        if(src==n-1){
	            return true;
	        }
	        for(int i=1;i<=n;i++){
	            if(isSafe(graph,colors,i,src)){
	                colors[src]=i;
	                if(backTrack(graph,n,colors,src+1)){
	                    return true;
	                }
	                colors[src]=0;
	            }
	        }
	        return false;
	    }
	    public static boolean isSafe(ArrayList<ArrayList<Integer>> graph, int colors[], int color, int src) {
	        for(int x:graph.get(src)) {
	            if(colors[x]==color) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public static void main(String[] args) {
	    	 GraphAdjacencyList graph = new GraphAdjacencyList();
	 			graph.addVertex(3);
	         graph.addEdge(0, 1);
	         graph.addEdge(0, 2);
	         graph.addEdge(1, 2);
	         solve(graph.adjList,graph.adjList.size());
		}
}
