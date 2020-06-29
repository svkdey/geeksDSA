package CrackingTheCodingInterView.LinkedList;

import java.util.HashMap;

/**
 * 1.we have HashMap<Integer, ListNode> map; 2.we have taken head,tail as dummy
 * so that we can work btwn them easily
 * 
 * 
 */
public class LRUcacheImplementation {
	int capacity;
	HashMap<Integer, ListNode> map;
	ListNode head;
	ListNode tail;
	int currentcapacity = 0;

	@Override
	public String toString() {
		return "LRUcacheImplementation [capacity=" + capacity + ", map=" + map + ", head=" + head + ", tail=" + tail
				+ "]";
	}

	// on obj instance create dummy head tail and map obj
	public LRUcacheImplementation(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		this.map = new HashMap<Integer, ListNode>();
		head = new ListNode(0, 0);
		tail = new ListNode(0, 0);
		head.next = tail;
		tail.prev = head;

	}

	private void remove(ListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void add(ListNode node) {
		node.next = this.head.next;
		node.next.prev = node;
		node.prev = head;
		head.next = node;
	}

	public int get(int key) {
		int ans = -1;
		if (map.containsKey(key)) {
			ListNode node = map.get(key);
			ans = node.data;

			remove(node);
			add(node);
			System.out.println(key + " -->" + ans);
			return ans;
		}
		System.out.println(key + " -->" + ans);
		return ans;

	}

	public void put(int key, int data) {
		if (map.containsKey(key)) {
			ListNode node = map.get(key);
			node.data = data;
			remove(node);
			add(node);
		} else {
			ListNode newNode = new ListNode(key, data);
			if (currentcapacity < capacity) {
				add(newNode);
				map.put(key, newNode);
				currentcapacity++;
			} else {
				map.remove(tail.prev.id);
				map.put(key, newNode);
				remove(tail.prev);
				add(newNode);

			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Going to test the LRU " + " Cache Implementation");
		LRUcacheImplementation cache = new LRUcacheImplementation(2);

// it will store a key (1) with value  
// 10 in the cache. 
		cache.put(1, 10);

// it will store a key (1) with value 10 in the cache. 
		cache.put(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

// evicts key 2 and store a key (3) with 
// value 30 in the cache. 
		cache.put(3, 30);

		System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)

// evicts key 1 and store a key (4) with 
// value 40 in the cache. 
		cache.put(4, 40);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
		System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40
	}

}
