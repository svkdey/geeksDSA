package CrackingTheCodingInterView.LinkedList;

public class Intersection2LL {
	static class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode() {
			// TODO Auto-generated constructor stub
		}

		public LinkedListNode(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "LinkedListNode [data=" + data + ", next=" + next + "]";
		}
		
	}

	static class LinkedList {
		LinkedListNode head;
		int length;

		@Override
		public String toString() {
			return "LinkedList [head=" + head + ", length=" + length + "]";
		}

		public LinkedList() {
			this.head = null;
		}

		public LinkedList(int data) {
			LinkedListNode node = new LinkedListNode(data);
			this.head = node;
		}

		public void traverse() {
			LinkedListNode currentNode = this.head;
			while (currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}

	public static int findLen(LinkedListNode h1) {
		LinkedListNode current = h1;
		int len = 1;
		while (current != null) {
			len++;
			current = current.next;
		}
		return len;

	}

	public static LinkedListNode solve(LinkedListNode h1, LinkedListNode h2) {
		LinkedListNode f = null;
		LinkedListNode s = null;

		int len_h1 = findLen(h1);
		int len_h2 = findLen(h2);
		if (len_h1 > len_h2) {
			f = h1;
			s = h2;
		} else {
			f = h2;
			s = h1;
		}

		int diff = Math.abs(len_h1 - len_h2);
		while (diff-- > 0) {
			f = f.next;
		}
		while (f != null && s != null) {
			if (f == s) {
				return f;
			}
			f = f.next;
			s = s.next;
		}
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode h1 = new LinkedListNode(5);
		LinkedListNode h2 = new LinkedListNode(3);
		LinkedListNode n1 = new LinkedListNode(2);
		LinkedListNode n2 = new LinkedListNode(10);
		LinkedListNode n3 = new LinkedListNode(22);
		LinkedListNode n4 = new LinkedListNode(5);
		LinkedListNode n5 = new LinkedListNode(2);
		h1.next = n1;
		n1.next = n4;
		n4.next = n5;
		n5.next = n3;
		h2.next = n2;
		n2.next = null;
		System.out.println(solve(h1, h2));
	}

}
