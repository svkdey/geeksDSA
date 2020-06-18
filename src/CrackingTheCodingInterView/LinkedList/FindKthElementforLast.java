package CrackingTheCodingInterView.LinkedList;

public class FindKthElementforLast {
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
	public static LinkedListNode solve(LinkedListNode head,int k) {
		LinkedListNode pt1=head;
		LinkedListNode pt2=head;
		while(k-->0) {
			pt1=pt1.next;
		}
		while(pt1!=null) {
			pt1=pt1.next;
			pt2=pt2.next;
		}
		return pt2;
	}
	private static LinkedListNode generateLinkedList() {
		int arr[]= {5,1,10,19,18,4};
		LinkedListNode head=new LinkedListNode(arr[0]);
		LinkedListNode current=head;
		
		for(int i=1;i<arr.length;i++) {
			current.next=new LinkedListNode(arr[i]);
			current=current.next;
		}
		return head;
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		LinkedListNode head=generateLinkedList();
		System.out.println(solve(head, 2));
	}

}
