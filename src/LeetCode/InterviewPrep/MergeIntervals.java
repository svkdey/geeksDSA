package LeetCode.InterviewPrep;

import java.util.*;

public class MergeIntervals {
	 public int[][] merge(int[][] intervals) {
	        Comparator<int[]> rule=(a,b)->{
	        	return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
	        };
	       
	        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(rule);
	        
	        for(int x[]:intervals) {
	        	pq.add(x);
	        }
	        Stack<int[]> l=new Stack<int[]>();
	        while(!pq.isEmpty()) {
	        	if(l.isEmpty()) {
	        		l.add(pq.remove());
	        	}else {
	        		int last[]=l.pop();
	        		int curr[]=pq.remove();
	        		if(last[1]>=curr[0]) {
	        			if(last[1]>=curr[1]) {
	        				l.push(last);
	        			}
	        			else l.push(new int[] {last[0],curr[1]});
	        		}else {
	        			l.push(last);l.push(curr);
	        		}
	        	}
	        }
	        int ans[][]=new int[l.size()][2];
	        for(int i=0;i<l.size();i++) {
	        	ans[i]=l.get(i);
	        }
	        return ans;
	    }
}
