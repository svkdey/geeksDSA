package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode911 {
	class TopVotedCandidate {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		int time[];

		public TopVotedCandidate(int[] persons, int[] times) {
			time = times;
			int lead = persons[0];
			Map<Integer, Integer> c = new HashMap<Integer, Integer>();
			c.put(persons[0], c.getOrDefault(persons[0], 0) + 1);
			m.put(times[0], lead);
			for (int i = 1; i < persons.length; i++) {
				c.put(persons[i], c.getOrDefault(persons[i], 0) + 1);
				if (c.get(persons[i]) >= c.get(lead)) {
					lead = persons[i];
				}
				m.put(times[i], lead);
			}
		}

		public int q(int t) {
			int idx = Arrays.binarySearch(time, t);
			return idx < 0 ? m.get(time[-idx - 2]) : m.get(time[idx]);
		}
	}

}
