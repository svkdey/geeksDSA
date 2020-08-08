package LeetCode;

import java.util.HashMap;

public class LeetCode567 {
	public HashMap<Character, Integer> makeMap(String s1) {
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        for(char x:s1.toCharArray()) {
        	map.put(x,map.getOrDefault(x, 0)+1);
        }
        return map;
    }
	 public boolean checkInclusion(String s1, String s2) {
	        HashMap<Character, Integer> map1=makeMap(s1);
	        HashMap<Character, Integer> map2=makeMap(s2);
	        for(char c:map2.keySet()) {
	        	if(map1.containsKey(c)) {
	        		if(map2.get(c)>map1.get(c)) {
	        			return false;
	        		}
	        	}else {
	        		return false;
	        	}
	        }
	        return true;
	    }
}
