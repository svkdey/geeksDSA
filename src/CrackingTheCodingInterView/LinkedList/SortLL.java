package CrackingTheCodingInterView.LinkedList;

public class SortLL {
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

	public static LinkedListNode solve(LinkedListNode head) {
		//this base case is very important as LL will be broken to null or 1 node
		if (head == null||head.next==null)
			return head;
		//finding middle node and node before middle
		LinkedListNode temp = head;
		LinkedListNode s = head;
		LinkedListNode f = head;
		
		while (f != null && f.next != null) {
			temp = s;
			s = s.next;
			f = f.next.next;

		}
		//breaking into 2 ll
		temp.next = null;
		//recursively breaking the LL
		LinkedListNode leftLL = solve(head);
		LinkedListNode rightLL = solve(s);
		
		
		//merge 2 LL
		return merge(leftLL, rightLL);


	}

	private static LinkedListNode merge(LinkedListNode h1, LinkedListNode h2) {
		if (h1 == null)
			return h2;
		if (h2 == null)
			return h1;

		LinkedListNode dummy = new LinkedListNode(-1111);
		LinkedListNode temp = dummy;
		LinkedListNode l1 = h1;
		LinkedListNode l2 = h2;

		//merge		
		while (l1 != null && l2 != null) {
			if (l1.data > l2.data) {
				dummy.next = new LinkedListNode(l2.data);
				l2 = l2.next;
			} else {
				dummy.next = new LinkedListNode(l1.data);
				l1 = l1.next;
			}
			dummy = dummy.next;
		}
		
		while (l1 != null) {
			dummy.next = new LinkedListNode(l1.data);
			l1 = l1.next;
			dummy = dummy.next;
		}
		
		
		while (l2 != null) {
			dummy.next = new LinkedListNode(l2.data);
			l2 = l2.next;
			dummy = dummy.next;
		}
	
//		return  just next of head
		return temp.next;

	}
	private static LinkedListNode generateLinkedList() {
		int arr[] = { 5, 1, 10, 4,8, 18 };
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
		LinkedListNode head=generateLinkedList();
		LinkedListNode result=solve(head);
		System.out.println(result);
	}

}
