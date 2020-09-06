package LeetCode;

import java.util.*;

public class LeetCode1418 {
	 public List<List<String>> displayTable(List<List<String>> orders) {
	        TreeMap<Integer, TreeMap<String, Integer>> details=new TreeMap<>();
	        List<List<String>> ans=new ArrayList<List<String>>();
	        TreeSet<String> head=new TreeSet<String>();
	        List<String> header=new ArrayList<String>();
	        header.add("Table");
	        for(List<String> order:orders) {
	        	
	        		TreeMap<String, Integer> foodDetails=null; 
	        		if(details.containsKey(Integer.parseInt(order.get(1)))) {
	        			foodDetails=details.get(Integer.parseInt(order.get(1)));
	        		}else {
	        			foodDetails=new TreeMap<String, Integer>();
	        		}
	        		foodDetails.put(order.get(2), foodDetails.getOrDefault(order.get(2), 0)+1);
	        		if(!head.contains(order.get(2))) {
	        			head.add(order.get(2));
	        		}
	        		details.put(Integer.parseInt(order.get(1)), foodDetails);
	        	
	        }
	        for(String x:head) {
	        	header.add(x);
	        }
	        ans.add(header);
	        for(int x:details.keySet()) {
	        	TreeMap<String, Integer> detail=details.get(x);
	        	 List<String> items=new ArrayList<String>();
	        	 items.add(Integer.toString(x));
	        	 for(int i=1;i<header.size();i++) {
	        		 items.add(Integer.toString(detail.getOrDefault(header.get(i), 0)));
	        	 }
	        }
	        return ans;
	    }
}
