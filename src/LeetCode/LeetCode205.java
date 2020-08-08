package LeetCode;

import java.util.HashMap;

public class LeetCode205 {
	 public boolean isIsomorphic(String s, String t) {
		 if(s.length()!=t.length()) return false;
	        HashMap<Character, Character> map1=new HashMap<Character, Character>();
	       
	        char sArr[]=s.toCharArray();
	        char tArr[]=t.toCharArray();
	        
	        for(int i=0;i<sArr.length;i++) {
	        	if(map1.containsKey(sArr[i])) {
	        		if(tArr[i]!=map1.get(sArr[i])) {
	        			return false;
	        		}
	        	}else if(map1.containsValue(tArr[i])) {
	        		return false;
	        	}
	        else{
	        	map1.put(sArr[i], tArr[i]);
         }
	        }
	        return true;
	    }
	 public static void main(String[] args) {
		
	}
}
