package CrackingTheCodingInterView.LinkedList;

public class DeleteMiddleElement {

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

	private static LinkedListNode generateLinkedList() {
		int arr[] = { 5, 1,4,2 };
		LinkedListNode head = new LinkedListNode(arr[0]);
		LinkedListNode current = head;

		for (int i = 1; i < arr.length; i++) {
			current.next = new LinkedListNode(arr[i]);
			current = current.next;
		}
		return head;
	}

	public static void solve(LinkedListNode head) {
		if (head == null)
			return;

		LinkedListNode s = head;
		LinkedListNode f = head;
		LinkedListNode ptr = head;
		boolean isSafe = false;
		
		while (f.next != null && f.next.next != null) {
			f = f.next.next;
			s = s.next;
			isSafe = true;
		}
		
		if (isSafe) {
			while (ptr.next != s) {
				ptr = ptr.next;
			}
			ptr.next = ptr.next.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode h = generateLinkedList();
		solve(h);
		while (h != null) {
			System.out.print(h.data + "->");
			h = h.next;
		}
	}

}
