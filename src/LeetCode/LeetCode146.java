package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.*;

public class LeetCode146 {
	class LRUCache {
		HashMap<Integer, Integer> map=null;
		LinkedList<Integer> list=null;
		int cap=0;
		int currentSize=0;
		
		
	    public LRUCache(int capacity) {
	        cap=capacity;
	        map=new HashMap<>();
	        list=new LinkedList<>();
	    }
	    
	    public int get(int key) {
	    	  System.out.println(list+" "+map+" "+cap+" "+currentSize);
	        if(map.containsKey(key)) {
	        	int idx=list.indexOf(key);
	        	list.remove(idx);
	        	list.addFirst(key);
	        	return map.get(key);
	        	
	        }else {
	        	return -1;
	        }
	    }
	    
	    public void put(int key, int value) {
	    	if(map.containsKey(key)) {
	    		int idx=list.indexOf(key);
	        	list.remove(idx);
	        	list.addFirst(key);
	        	map.put(key, value);
	    	}
	    	else if(currentSize==cap) {
	        	int keyToRemove=list.removeLast();
	        	map.remove(keyToRemove);
	        	list.addFirst(key);
	        	map.put(key, value);
	        }else {
	        	currentSize++;
	        	list.addFirst(key);
	        	map.put(key, value);
	        }
	      System.out.println(list+" "+map+" "+cap+" "+currentSize);
	    }
	    
	}
	
	 public class LRUCacheByLib {
	        private LinkedHashMap<Integer, Integer> map;
	        private final int CAPACITY;
	        public LRUCacheByLib(int capacity) {
	            CAPACITY = capacity;
	            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
	                protected boolean removeEldestEntry(Map.Entry eldest) {
	                    return size() > CAPACITY;
	                }
	            };
	        }
	        public int get(int key) {
	            return map.getOrDefault(key, -1);
	        }
	        public void set(int key, int value) {
	            map.put(key, value);
	        }
	    }

}
