package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LeetCode1002 {
	 public static List<String> commonChars(String[] A) {
		 List<String> res = new ArrayList<>();
	        if (A.length < 1) return res;
	        Map<Character, Integer> map = new HashMap<>();
			/* Add the first string to the map */ 
	      char c[]=A[0].toCharArray();
	      for(char x:c) {
	    	  map.put(x, map.getOrDefault(x, 0)+1);
	      }
	      
	      for(int i=1;i<A.length;i++) {
	    	 
	    	  char charArray[]=A[i].toCharArray();
	    	  Map<Character, Integer> mapInside = new HashMap<>();
	    	  for(char x:charArray) {
	    		  if(!map.containsKey(x)) {
	    			  map.put(x,0);
	    		  }
	    		  mapInside.put(x, mapInside.getOrDefault(x, 0)+1);
		      }
//	    	  System.out.println("befire :" +mapInside);
	    	  for(Map.Entry<Character, Integer> e:mapInside.entrySet()) {
	    		  mapInside.put(e.getKey(), Math.min(e.getValue(), map.get(e.getKey())));
	    	  }
//	    	  System.out.println("after :" +mapInside);
	    	  map=mapInside;
	    	  
	    	  
	      }
	      for(Map.Entry<Character, Integer> e:map.entrySet()) {
	    	  if(e.getValue()>0) {
	    		 for(int i=0;i<e.getValue();i++) {
	    			 res.add(Character.toString(e.getKey()));
	    		 }
	    	  }
	      }
	      System.out.println(res);
	        return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"cool","locki","cook"};
		commonChars(s);
	}

}
