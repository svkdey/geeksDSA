package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode821 {
	 public int[] shortestToChar(String S, char C) {
	        HashSet<Integer> set=new HashSet<Integer>();
	        
	        for(int i=0;i<S.length();i++) {
	        	if(S.charAt(i)==C) {
	        		set.add(i);
	        	}
	        }
	        
	        int ans[]=new int[S.length()];
	        Arrays.fill(ans, Integer.MAX_VALUE);
	        for(int i=0;i<S.length();i++) {
	        	for(int x:set) {
	        		ans[i]=Math.min(Math.abs(i-x),ans[i]);
	        	}
	        }
	        return ans;
	    }
}
