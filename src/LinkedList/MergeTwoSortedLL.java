package LinkedList;

public class MergeTwoSortedLL {
	public static LinkedListNode mergeTwoSortedLL(LinkedListNode a, LinkedListNode b) {
		LinkedListNode head=null, tail = null;
		// TODO Auto-generated method stub
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.data > b.data) {
			head = b;
			tail = b;
			b = b.next;
		} else {
			head = a;
			tail = a;
			a = a.next;
		}
		while (a != null && b != null) {
			if (a.data >= b.data) {
				tail.next = b;
				tail = b;
				b = b.next;
			} else {
				tail.next = a;
				tail = a;
				a = a.next;
			
			}
		}
		if (a == null)
			tail.next = b;
		else
			tail.next = a;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.insertBegin(15);
		l1.insertBegin(2);
		l1.insertBegin(1);
		l1.addLast(50);
		System.out.println("I/p ==> "+l1);
		LinkedList l2 = new LinkedList();
		l2.insertBegin(30);
		l2.insertBegin(20);
		l2.insertBegin(10);
		l2.addLast(500);
		System.out.println("I/p ==> "+l2);
		System.out.println(mergeTwoSortedLL(l1.head,l2.head));

	}

	

}
