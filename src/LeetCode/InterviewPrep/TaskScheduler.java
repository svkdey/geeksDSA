package LeetCode.InterviewPrep;

import java.util.*;

public class TaskScheduler {
	class Task {
		int freq, lastUsed = -1;

		public Task(int f) {
			freq = f;
		}

		public Task(int freq, int lastUsed) {
			super();
			this.freq = freq;
			this.lastUsed = lastUsed;
		}

		@Override
		public String toString() {
			return "Task [freq=" + freq + ", lastUsed=" + lastUsed + "]";
		}
		
		
		
	}

	public int leastInterval(char[] tasks, int n) {
		HashMap<Character, Task> map = new HashMap<Character, Task>();
		for (char c : tasks) {
			map.putIfAbsent(c, new Task(0));
			map.get(c).freq++;
		}
		Comparator<Task> rule = (a, b) -> {
			return b.freq - a.freq;
		};
		PriorityQueue<Task> pq = new PriorityQueue<Task>(rule);
		pq.addAll(map.values());
		int time = 0;
		Queue<Task> cooling = new LinkedList<>();

		while (!pq.isEmpty() || !cooling.isEmpty()) {
			if (pq.isEmpty()) {
				time = cooling.peek().lastUsed+n + 1;
			}
			while (!cooling.isEmpty() && time > cooling.peek().lastUsed + n) {
				pq.add(cooling.remove());
			}
			Task t = pq.poll();
			t.lastUsed = time++;
			t.freq--;
			if (t.freq != 0)
				cooling.add(t);
			System.out.println(pq);
			System.out.println(cooling);
		}
		return time;
	}
}
