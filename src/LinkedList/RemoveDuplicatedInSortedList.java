package LinkedList;

import java.util.HashSet;

public class RemoveDuplicatedInSortedList {

	static LinkedListNode removeDuplicates(LinkedListNode root) {
		// Your code here
		if (root == null || root.next == null)
			return root;
		LinkedListNode curNode = root;
		LinkedListNode nxt = root.next;
		while (nxt != null) {
			if (nxt.data == curNode.data) {
				nxt = nxt.next;
				if (nxt == null) {
					curNode.next = nxt;
				}
			} else {
				curNode.next = nxt;
				nxt = nxt.next;
				curNode = curNode.next;
			}
		}
		return root;
	}

	static LinkedListNode removeDuplicatesInUnsortedList(LinkedListNode root) {
		if (root == null || root.next == null)
			return root;
		HashSet<Integer> hs = new HashSet<Integer>();
		LinkedListNode currentNode = root;
		LinkedListNode nextNode = root.next;
		hs.add(currentNode.data);
		while (nextNode != null) {
			if (hs.contains(nextNode.data)) {
				nextNode = nextNode.next;
				//if reaches to null then no more iteration ..so let join nodes
				if (nextNode == null) {
					currentNode.next = nextNode;
				}
			} else {
				hs.add(nextNode.data);
				currentNode.next = nextNode;
				currentNode = currentNode.next;
				nextNode = nextNode.next;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		l.insertBegin(3);
		l.insertBegin(3);
		l.insertBegin(3);
		l.insertBegin(1);
		l.addLast(50);
		LinkedList l1 = new LinkedList();
		l1.insertBegin(1);
		LinkedList l2 = new LinkedList();
		l2.insertBegin(1);
		l2.insertBegin(1);
		LinkedList l3 = new LinkedList();
		l3.insertBegin(2);
		l3.insertBegin(1);
		l3.insertBegin(1);

		LinkedList l4 = new LinkedList();
		l4.insertBegin(1);
		l4.insertBegin(2);
		l4.insertBegin(2);
		LinkedList l5 = new LinkedList();
		l5.insertBegin(5);
		l5.insertBegin(5);
		l5.insertBegin(4);
		l5.insertBegin(4);
		l5.insertBegin(2);
		l5.insertBegin(1);
		System.out.println(l5);
		System.out.println(removeDuplicatesInUnsortedList(l5.head));

	}

}
