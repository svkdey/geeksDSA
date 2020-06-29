package CrackingTheCodingInterView.LinkedList;

import java.util.HashSet;

public class RemoveDuplicateInLL {
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

	public static void solveWhenLLisSorted(LinkedListNode head) {
		if (head == null)
			return;
		LinkedListNode cur = head;
		LinkedListNode f = head.next;
		while (cur != null && f != null) {
			while (f != null && cur.data == f.data) {
				f = f.next;
			}
			cur.next = f;
			cur = cur.next;
			if (f != null) {
				f = f.next;
			}
		}

	}

	public static void solveWhenLLisUnSorted(LinkedListNode head) {
		if (head == null)
			return;
		LinkedListNode cur = head;
		LinkedListNode f = head.next;
		HashSet<Integer> s = new HashSet<>();
		s.add(cur.data);
		while (cur != null && f != null) {
			while (f != null && s.contains(f.data)) {
				f = f.next;
			}

			if (f != null) {
				cur.next = f;
				cur = cur.next;
				s.add(cur.data);
				f = f.next;
			} else {
				cur.next = f;
			}
		}

	}

	private static LinkedListNode generateLinkedList() {
		int arr[] = { 2, 2,4,3,2 };
		LinkedListNode head = new LinkedListNode(arr[0]);
		LinkedListNode current = head;

		for (int i = 1; i < arr.length; i++) {
			current.next = new LinkedListNode(arr[i]);
			current = current.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode head1 = generateLinkedList();
		solveWhenLLisUnSorted(head1);
		System.out.println(head1);
	}

}
