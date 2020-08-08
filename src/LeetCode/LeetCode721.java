package LeetCode;

import java.util.*;

public class LeetCode721 {
	 public List<List<String>> accountsMerge(List<List<String>> accounts) {
	     HashMap<String, ArrayList<TreeSet<String>>> map=new HashMap<String, ArrayList<TreeSet<String>>>();
	     for(List<String> x:accounts) {
	    	 if(map.containsKey(x.get(0))) {
	    		 ArrayList<TreeSet<String>> l=map.get(x.get(0));
	    		 int idx=isSame(l,x);
	    		 
	    		 if(idx==-1) {
	    			
	    			 TreeSet<String> set=new TreeSet<String>();
		    		 for(int i=1;i<x.size();i++) {
		    			 set.add(x.get(i));
		    		 }
		    		 l.add(set);
		    		 map.put(x.get(0),l);
	    		 }else {
	    			 TreeSet<String> set=l.get(idx);
	    			 for(int i=1;i<x.size();i++) {
		    			 set.add(x.get(i));
		    		 }
	    			 l.set(idx, set);
	    			 map.put(x.get(0),l);
	    		 }
	    	 }else {
	    		 ArrayList<TreeSet<String>> l=new ArrayList<TreeSet<String>>();
	    		TreeSet<String> set=new TreeSet<String>();
	    		 for(int i=1;i<x.size();i++) {
	    			 set.add(x.get(i));
	    		 }
	    		 l.add(set);
	    		 map.put(x.get(0),l);
	    	 }
	     }
	     
	     System.out.println(map);
	     List<List<String>> ans=new ArrayList<List<String>>();
	     for(Map.Entry<String, ArrayList<TreeSet<String>>> x:map.entrySet()) {
	    	 String person=x.getKey();
	    	 ArrayList<TreeSet<String>> userNamesUnserSamePersonName=x.getValue();
	    	 for(TreeSet<String> userId:userNamesUnserSamePersonName) {
	    		 List<String> subAns=new ArrayList<String>();
	    		 subAns.add(person);
	    		 for(String id:userId) {
	    			 subAns.add(id);
	    		 }
	    		 ans.add(subAns);
	    	 }
	    	 
	    	 
	    	 
	     }
	     return ans;
		 
	    }
	 
	 public int isSame( ArrayList<TreeSet<String>> l,List<String> x) {
		 for(int i=0;i<l.size();i++) {
			 if(contains(l.get(i),x)) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 public boolean contains( TreeSet<String> l,List<String> x) {
		 for(int i=1;i<x.size();i++) {
			 if(l.contains(x.get(i))) {
				 return true;
			 }
		 }
		 return false;
	 }
}
