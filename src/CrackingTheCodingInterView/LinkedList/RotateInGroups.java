package CrackingTheCodingInterView.LinkedList;

public class RotateInGroups {
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

	private static int getLen(LinkedListNode head) {
		if (head == null)
			return 0;
		LinkedListNode cur = head;
		int count = 0;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}

	public static LinkedListNode solve(LinkedListNode head, int k) {
		if (head == null)
			return head;

		LinkedListNode cur = head;
		int c = 0;

		LinkedListNode start = cur;
		LinkedListNode temp = null;
		while (cur != null && c != k) {
			start = cur.next;
			cur.next = temp;
			temp = cur;
			cur = start;
			c++;
		}
		// go for recursion
		if (cur != null) {
			head.next = solve(cur, k);
		}
		return temp;

	}

	private static LinkedListNode generateLinkedList() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		LinkedListNode head = new LinkedListNode(arr[0]);
		LinkedListNode current = head;

		for (int i = 1; i < arr.length; i++) {
			current.next = new LinkedListNode(arr[i]);
			current = current.next;
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedListNode head = generateLinkedList();
		System.out.println(solve(head, 3));
	}
}
