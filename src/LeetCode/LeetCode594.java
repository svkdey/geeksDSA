package LeetCode;

import java.util.HashMap;

public class LeetCode594 {
	public int findLHS(int[] nums) {
	      HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
	      for(int x:nums) {
	    	  map.put(x, map.getOrDefault(x, 0)+1);
	      }
	      int ans=0;
	      for(int x:map.keySet()) {
	    	  if(map.containsKey(x-1)) {
	    		  int a=map.get(x)+map.get(x-1);
	    		  ans=Math.max(ans, a);
	    	  }
	      }
	      return ans;
	  }
}
