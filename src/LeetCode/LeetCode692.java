package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class LeetCode692 {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		Comparator<Entry<String, Integer>> rule = (a, b) -> {
			if (b.getValue() != a.getValue()) {
				return (b.getValue() - a.getValue());
			} else {
				return a.getKey().compareTo(b.getKey());
			}
		};

		PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<Entry<String, Integer>>(rule);
		
		for (Entry<String, Integer> x : map.entrySet()) {
			pq.add(x);
		}

		List<String> ans = new ArrayList<String>();
		while (!pq.isEmpty() && k != 0) {
			Entry<String, Integer> x = pq.remove();
			ans.add(x.getKey());
			k--;
		}
		Collections.sort(ans);
		return ans;
	}
}
