package LinkedList;

public class AddTwoLL {

	static LinkedListNode addTwoLists(LinkedListNode first, LinkedListNode second) {
		// Your code here
		LinkedListNode firstRev = LinkedListMain.reverseRecursive1(first, null);
		LinkedListNode secondRev = LinkedListMain.reverseRecursive1(second, null);

		int carry = 0;
		int val = 0;
		LinkedListNode head = null;
		LinkedListNode tail = null;
		while (firstRev != null || secondRev != null) {
			int firstVal = firstRev != null ? firstRev.data : 0;
			int secondVal = secondRev != null ? secondRev.data : 0;
			val = (firstVal + secondVal) + carry;
			if (val / 10 == 1) {
				carry = 1;
				val = val % 10;
			} else {
				carry = 0;
			}
			if (head == null) {
				head = new LinkedListNode(val);
				tail = head;
			} else {
				tail.next = new LinkedListNode(val);
				tail = tail.next;
			}
			secondRev = secondRev != null ? secondRev.next : null;
			firstRev = firstRev != null ? firstRev.next : null;
		}

		if (carry == 1) {
			tail.next = new LinkedListNode(carry);
			tail = tail.next;
		}
		return LinkedListMain.reverseRecursive1(head, null);

	}

	public static void main(String[] args) {
		LinkedList l3 = new LinkedList();
		l3.insertBegin(9);
//		l3.insertBegin(9);
		LinkedList l4 = new LinkedList();
//		l4.insertBegin(1);
//		l4.insertBegin(9);
//		l4.insertBegin(1);
//		l4.insertBegin(5);
//		l4.insertBegin(5);
//		l4.insertBegin(5);
		l4.insertBegin(7);
		l4.insertBegin(8);
		System.out.println("input 1 :" + l3);
		System.out.println("input 2 :" + l4);
		System.out.println(addTwoLists(l3.head, l4.head));
		// TODO Auto-generated method stub

	}

}
