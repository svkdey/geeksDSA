package LeetCode.InterviewPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TopKfreq {
	class Freqency {
		int x;
		int freq;

		public Freqency(int x, int freq) {
			super();
			this.x = x;
			this.freq = freq;
		}

	}

	public int[] topKFrequent(int[] nums, int k) {
		int ans[] = new int[k];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int x : nums) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		List<Freqency> l = new ArrayList<>();
		for (int x : map.keySet()) {
			l.add(new Freqency(x, map.get(x)));
		}
		Comparator<Freqency> rule = (a, b) -> {
			return b.freq - a.freq;
		};
		Collections.sort(l, rule);
		for (int i = 0; i < k; i++) {
			ans[i] = l.get(i).x;
		}
		return ans;
	}
}
