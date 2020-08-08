package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode986 {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		 Comparator<int[]> rule=(a,b)->{
			  return a[0]-b[0];
		  };
	        PriorityQueue<int[]> pq = new PriorityQueue<>(rule);
	        for(int x[]:A) {
	        	pq.add(x);
	        }
	        for(int x[]:B) {
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
}
