package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode49 {
	 public List<List<String>> groupAnagrams(String[] strs) {
	        HashMap<String, ArrayList<String>> map=new HashMap<String, ArrayList<String>>();
	        for(String s:strs) {
	        	char arr[]=s.toCharArray();
	        	Arrays.sort(arr);
	        	String str=new String(arr);
	        	if(map.containsKey(str)) {
	        		map.get(str).add(s);
	        	}else {
	        		ArrayList<String> newlist=new ArrayList<String>();
	        		newlist.add(s);
	        		map.put(str,newlist);
	        	}
	        }
	       List<List<String>> ans=new ArrayList<List<String>>();
	       for(String key:map.keySet()) {
	    	   ans.add(map.get(key));
	       }
	       return ans;
	    }
}
