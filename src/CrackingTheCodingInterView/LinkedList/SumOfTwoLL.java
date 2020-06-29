package CrackingTheCodingInterView.LinkedList;

public class SumOfTwoLL {
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
	public static LinkedListNode solve(LinkedListNode head1,LinkedListNode head2) {
		LinkedListNode l1=head1;
		LinkedListNode l2=head2;
		
		int carry=0;
		int sum=l1.data+l2.data;
		l1=l1.next;
		l2=l2.next;
		int newCarry=0;
		if(sum>9) {
			newCarry=sum/10;
			sum-=10;
		}
		LinkedListNode newNode=new LinkedListNode(sum+carry);
		LinkedListNode res=newNode;
		 carry=newCarry;
		while(l1!=null&&l2!=null) {
			 sum=l1.data+l2.data+carry;
			 newCarry=0;
			if(sum>9) {
				newCarry=sum/10;
				sum-=10;
			}
			LinkedListNode temp=new LinkedListNode(sum);
			carry=newCarry>0?newCarry : 0;
			newNode.next=temp;
			newNode=newNode.next;
			
			l1=l1.next;
			l2=l2.next;
		}
		while(l1!=null) {
			sum=l1.data+carry;
			 newCarry=0;
			if(sum>9) {
				newCarry=sum/10;
				sum-=10;
			}
			LinkedListNode temp=new LinkedListNode(sum);
			carry=newCarry>0?newCarry : 0;
			newNode.next=temp;
			newNode=newNode.next;
			l1=l1.next;
		}
		while(l2!=null) {
			sum=l2.data+carry;
			 newCarry=0;
			if(sum>9) {
				newCarry=sum/10;
				sum-=10;
			}
			LinkedListNode temp=new LinkedListNode(sum);
			carry=newCarry>0?newCarry : 0;
			newNode.next=temp;
			newNode=newNode.next;
			l2=l2.next;
		}
		if(carry!=0) {
			LinkedListNode temp=new LinkedListNode(carry);
			newNode.next=temp;
			newNode=newNode.next;
		}
		
		System.out.println(res);
		return res;
		
		
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
		int arr1[]= {7,1,6};
		int arr2[]= {5,9,7,1,5};
		LinkedListNode l1=generateLinkedList(arr1);
		LinkedListNode l2=generateLinkedList(arr2);
		
		solve(l1, l2);
	}

}
