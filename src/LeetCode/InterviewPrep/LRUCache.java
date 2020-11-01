package LeetCode.InterviewPrep;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class LRUCache {
	int cap=0;
	HashMap<Integer, Integer> map=null;
	Queue<Integer> q=null;
	int currentCapacity=0;
    public LRUCache(int capacity) {
        cap=capacity;
    	q=new LinkedList<Integer>();
    	map=new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	q.remove(key);
        	q.add(key);
        	return map.get(key);
        	
        }else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
        if(currentCapacity==cap) {
        	if(map.containsKey(key)) {
        		q.remove(key);
        		map.put(key, value);
            	q.add(key);
        	}else {
        		int k=q.remove();
            	map.remove(k);
            	map.put(key, value);
            	q.add(key);
        	}
        	
        }else {
        	currentCapacity++;
        	q.add(key);
        	map.put(key, value);
        }
    }
}