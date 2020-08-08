package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode1207 {
	 public boolean uniqueOccurrences(int[] arr) {
	    HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
	    for(int x:arr) {
	    	map.put(x,map.getOrDefault(x, 0)+1);
	    }
	    HashMap<Integer, Integer> map2=new HashMap<Integer, Integer>();
	    for(int x:map.keySet()) {
	    	if(map2.containsKey(map.get(x))) {
	    		return false;
	    	}
	    	else {
	    		map2.put(map.get(x), 1);
	    	}
	    }
	
	    return true;
	    }
}
