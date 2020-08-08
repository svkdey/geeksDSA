package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class LeetCode380 {
	class RandomizedSet {
		HashMap<Integer, Integer> map=null;
		ArrayList<Integer> list=null;
		
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	       map=new HashMap<Integer, Integer>();
	       list=new ArrayList<Integer>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val)) {
	        	return false;
	        }
	        else {
	        	map.put(val,val);
	        	list.add(val);
	        	return true;
	        }
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	if(map.containsKey(val)) {
	        map.remove(val);
	        list.remove(val);
	        return true;
	        }
	        else {
	        	return false;
	        }
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	       Random rd=new Random();
	       int idx=rd.nextInt(list.size());
	       return list.get(idx);
	    }
	}

}
