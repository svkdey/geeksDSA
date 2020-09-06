package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCode1189 {
	 public int maxNumberOfBalloons(String text) {
	        char c[]="balloon".toCharArray();
	        HashMap<Character,Integer> set=new HashMap<Character,Integer>();
	        for(char x:c) {
	        	set.put(x, set.getOrDefault(x,0)+1);
	        }
	        
	        HashMap<Character,Integer> map=new HashMap<>();
	        for(char x:text.toCharArray()) {
	        	map.put(x, map.getOrDefault(x,0)+1);
	        }
	        int ans=Integer.MAX_VALUE;
	        for(char x:set.keySet()) {
	        	if(map.containsKey(x)) {
	        		ans=Math.min(ans,(map.get(x)/set.get(x)));
	        	}
	        }
	      
	        return ans==Integer.MAX_VALUE?0:ans;
	    }
}
