package LeetCode;

import java.util.PriorityQueue;

public class LeetCode703 {
	class KthLargest {
		PriorityQueue<Integer> pq = null;
		
		int kthelement=-1;
	    public KthLargest(int k, int[] nums) {
	
	    	pq = new PriorityQueue<Integer>();
	    	this.kthelement=k;
	    	for(int x:nums) {
	    		pq.add(x);
	    	}
	    }
	    
	    public int add(int val) {
	        this.pq.add(val);
	        int i=this.kthelement;
	       
	        while(pq.size()>i) {
	        	pq.remove();
	        }
	       
	        return pq.peek();
	    }
	    }
}
