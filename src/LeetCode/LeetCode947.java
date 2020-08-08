package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode947 {
	
	 public int removeStones(int[][] stones) {
		 ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
		 for(int i=0;i<=10000;i++) {
			 graph.add(new ArrayList<Integer>());
		 }
		 int numberOfV=stones.length;
		 for(int i=0;i<stones.length-1;i++) {
			 for(int j=i+1;j<stones.length;j++) {
				 numberOfV=Math.max(numberOfV, Math.max(stones[i][0], stones[i][1]));
				 if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]) {
					 graph.get(i).add(j);
					 graph.get(j).add(i);
				 }
			 }
		 }
		 int color[]=new int[numberOfV];
		 Arrays.fill(color, -1);
		 int c=0;
		 for(int i=0;i<numberOfV;i++) {
			 if(color[i]==-1) {
				 dfs(graph, color, c++,i);
			 }
		 }
		 System.out.println(Arrays.toString(color)+"--->"+c);
		 return numberOfV-c;
		 
	    }
	 public void dfs( ArrayList<ArrayList<Integer>> graph,int color[],int c,int src) {
		 color[src]=c;
		 for(int child:graph.get(src)) {
			 if(color[child]==-1) {
				 dfs(graph, color, c,child);
			 }
		 }
	 }
	 public static void main(String[] args) {
		 LeetCode947 s=new LeetCode947();
		 int stones[][] = {{0,1},{1,0}};
		 System.out.println(s.removeStones(stones));
	}
}
