package LeetCode;

import java.util.*;

public class LeetCode451 {
	static class FrequencyMap{
		char lttr;int freq;

		@Override
		public String toString() {
			return "FrequencyMap [lttr=" + lttr + ", freq=" + freq + "]";
		}

		public FrequencyMap(char lttr, int freq) {
			super();
			this.lttr = lttr;
			this.freq = freq;
		}
		
	}
	   public String frequencySort(String s) {
	        char arr[]=s.toCharArray();
	        LinkedHashMap<Character, Integer> map=new LinkedHashMap<>();
	        
	        for(char c:arr) {
	        	map.put(c, map.getOrDefault(c, 0)+1);
	        }
	        Comparator<FrequencyMap> rule=(a,b)->{
	        	return b.freq-a.freq;
	        };
	        PriorityQueue<FrequencyMap> pq = new PriorityQueue<FrequencyMap>(Collections.reverseOrder(rule));
	        for(char c:map.keySet()) {
	        	pq.add(new FrequencyMap(c, map.get(c)));
	        	
	        }
	        
	        StringBuilder sb=new StringBuilder();
	        while(!pq.isEmpty()) {
	        	FrequencyMap p=pq.remove();
	        	for(int i=0;i<p.freq;i++) {
	        		sb.append(p.lttr);
	        	}
	        }
	        return sb.toString();
	    }
}
