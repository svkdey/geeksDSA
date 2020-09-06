package LeetCode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode460 {

	static class LFUCache {
		long stamp;
		int capacity;
		int num;
		PriorityQueue<Pair> pq;
		HashMap<Integer, Pair> hashMap;

		// @param capacity, an integer
		public LFUCache(int capacity) {
			// Write your code here
			this.capacity = capacity;
			num = 0;
			pq = new PriorityQueue<Pair>();
			hashMap = new HashMap<Integer, Pair>();
			stamp = 0;
		}

	
		public void put(int key, int value) {
			if (capacity == 0) {
				return;
			}
			// Write your code here
			if (hashMap.containsKey(key)) {
				Pair old = hashMap.get(key);
				pq.remove(old);

				Pair newNode = new Pair(key, value, old.times + 1, stamp++);

				hashMap.put(key, newNode);
				pq.offer(newNode);
			} else if (num == capacity) {
				Pair old = pq.poll();
				hashMap.remove(old.key);

				Pair newNode = new Pair(key, value, 1, stamp++);

				hashMap.put(key, newNode);
				pq.offer(newNode);
			} else {
				num++;
				Pair pair = new Pair(key, value, 1, stamp++);
				hashMap.put(key, pair);
				pq.offer(pair);
			}
		}

		public int get(int key) {
			if (capacity == 0) {
				return -1;
			}
			// Write your code here
			if (hashMap.containsKey(key)) {
				Pair old = hashMap.get(key);
				pq.remove(old);

				Pair newNode = new Pair(key, old.value, old.times + 1, stamp++);

				hashMap.put(key, newNode);
				pq.offer(newNode);
				return hashMap.get(key).value;
			} else {
				return -1;
			}
		}

		class Pair implements Comparable<Pair> {
			long stamp;
			int key;
			int value;
			int times;

			public Pair(int key, int value, int times, long stamp) {
				this.key = key;
				this.value = value;
				this.times = times;
				this.stamp = stamp;
			}

			public int compareTo(Pair that) {
				if (this.times == that.times) {
					return (int) (this.stamp - that.stamp);
				} else {
					return this.times - that.times;
				}
			}
		}
	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3.
		cache.put(4, 4); // evicts key 1.
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}
}
