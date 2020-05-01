package LinkedList;

public class InterSectionOfLinkedList {
	/*1.get length of both LLs,let c1 and c2
	 * 2.get c1-c2
	 * 3.move higher length LL1 to c1-c2;
	 * 4.now move LL1 to end as well as LL2 end. if value matches . u find the node
	 * */
	public static boolean interSectionPoint(LinkedListNode h1, LinkedListNode h2) {
		int c1 = 0;
		int c2 = 0;
		LinkedListNode cur1 = h1;
		LinkedListNode cur2 = h2;
		while (cur1 != null) {
			c1++;
			cur1=cur1.next;
		}
		while (cur2 != null) {
			c2++;
			cur2=cur2.next;
		}
		LinkedListNode higher = null;
		LinkedListNode lower = null;
		if (c1 > c2) {
			higher = h1;
			lower = h2;
		} else {
			higher = h2;
			lower = h1;
		}
		int i = 0;
		while (i < Math.abs(c1 - c2)) {
			higher = higher.next;
			i++;
		}
		while (higher != null && lower != null) {
			if (higher == lower) {
				return true;
			}
			higher = higher.next;
			lower = lower.next;

		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		// TODO Auto-generated method stub
		l.insertBegin(1);
		l.insertBegin(2);
		l.insertBegin(3);
		l.addLast(50);
		l.addLast(100);
		System.out.println(l);
		LinkedListNode lNode=LinkedListMain.NthNodeFromLastSol2(l.head,3);
		System.out.println(lNode);
		LinkedList l2 = new LinkedList();
		// TODO Auto-generated method stub
		l2.insertBegin(10);
		l2.insertBegin(12);
//		LinkedListNode lastnode=l2.lastNode();
//		lastnode.next=lNode;
		System.out.println(l2);
		System.out.println(interSectionPoint(l.head, l2.head));
		
	}

}
