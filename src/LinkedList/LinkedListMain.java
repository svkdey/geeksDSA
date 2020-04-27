package LinkedList;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashSet;

public class LinkedListMain {

	// naive solution
	public static void findMiddlesol1(LinkedListNode head, int len) {

		LinkedListNode cur = head;
		if (len == 1 || head == null)
			System.out.println(-1);
		else {
			for (int i = 0; i < len / 2; i++) {
				cur = cur.next;
			}
			System.out.println(cur.data);
		}
	}

	// best solution
	public static void findMiddlesol2(LinkedListNode head, int len) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		if (len == 1)
			System.out.println(-1);
		else {
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			System.out.println(slow.data);
		}
	}

//	naive solution

	// find node len-n+1
	public static void NthNodeFromLast(LinkedListNode head, int len, int n) {
		if (len < n)
			System.out.println(-1);
		else {
			int i = 1;
			LinkedListNode slow = head;
			while (i < len - n + 1) {

				slow = slow.next;
				i++;
			}
			System.out.println(slow.data);
		}
	}

	// best
	public static LinkedListNode NthNodeFromLastSol2(LinkedListNode head, int n) {
		/*
		 * idea is make 1st pointer n position ahead take 2nd pointer at 1st position
		 * loop until 1st pointer reaches null and 2nd pointer will reach the
		 * NthPosition form last
		 */

		LinkedListNode pt2 = head;
		int i = 0;
		while (i < n) {
			if (pt2 == null) {
				System.out.println(-1);
				return null;
			}
			pt2 = pt2.next;
			i++;
		}

		LinkedListNode pt1 = head;
		while (pt2 != null) {
			pt2 = pt2.next;
			pt1 = pt1.next;
		}
		return pt1;

	}

	public static LinkedListNode reverseIterative(LinkedListNode head) {
		if (head == null)
			return head;
		LinkedListNode temp = null;
		LinkedListNode current = head;
		while (current != null) {
			LinkedListNode next = current.next;
			current.next = temp;
			temp = current;
			current = next;
		}
		// equivalent for loop

		/*
		 * for(LinkedListNode cur=head;cur!=null;cur=cur.next){
		 * 
		 * }
		 */

		return temp;
	}

	public static LinkedListNode reverseRecursive(LinkedListNode head) {
		/*
		 * a,b,c,d,e head=a-> recursive(b,c,d,e) it outputs a>b<c<d<e
		 * rev_tail=head.next; head.next=null; rev_tail.next=head; head=rev_head;
		 * 
		 */
		if (head == null || head.next == null)
			return head;
		LinkedListNode rev_head = reverseIterative(head.next);
		LinkedListNode rev_tail = head.next;
		head.next = null;
		rev_tail.next = head;
		head = rev_head;
		return head;

	}

	public static LinkedListNode reverseRecursive1(LinkedListNode current, LinkedListNode prev) {
		/*
		 * a,b,c,d,e head= recursive(a,b,c,d,)e it outputs a<b<c<d>e
		 * 
		 * 
		 */
		if (current == null) {
			return prev;
		} else {
			LinkedListNode next = current.next;
			current.next = prev;
			prev = current;

			return reverseRecursive1(next, prev);
		}
	}

	public static boolean loopDetech(LinkedListNode head) {
		// this approach takes o(n) extra auxuliary space
		// considering no repeatation of element

		HashSet<Integer> l = new HashSet<>();
		LinkedListNode node = head;
		while (node != null) {
			if (l.contains(node.data)) {
				return true;
			} else {
				l.add(node.data);
			}
			node = node.next;
		}
		return false;

	}

	public static boolean loopDetech2(LinkedListNode head) {

		LinkedListNode dummyNode = new LinkedListNode(-1111);
		LinkedListNode ptr1 = head;

		while (ptr1 != null) {
			if (ptr1.next == dummyNode) {
				return true;
			} else {
				LinkedListNode ptr = ptr1.next;
				ptr1.next = dummyNode;
				ptr1 = ptr;
			}
		}
		return false;

	}

	public static boolean floydCycleDetection(LinkedListNode head) {
		if (head == null)
			return false;
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;

	}

	public static LinkedListNode floydCycleDetectionAndDeletionOfloop(LinkedListNode head) {
		if (head == null)
			return head;
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		int flag = 0;
		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
		return head;

	}

	public static void deleteFromRandomPtr(LinkedListNode ref) {
//note u cant have last node's ref as value
		ref.data = ref.next.data;
		ref.next = ref.next.next;

	}

	// method 1
	public static LinkedListNode segrigateOddAndEven(LinkedListNode head) {
		// note u cant have last node's ref as value
		 LinkedListNode evenStart = null; 
		 LinkedListNode evenEnd = null; 
		 LinkedListNode oddStart = null; 
		 LinkedListNode oddEnd = null; 
		 LinkedListNode currentNode = head; 
	          
	        while(currentNode != null) { 
	            int element = currentNode.data; 
	              
	            if(element % 2 == 0) { 
	                  
	                if(evenStart == null) { 
	                    evenStart = currentNode; 
	                    evenEnd = evenStart; 
	                } else { 
	                    evenEnd.next = currentNode; 
	                    evenEnd = evenEnd.next; 
	                } 
	                  
	            } else { 
	                  
	                if(oddStart == null) { 
	                    oddStart = currentNode; 
	                    oddEnd = oddStart; 
	                } else { 
	                    oddEnd.next = currentNode; 
	                    oddEnd = oddEnd.next; 
	                } 
	            } 
	                        // Move head pointer one step in forward direction 
	            currentNode = currentNode.next;     
	        } 
	          
	          
	        if(oddStart == null || evenStart == null) { 
	            return head; 
	        } 
	          
	        evenEnd.next = oddStart; 
	        oddEnd.next = null; 
	        head=evenStart; 
	        return head;
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insertBegin(1);
		l.insertBegin(2);
		l.insertBegin(3);
//		l.addLast(50);
		System.out.println(l);
//		LinkedListNode anotherNode = NthNodeFromLastSol2(l.head, 2);
//		LinkedListNode lastNode = l.lastNode();
//		System.out.println(anotherNode);
//		lastNode.next=anotherNode;
//		System.out.println(l);
		System.out.println(segrigateOddAndEven(l.head));

//		System.out.println(l);

	}

}

/*
 * discussion:
 * 
 *
 * 
 * 
 * 
 * 
 * 
 * 
 */