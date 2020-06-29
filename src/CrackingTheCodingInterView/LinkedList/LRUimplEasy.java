package CrackingTheCodingInterView.LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUimplEasy {
	LinkedHashMap<Integer, Integer> hs = null;
	int capacity;
	int presentCapacity;

	@Override
	public String toString() {
		return "LRUimplEasy [hs=" + hs + ", capacity=" + capacity + ", presentCapacity=" + presentCapacity + "]";
	}

	public LRUimplEasy(int capacity) {
		// TODO Auto-generated constructor stub

		this.capacity = capacity;
		this.hs = new LinkedHashMap<Integer, Integer>(capacity);
	}

	public int get(int id) {
		int ans = -1;
		if (this.hs.containsKey(id)) {
			ans = this.hs.get(id);
			this.hs.remove(id);
			this.hs.put(id, ans);
		}
		return ans;
	}

	public void put(int id, int value) {
		int ans = -1;
		if (this.hs.containsKey(id)) {
			ans = this.hs.get(id);
			this.hs.remove(id);
			this.hs.put(id, value);
		} else {
			if (presentCapacity == capacity) {
				Map.Entry<Integer, Integer> item = null;
				for (Map.Entry<Integer, Integer> hs : this.hs.entrySet()) {
					item = hs;
					break;
				}
				this.hs.remove(item.getKey());
				this.hs.put(id, value);
			} else {
				this.hs.put(id, value);
				presentCapacity++;
			}
		}
		
		
	}

	public static void main(String[] args) {
		LRUimplEasy lru = new LRUimplEasy(3);
		lru.put(2, 2000);
		lru.put(1, 5000);
		lru.put(3, 4000);
		System.out.println(lru.get(0));
		lru.put(9, 5000);
		lru.put(9, 500);
		System.out.println(lru.get(1));

		System.out.println(lru);
	}
}
