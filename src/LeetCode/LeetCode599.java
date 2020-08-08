package LeetCode;

import java.util.*;

public class LeetCode599 {
	 public String[] findRestaurant(String[] list1, String[] list2) {
	       
	        HashMap<String,Integer> s=new HashMap<>();
	        HashMap<Integer,ArrayList<String>> result=new HashMap<>();
	        for(int i=0;i<list1.length;i++){
	           s.put(list1[i],i);
	        }
	        int minIDx=Integer.MAX_VALUE;
	        for(int i=0;i<list2.length;i++){
		           if(s.containsKey(list2[i])) {
		        	   int key=i+s.get(list2[i]);
		        	   if(result.containsKey(key)) {
		        		   ArrayList<String> l= result.get(key);
		        		   l.add(list2[i]);
		        		   result.put(key,l);
		        	   }else {
		        		   ArrayList<String> l= new ArrayList<String>();
		        		   l.add(list2[i]);
		        		   result.put(key,l);
		        	   }
		        	   
		        	   minIDx=Math.min(key, minIDx);
		           }
		       }
	        ArrayList<String> l= result.get(minIDx);
	        String ans[]=new String[l.size()];
	        for(int i=0;i<l.size();i++) {
	        	ans[i]=l.get(i);
	        }
	        return ans;
	    }
}
