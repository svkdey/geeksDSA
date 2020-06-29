package LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode347 {
	 public int[] topKFrequent(int[] nums, int k) {
	        HashMap<Integer,Integer> s=new HashMap<Integer,Integer>();
	        
	        for(int x:nums){
	            if(s.containsKey(x)){
	                s.put(x,s.get(x)+1);
	                
	            }else{
	                 s.put(x,1);
	            }
	        }
	        Comparator<Map.Entry<Integer,Integer>> rule=(a,b)->{
	            return b.getValue()-a.getValue();
	        };
	       PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>(rule);
	        
	       for(Map.Entry<Integer,Integer> x:s.entrySet()) {
	    	   pq.add(x);
	       }
	       int ans[]=new int[k];
	       int i=0;
	       while(!pq.isEmpty()&&k>0) {
	    	   Map.Entry<Integer,Integer> x=pq.poll();
	    	   ans[i]=x.getKey();
	    	   k--;i++;
	       }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
