package CrackingTheCodingInterView.LinkedList;

public class PartitionAboutX {
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

		public void traverse(LinkedListNode h) {
			LinkedListNode currentNode = h;
			while (currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}
	private static LinkedListNode generateLinkedList() {
		int arr[] = { 5, 1, 10, 19, 18, 4 };
		LinkedListNode head = new LinkedListNode(arr[0]);
		LinkedListNode current = head;

		for (int i = 1; i < arr.length; i++) {
			current.next = new LinkedListNode(arr[i]);
			current = current.next;
		}
		return head;
	}
	
	public static LinkedListNode solve(LinkedListNode head,int x) {
		LinkedListNode a=null;
		LinkedListNode first=a;
		
		LinkedListNode b=null;
		LinkedListNode second=b;
		
		LinkedListNode current=head;
		while(current!=null) {
			if(current.data<x) {
				LinkedListNode t=new LinkedListNode(current.data);
				if(a==null) {
					a=t;
					first=a;
				}else {
					a.next=t;
					a=a.next;
				}
			}else {
				LinkedListNode t=new LinkedListNode(current.data);
				if(b==null) {
					b=t;
					second=b;
				}else {
					b.next=t;
					b=b.next;
				}
			}
			current=current.next;
		}
		a.next=second;
		return first;
	}
	public static void traverse(LinkedListNode h) {
		LinkedListNode currentNode = h;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode h=generateLinkedList();
		LinkedListNode result=solve(h, 19);
		
		
		traverse(result);
	}

}
