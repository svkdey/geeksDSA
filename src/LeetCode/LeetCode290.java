package LeetCode;

import java.util.HashMap;

public class LeetCode290 {
	 public boolean wordPattern(String pattern, String str) {
	        String arr[]=str.split(" ");
	        char cArr[]=pattern.toCharArray();
	        if(arr.length!=cArr.length) {
	        	return false;
	        }
	        HashMap<Character, String > map=new HashMap<Character, String>();
	        for(int i=0;i<arr.length;i++) {
	        	
	        	if(map.containsKey(cArr[i])) {
	        		if(!map.get(cArr[i]).equals(arr[i])) {
	        			return false;
	        		}
	        	}else if(map.containsValue(arr[i])) {
	        		return false;
	        	}else {
	        		map.put(cArr[i], arr[i]);
	        	}
	        }
	        System.out.println(map);
	        return true;
	    }
}
