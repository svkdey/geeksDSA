package CrackingTheCodingInterView.LinkedList;

public class LoopDetectionInLL {
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

	public static boolean solve(LinkedListNode head) {
		LinkedListNode f = head.next;
		LinkedListNode s = head;

		while (f != null && f.next != null && f.next.next != null) {
			if (f == s) {
				return true;

			}
			f = f.next.next;
			s = s.next;
		}
		return false;
	}

	public static void removeLoopingPoint(LinkedListNode head) {

		// note both the s and f should start from same head node. else the theorem will
		// not work
		LinkedListNode f = head;
		LinkedListNode s = head;
		boolean hasLoop = false;
		while (f != null && f.next != null && f.next.next != null) {
			if (f == s) {
				hasLoop = true;
				break;

			}
			f = f.next.next;
			s = s.next;
		}
		if (hasLoop) {
			s = head;
			while (f.next != s.next) {
				f = f.next;
				s = s.next;
			}
			System.out.println(s.next.data);
			f.next = null;

		}
	}

	public static int loopLen(LinkedListNode h) {
		LinkedListNode t = h;
		int res = 1;
		while (t.next != h) {

			t = t.next;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode h1 = new LinkedListNode(5);

		LinkedListNode n1 = new LinkedListNode(2);
		LinkedListNode n2 = new LinkedListNode(10);
		LinkedListNode n3 = new LinkedListNode(22);
		LinkedListNode n4 = new LinkedListNode(5);
		LinkedListNode n5 = new LinkedListNode(3);

		h1.next = n1;
		n1.next = n2;
		n2.next = n5;
		n5.next = n2;
		removeLoopingPoint(h1);
	}

}
