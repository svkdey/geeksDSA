package LeetCode.InterviewPrep;

import java.util.ArrayList;
import java.util.*;

public class CourseSchedule {
	 public void findOrder(int numCourses, int[][] prerequisites) {
	        ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>>();
	        for(int i=0;i<numCourses;i++) {
	        	g.add(new ArrayList<Integer>());
	        }
	        for(int[] dep:prerequisites) {
	        	g.get(dep[0]).add(dep[1]);
	        }
	        
	        boolean inQ[]=new boolean[numCourses];
	        boolean v[]=new boolean[numCourses];
	        courseSchedulePossible=true;
	        Queue<Integer> l=new LinkedList<Integer>();
	        for(int i=0;i<numCourses;i++) {
	        	if(!v[i]) {
	        		dfs(g, inQ, v, l, i);
	        	}
	        }
	        System.out.println(courseSchedulePossible);
	        while(!l.isEmpty()) {
	        	System.out.println(l.remove());
	        }
	        
	    }
	 static boolean courseSchedulePossible=true;
	 public void dfs(ArrayList<ArrayList<Integer>> g,boolean inQ[],boolean v[],Queue<Integer> stack,int src) {
		 
		 inQ[src]=true;
		 v[src]=true;
		 for(int nbr:g.get(src)) {
			 if(!v[nbr]) {
				 dfs(g, inQ, v, stack, nbr);
			 }else if(inQ[nbr]) {
				 courseSchedulePossible=false;
				 return;
			 }
		 }
		 inQ[src]=false;
		 stack.add(src);
		 
	 }
	 public static void main(String[] args) {
		 CourseSchedule c=new CourseSchedule();
		 int numCourses = 4, prerequisites[][] = {{1,0},{2,0},{3,1},{3,2}};
		 c.findOrder(numCourses, prerequisites);
	}
}
