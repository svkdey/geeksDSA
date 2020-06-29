package CrackingTheCodingInterView.LinkedList;

public class IfLLIsPalindrome {
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
//	2,1,3,1,2
	private static LinkedListNode generateLinkedList() {
		int arr[] = { 5, 1, 5 };
		LinkedListNode head = new LinkedListNode(arr[0]);
		LinkedListNode current = head;

		for (int i = 1; i < arr.length; i++) {
			current.next = new LinkedListNode(arr[i]);
			current = current.next;
		}
		return head;
	}
	public static void traverse(LinkedListNode h) {
		LinkedListNode currentNode = h;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	public static LinkedListNode reverseLL(LinkedListNode head) {
		LinkedListNode current=head;
		LinkedListNode temp=null;
		while(current!=null) {
			current=current.next;
			head.next=temp;
			temp=head;
			head=current;
		}
		return temp;
	}
	public static boolean solve(LinkedListNode head) {
		LinkedListNode s=head;
		LinkedListNode f=head;
		while(f!=null && f.next!=null && f.next.next!=null) {
			f=f.next.next;
			s=s.next;
		}
		if(f!=null) {
			s=s.next;
		}
		LinkedListNode rLL=reverseLL(s);
		System.out.println(rLL);
		f=head;
		while(rLL!=null) {
			if(rLL.data!=f.data) {
				return false;
			}
			rLL=rLL.next;
			f=f.next;
		}
		return true;
	}

	public static void main(String[] args) {
		
		LinkedListNode head=generateLinkedList();
		System.out.println(solve(head));
	}

}
