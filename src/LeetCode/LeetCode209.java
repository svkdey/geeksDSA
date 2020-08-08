package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode209 {
	  public int minSubArrayLen(int s, int[] a) {
//	        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
//	        
//	        for(int i=0;i<nums.length;i++) {
//	        	sum+=nums[i];
//	        	int diff=sum-s;
//	        	if(diff==0) {
//	        		ans=Math.min(ans, i+1);
//	        	}
//	        	if(map.containsKey(diff)) {
//	        		ans=Math.min(ans, i-map.get(diff));
//	        	}
//	        		map.put(sum, i);
//	        	
//	        	
//	        }
//	        System.out.println(map);
//	        return ans;
		  
		  if(a.length==0) {
			  return 0;
		  }
		  int sum=0,i=0,j=0;
	      int ans=Integer.MAX_VALUE;
	        while(i<a.length) {
	        	sum+=a[i++];
	        	System.out.println(sum +" "+ i + " "+j);
	        	
	        	while(sum>=s) {
	        		ans=Math.min(ans, i-j);
	        		sum-=a[j++];
	        	}
	        	
	        	
	        }
	        return ans == Integer.MAX_VALUE ? 0 : ans;
	    }
	  public static void main(String[] args) {
		LeetCode209 s=new LeetCode209();
		int nums[]= {
			1,2,3,4,5};
		System.out.println(s.minSubArrayLen(11, nums));
	}
}
