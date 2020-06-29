package CrackingTheCodingInterView.LinkedList;

import CrackingTheCodingInterView.LinkedList.SumOfTwoLL.LinkedListNode;

public class Merge2LL {
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

	public static LinkedListNode solve(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode l1 = head1;
		LinkedListNode l2 = head2;

		LinkedListNode newHead = null;

		if (l1.data > l2.data) {
			newHead = new LinkedListNode(l2.data);
			l2 = l2.next;
		} else {

			newHead = new LinkedListNode(l1.data);
			l1 = l1.next;
		}
		LinkedListNode result = newHead;
		while (l1 != null && l2 != null) {
			if (l1.data > l2.data) {
				LinkedListNode temp = new LinkedListNode(l2.data);
				l2 = l2.next;
				newHead.next = temp;

			} else {

				LinkedListNode temp = new LinkedListNode(l1.data);
				l1 = l1.next;
				newHead.next = temp;
			}
			newHead = newHead.next;
		}

		while (l1 != null) {

			LinkedListNode temp = new LinkedListNode(l1.data);

			newHead.next = temp;
			newHead = newHead.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			LinkedListNode temp = new LinkedListNode(l2.data);

			newHead.next = temp;
			newHead = newHead.next;
			l2 = l2.next;
		}

		System.out.println(result);
		return result;

	}

	private static LinkedListNode generateLinkedList(int arr[]) {

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
		int arr1[] = { 2, 3, 7 };
		int arr2[] = { 1, 4, 5, 10 };
		LinkedListNode l1 = generateLinkedList(arr1);
		LinkedListNode l2 = generateLinkedList(arr2);

		solve(l1, l2);
	}
}
