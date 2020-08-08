package LeetCode;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode56 {
	  public static int[][] merge(int[][] intervals) {
		  Comparator<int[]> rule=(a,b)->{
			  return a[0]-b[0];
		  };
	        PriorityQueue<int[]> pq = new PriorityQueue<>(rule);
	        for(int x[]:intervals) {
	        	pq.add(x);
	        }
	        
	        List<int[]> l=new ArrayList<>();
	        l.add(pq.remove());
	        while(!pq.isEmpty()) {
	        	int lastInteval[]=l.get(l.size()-1);
	        	l.remove(l.size()-1);
	        	int current[]=pq.remove();
	        	if(lastInteval[1]>=current[0]) {
	        		if(lastInteval[1]>current[1]) {
	        			l.add(lastInteval);
	        		}
	        		else {
	        			l.add(new int[] {lastInteval[0],current[1]});
	        		}
	        	}else {
	        		l.add(lastInteval);
	        		l.add(current);
	        	}
	        }
	        int ans[][]=new int[l.size()][2];
	     for(int i=0;i<l.size();i++) {
	    	 ans[i]=l.get(i);
	    	 System.out.println(Arrays.toString(l.get(i)));
	     }
	        return ans;
	    }
	  public static void main(String[] args) {
		int intervals[][]= {{1,3},{2,6},{8,10},{15,18}};
		int intervals2[][]= {{1,4},{4,5}};
		merge(intervals2);
	}
}
